package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitSkipExample {

    public static Optional<Integer> limit(List<Integer> integers){
        return integers.stream()
                .limit(3)
                .reduce((a,b)->a+b);
    }

    public static Optional<Integer> skip(List<Integer> integers){
        return integers.stream()
                .skip(3)
                .reduce((a,b)->a+b);
    }



    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        Optional<Integer> limitResult = limit(integers);
        limitResult.ifPresent(System.out::println);

        Optional<Integer> skipResult = skip(integers);
        skipResult.ifPresent(System.out::println);

    }
}
