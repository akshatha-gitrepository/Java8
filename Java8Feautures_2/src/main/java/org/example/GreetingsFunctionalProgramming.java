package org.example;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GreetingsFunctionalProgramming {

    static Function<String,String> greetings = name ->"Hello ".concat(name);


    static Supplier<String> firstName = () -> "Marco";

    static Predicate<String> areYouMarco = greeting ->
            greeting.equals("Hello Marco");

    static Consumer<String> printGreeting = greeting ->System.out.println(greeting);

    static Consumer<String> printGreetingUnknown = greeting ->
            System.out.println(greeting.concat(", I don't know who you're"));

  public static void main(String[] args){
      String greeting = greetings.apply(firstName.get());

      if (areYouMarco.test(greeting))
          printGreeting.accept(greeting);
      else
          printGreetingUnknown.accept(greeting);
  }
}
