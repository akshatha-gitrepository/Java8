package org.example.Optional;

import java.util.Objects;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args){

        Function<Integer,String> intToString= Object ::toString;

        Function<String,String> qoute= s -> "'" +s+ "'";

        Function<Integer,String> qouteInttoString= qoute.compose(intToString);

        System.out.println(qouteInttoString.apply(10));

    }
}
