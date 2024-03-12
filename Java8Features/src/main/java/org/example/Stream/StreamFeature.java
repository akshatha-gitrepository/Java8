package org.example.Stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamFeature {

    public static Stream<String> streamOf(List<String> list){
        return list==null || list.isEmpty()? Stream.empty() :list.stream();
    }

    public static void main(String[] args) throws IOException {

    //1.empty stream
        Stream<String> stream= Stream.empty();

        // System.out.println(stream);

       List<String> list= List.of();

        Stream<String> stringStream = streamOf(list);
        stringStream.forEach(System.out::println);


    //2.Stream of Collecton

        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> stream1 =collection.stream();

        stream1.forEach(System.out::println);
        System.out.println("///////");

    //3.Stream to Array

        Stream<String> stream3= Stream.of("a","b","c");

        String[] arr = new String[]{"a","b","c","d"};
        Stream<String> stream2 = Arrays.stream(arr);

        stream2.forEach(System.out::println);
        System.out.println("///////");
        Stream<String> stream4 = Arrays.stream(arr,1,3);
        stream4.forEach(System.out::println);
        System.out.println("///////");

    //4.Stream.builder
        Stream<String> streamBuilder= Stream.<String>builder()
                .add("abc").add("bbc").add("cdd").build();
        streamBuilder.forEach(System.out::println);
        System.out.println("///////");

     //5.Stream.generate()
        Stream<String> streamGenerate = Stream.generate(()->"element").limit(10);
        streamGenerate.forEach(System.out::println);
        System.out.println("///////");

      //6.Stream.iterate
        Stream<Integer> streamIterated = Stream.iterate(40,n->n+2).limit(20);
        streamIterated.forEach(System.out::println);
        System.out.println("///////");

      //7.Stream of primitives

        IntStream t= IntStream.range(1,6);
        t.forEach(System.out::println);
        System.out.println("///////");
        LongStream l= LongStream.rangeClosed(1,6);
        l.forEach(System.out::println);
        System.out.println("///////");

        Random random=new Random();
        DoubleStream ls=random.doubles(7);
        ls.forEach(System.out::println);
        System.out.println("///////");

      //8.Stream of String

       IntStream streamOfString = "abcd".chars();
       streamOfString.forEach(System.out::println);
        System.out.println("///////");

        //9.Stream of file

        Path path = Paths.get("C:\\Users\\seetha\\Desktop\\text.txt");
        Stream<String> text = Files.lines(path);
        text.forEach(System.out::println);
        System.out.println("///////");
        Stream<String> textwithCharset = Files.lines(path, Charset.forName("UTF-8"));
        textwithCharset.forEach(System.out::println);
        System.out.println("///////");




     }

    }
