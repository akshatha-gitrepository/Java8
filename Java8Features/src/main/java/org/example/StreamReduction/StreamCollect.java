package org.example.StreamReduction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCollect {

    public static void main(String[] args) {

        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));


        List<String> collectionList =productList.stream()
                .map(Product::getProductName).toList();


        String listToString = productList.stream().map(Product::getProductName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(listToString);

        int summingPrice = productList.stream().mapToInt(Product::getPrice).sum();

        double averagePrice = productList.stream().collect(Collectors.averagingDouble(Product::getPrice));

        IntSummaryStatistics intSummaryStatistics= productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println("IntSummaryStatistics: " + intSummaryStatistics.toString());
        long count = intSummaryStatistics.getCount();
        int sum = (int) intSummaryStatistics.getSum();
        int min = intSummaryStatistics.getMin();
        double average = intSummaryStatistics.getAverage();
        int max = intSummaryStatistics.getMax();

        // Print individual values
        System.out.println("Count: " + count);
        System.out.println("Sum: " + sum);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
        System.out.println("Max: " + max);

        //groupingBY
        Map<Integer,List<Product>> productGroup = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        for (Map.Entry<Integer, List<Product>> entry : productGroup.entrySet()) {
            int price = entry.getKey();
            List<Product> products = entry.getValue();

            System.out.println("Price: " + price);
            System.out.println("Products: " + products);
            for(Product p:products){
                System.out.println(p.getProductName());
            }
            System.out.println();
        }


        //partitioningBy
        Map<Boolean,List<Product>> productPartition =productList.stream()
                .collect(Collectors.partitioningBy(e->e.getPrice()>15));

        for (Map.Entry<Boolean, List<Product>> entry : productPartition.entrySet()) {
            Boolean price = entry.getKey();
            List<Product> product = entry.getValue();

            System.out.println("Price: " + price);
            System.out.println("Products: " + product);

            System.out.println();
        }

        //collectingAndThen
        Set<Product> productSet =productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),Collections::unmodifiableSet));

        //parallelStream

        Stream<Product> productStream =productList.parallelStream();
        boolean isParallel = productStream.isParallel();
        boolean bigPrice = productStream.map(e->e.getPrice()*12).anyMatch(p->p>200);
        System.out.println(bigPrice);

        //if source other than Collection or array use parallel

        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallelStream = intStreamParallel.isParallel();

        
    }
}
