package java8.fi;

import java.util.function.Predicate;

public class PredicateEx {
    static Predicate<Integer> p1 = (n) -> n % 2 == 0;

    static Predicate<Integer> p2 = (n) -> n % 5 == 0;

    public static void main(String[] args) {

        System.out.println("Predicate 1: " + p1.test(10));
        System.out.println("Predicate 2: " + p2.test(10));
        System.out.println("Predicate 1 and Predicate 2: " + p1.and(p2).test(10));
        System.out.println("Predicate 1 or Predicate 2: " + p1.or(p2).test(10));
        System.out.println("Predicate 1 negate: " + p1.negate().test(10));
        System.out.println("Predicate 2 negate: " + p2.negate().test(10));
        System.out.println("Predicate 1 and Predicate 2 negate: " + p1.and(p2).negate().test(10));
        System.out.println("Predicate 1 or Predicate 2 negate: " + p1.or(p2).negate().test(10));

    }

}
