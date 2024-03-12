package org.example.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReferencingAStream {

    public static void main(String[] args) {

        Stream<String> stream =Stream.of("a","b","c").filter(e->e.contains("b"));
        Optional<String> anyElement = stream.findAny();
    //    Optional<String> firstElement =stream.findFirst();
    //throws illegalstateexception because streams cannot be reused
        System.out.println(anyElement);
        //   System.out.println(firstElement);

        List<String> elements = Stream.of("a","b","c").filter(e->e.contains("c"))
                .toList();
        Optional<String> anyElement1 = elements.stream().findAny();
        Optional<String> firstElement2 =elements.stream().findFirst();
        System.out.println(anyElement1);
        System.out.println(firstElement2);

        //Stream pipeline

        //example

        Stream<String> list = Stream.of("abcd","bbcd","vvfg").skip(1);
        list.forEach(System.out::println);

        Stream<String> modifiedStream = Stream.of("abcd","bbcd","vvfg").skip(1).map(e->e.substring(0,3));
        modifiedStream.forEach(System.out::println);

        List<String> items = Arrays.asList("bdbbd","gdsgv","djkhf");
        long size=items.stream().skip(1).map(e->e.substring(0,3)).sorted().count();
        System.out.println(size);


    }
}
