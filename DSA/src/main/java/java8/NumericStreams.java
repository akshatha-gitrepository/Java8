package java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreams {

    public static int sum(List<Integer> num){
        return num.stream()
                .reduce(0,(x,y)->x+y);
    }

    public static int sumOfIntStream(){
        return IntStream.rangeClosed(1,6)
                .sum();
    }

    public static List<Integer> boxedintStream(){
        return IntStream.rangeClosed(1,10)
                //int-->Integer
                .boxed()
                .collect(Collectors.toList());
    }

    public static int unboxedSum(List<Integer> num){
        return num.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static List<Integer> mapTOObj(){
        return IntStream.rangeClosed(1,5)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static long mapTOLong(){
        return IntStream.rangeClosed(1,5)
                .mapToLong(Integer::valueOf)
                .sum();
    }

    public static double mapTODouble(){
        return IntStream.rangeClosed(1,5)
                .mapToDouble(Integer::valueOf)
                .sum();
    }




    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,4,5);
        System.out.println(sum(integerList));
        System.out.println(sumOfIntStream());
        IntStream.range(1,10).asDoubleStream().forEach(System.out::println);

        OptionalDouble optionalDouble = IntStream.range(1,10).average();
        System.out.println("Result :" +( optionalDouble.isPresent() ? optionalDouble.getAsDouble(): 0));

        System.out.println("Boxed value:" + boxedintStream());

        System.out.println("Sum of Boxed value:" + unboxedSum(boxedintStream()));
        System.out.println("Double val:"+ mapTODouble());
        System.out.println("Long val:"+ mapTOLong());
        System.out.println("Object: " + mapTOObj());

    }
}
