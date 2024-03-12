package org.example.PrimitiveStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStream {
    public static void main(String[] args) {
        int[] a= new int[]{10,20,30,40,50};
        int min= Arrays.stream(a).min().getAsInt();

        int max = IntStream.of(2,3,5,6).max().getAsInt();
        int maximum = IntStream.of(2,3,5,6).sum();

        double avg = IntStream.of(1,2,3,4,5).average().getAsDouble();
        int sum1 = IntStream.range(1, 10).sum();

        int sum2 = IntStream.rangeClosed(1, 10).sum();

        IntStream.rangeClosed(1, 5).parallel().forEach(System.out::println);

        List<Integer> integerList= IntStream.rangeClosed(1,9).filter(i->i%2==0)
                .boxed().toList();

        IntStream intStream = Arrays.stream(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
                .flatMapToInt(Arrays::stream);




    }
}
