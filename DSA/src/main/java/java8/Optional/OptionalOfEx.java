package java8.Optional;


import java.util.Optional;

public class OptionalOfEx {

    public static Optional<String> ofNullable(){
       // Optional<String> stringOptional = Optional.ofNullable("Hello");//
        Optional<String> stringOptional = Optional.ofNullable(null);//
        return stringOptional;
    }

    public static Optional<String> of(){
        Optional<String> stringOptional = Optional.of("Hello");
       // Optional<String> stringOptionalWithNull = Optional.of(null);
       // return stringOptionalWithNull; should return a valid value
        return stringOptional;
    }

    public static Optional<String> empty(){
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println(ofNullable().isPresent());
        System.out.println("of value: " + of().get());
        System.out.println(empty());
    }
}
