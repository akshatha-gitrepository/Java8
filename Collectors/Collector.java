package org.example.Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.teeing;

public class Collector {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,3,4,5,6);

        Optional<Integer> max;
        max = numbers.stream().max(Integer::compareTo);
        System.out.println(max);
        ///
        List<String> words = Arrays.asList("apple", "banana", "orange", "pineapple", "grape");
        Optional<String> longestWord = words.stream().max(Comparator.comparingInt(String::length));
        System.out.println(longestWord);
        //teeing
        List<Integer> numberList = List.of(1,4,7,3,8);
        Long avg=numberList.stream()
                .collect(teeing(Collectors.summingInt(Integer::intValue),
                Collectors.counting(),
                (s,c)->s/c));
        System.out.println(avg);

        String str = "Hello, world!";
        IntStream stream =str.chars();
        stream.forEach(System.out::println  );



    }
}
