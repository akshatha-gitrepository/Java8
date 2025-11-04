package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MinMaxEx {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(6,7,8,9,10);

        Optional<Integer> minResult = Min(integers);
        System.out.println("Min:" + minResult.get());

        Optional<Integer> maxResult = Max(integers);
        System.out.println("Max:" + maxResult.get());

    }

    private static Optional<Integer> Max(List<Integer> integers) {
        return integers.stream()
                .reduce(Integer::max);
    }

    private static Optional<Integer> Min(List<Integer> integers) {
        return integers.stream()
                .reduce(Integer::min);
    }
}
