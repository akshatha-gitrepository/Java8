package org.example.StreamReduction;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamReduce {
    public static void main(String[] args) {

        OptionalInt intStream = IntStream.range(1,5).reduce((a,b)->a+b);
        intStream.stream().forEach(System.out::println);

       int intStream2 = IntStream.range(1,5).reduce(10,(a,b)->a+b);
        System.out.println(intStream2);

        int streamOfInt = Stream.of(1,2,3).reduce(10,(a,b)->a+b,
                (a,b)->a+b);
        System.out.println(streamOfInt);
        //in order to apply combiner stream needs to be parallel
        int parallelStream = Arrays.asList(1,2,3).parallelStream().reduce(10,(a,b)->a+b,
                (a,b)->a+b);
        System.out.println(parallelStream);
    }


}
