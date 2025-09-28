package java8.fi;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BinaryOperatorFI {

    static Comparator<Integer> comparator = (a,b) -> a.compareTo(b);

    static UnaryOperator<String> unaryOperator = s->s.concat("world");

    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a,b)->a+b;

        System.out.println(binaryOperator.apply(3,5));

        BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
        System.out.println("Max :" + maxBy.apply(3,6));

        BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
        System.out.println("Min :" + minBy.apply(6,8));


        System.out.println(unaryOperator.apply("Hello "));
    }
}
