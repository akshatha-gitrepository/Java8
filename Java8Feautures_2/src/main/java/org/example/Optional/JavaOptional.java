package org.example.Optional;

import java.util.Optional;

public class JavaOptional {

    public static void main(String[] args){

       // String email="ramesh@gmail.com";
        String email=null;
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        Optional<String> email2 = Optional.of(email);
        System.out.println(email2);

        Optional<String> email1 = Optional.ofNullable(email);
        System.out.println(email1);
//        String defaultOptional= email1.orElse("default@gmail.com");
//        System.out.println(defaultOptional);

        String defaultOptional= email1.orElseGet(()->"default@gmail.com");
        System.out.println(defaultOptional);

//        String defaultOptional1= email1.orElseThrow(()-> new IllegalArgumentException("email not found!!"));
//        System.out.println(defaultOptional1);

//        if(email1.isPresent()){
//            System.out.println("email is present:"+ email1.get());
//        }else {
//            System.out.println("email is not present");
//        }

        Optional<String> gender= Optional.of("Male");
        Optional<String> option = Optional.empty();

        gender.ifPresent((s) -> System.out.println("value is present"));
        option.ifPresent((s) -> System.out.println("value is not present"));
    }

}
