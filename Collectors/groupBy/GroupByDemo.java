package org.example.Collectors.groupBy;

import org.apache.maven.surefire.shared.lang3.tuple.ImmutablePair;
import org.apache.maven.surefire.shared.lang3.tuple.Pair;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class GroupByDemo {
    public static void main(String[] args) {
        List<BlogPost> posts = Arrays.asList(
                new BlogPost("10 Best Practices for Java Developers", "John Doe", BlogPostType.GUIDE, 150),
                new BlogPost("New Features in Android 12", "Jane Smith", BlogPostType.NEWS, 200),
                new BlogPost("Movie Review: The Matrix Resurrections", "Chris Evans", BlogPostType.REVIEW, 80),
                new BlogPost("How to Bake a Perfect Chocolate Cake", "Emily Johnson", BlogPostType.GUIDE, 120),
                new BlogPost("Top 5 Destinations for Solo Travelers", "Michael Brown", BlogPostType.GUIDE, 180)
        );

        Map<BlogPostType, List<BlogPost>> blogs = posts.stream().collect(groupingBy(BlogPost::getType));
        blogs.forEach((k, v) -> {
                    System.out.println("BlogPost Type:" + k);
                    v.forEach(c -> System.out.println(c.toString()));
                }
        );
        //groupingBy with a Complex Map Key Type
        Map<Pair<BlogPostType, String>, List<BlogPost>> postPerTypeandAuthor = posts.stream()
                .collect(groupingBy(post -> new ImmutablePair<>(post.getType(), post.getAuthor())));

        Map<Tuple, List<BlogPost>> postTupleList = posts.stream().collect(
                groupingBy(post -> new Tuple(post.getType(), post.getAuthor()))
        );

        Map<BlogPost.AuthPostTypesLikes, List<BlogPost>> authPostTypesLikesListMap =
                posts.stream().collect(groupingBy(post -> new BlogPost.AuthPostTypesLikes(post.getAuthor()
                        , post.getType(), post.getLikes())));
        authPostTypesLikesListMap.forEach((k, v) -> {
                    System.out.println("BlogPost Type:" + k);
            //  v.forEach(c-> System.out.println(c.toString()));
                }
        );
        System.out.println("///");
        //Modifying the Returned Map Value Type
        Map<BlogPostType, Set<BlogPost>> postSetMap = posts.stream().collect(groupingBy(BlogPost::getType, Collectors.toSet()));
        System.out.println(postSetMap);
        System.out.println("//");
        //Grouping by Multiple Fields
        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream().collect(groupingBy(BlogPost::getAuthor,
                groupingBy(BlogPost::getType)));
        map.forEach((k, v) -> {
            System.out.println("author:" + k + "BlogPost :"+v);
        });
        System.out.println("///");

        Map<BlogPostType, Double> averageLikesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));

        Map<BlogPostType, Integer> likesPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));

        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType =posts.stream()
                .collect(groupingBy(BlogPost::getType,maxBy(Comparator.comparingInt(BlogPost::getLikes))));
        //Aggregating Multiple Attributes of a Grouped Result
        //The first approach is to use Collectors::collectingAndThen for the downstream collector of groupingBy.
        Map<BlogPostType, IntSummaryStatistics> likeStatisticsPerType = posts.stream()
                .collect(groupingBy(BlogPost::getType,
                        summarizingInt(BlogPost::getLikes)));
        likeStatisticsPerType.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println("///");
        Map<String,BlogPost.PostCountsTitlesLikesStats> postPerTypeAndAuthor = posts.stream().collect(groupingBy(BlogPost::getAuthor,
                collectingAndThen(toList(), list->{
                    long count= list.stream().map(BlogPost::getTitle).count();
                    String title=list.stream().map(BlogPost::getTitle).collect(joining(" : "));
                    IntSummaryStatistics intSummaryStatistics = list.stream().collect(summarizingInt(BlogPost::getLikes));
                    return new BlogPost.PostCountsTitlesLikesStats(count,title,intSummaryStatistics);

                })));
        postPerTypeAndAuthor.forEach((k,v)-> System.out.println("author :" + k +"  Summary :"+v));
        System.out.println("////");
        //We can also do more sophisticated aggregations if we use Collectors::toMap to collect and aggregate the elements of the stream.

        int maxValue=19;
        Map<String,BlogPost.TitleBoundedSumOfLikes> postsPerAuthor = posts.stream().collect(toMap(BlogPost::getAuthor,post->
        {
            int likes=(post.getLikes()>maxValue)? maxValue: post.getLikes();
            return new BlogPost.TitleBoundedSumOfLikes(post.getTitle(),likes);
        },(u1,u2)->{
            int likes=(u2.boundedSumOfLikes()>maxValue)?maxValue:u2.boundedSumOfLikes();
            return new BlogPost.TitleBoundedSumOfLikes(u1.title().toUpperCase() +" : " +u2.title().toUpperCase(),
                    u1.boundedSumOfLikes() + likes);
        }));
        for (String key : postsPerAuthor.keySet()) {
            System.out.println(key + " : " + postsPerAuthor.get(key));
        }
        System.out.println("///");
        //Modifying the Return Map type
        EnumMap<BlogPostType,List<BlogPost>> postsPerType= posts.stream().collect(
                groupingBy(BlogPost::getType,()->new EnumMap<>(BlogPostType.class),toList()));
        postsPerType.forEach((k,v)->System.out.println("type :" + k +"  BlogPost :"+v));
        //Concurrent groupingBy Collector
        ConcurrentMap<BlogPostType,List<BlogPost>> postTypeListConcurrentMap =posts.parallelStream()
                .collect(groupingByConcurrent(BlogPost::getType));


    }
}