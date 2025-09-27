package dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LinkedList ls = new LinkedList(10);
        ls.printList();
        ls.getHead();
        ls.getLength();
        ls.getTail();

        ls.append(2);
        ls.printList();

        List<Integer> numList = Arrays.asList(1,2,3,3,4,4,5,6,7,7);

        numList.stream()
                .collect(Collectors.toSet()).forEach(System.out::println);
    }




}