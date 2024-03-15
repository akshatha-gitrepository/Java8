package org.example.Collectors.groupBy;

import java.util.IntSummaryStatistics;

public class BlogPost {
    String author;
    String title;
    BlogPostType type;
    int likes;

    record AuthPostTypesLikes(String author,BlogPostType post,int likes){}
    record PostCountsTitlesLikesStats(long postCount, String titles, IntSummaryStatistics likesStats){}

    record TitleBoundedSumOfLikes(String title, int boundedSumOfLikes){}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BlogPostType getType() {
        return type;
    }

    public void setType(BlogPostType type) {
        this.type = type;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public BlogPost(String author, String title, BlogPostType type, int likes) {
        this.author = author;
        this.title = title;
        this.type = type;
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", likes=" + likes +
                '}';
    }


}
