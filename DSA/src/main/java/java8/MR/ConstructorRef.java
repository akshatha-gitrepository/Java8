package java8.MR;

import java8.fi.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ConstructorRef {

    static Supplier<Student> studentSupplier = Student::new;

    static Function<String,Student> studentFunction = Student::new;

    public static void main(String[] args) {

        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("akshatha"));

        List<String> names = Arrays.asList("Arun","Pavan");
        List<Student> studentList = names.stream()
                .map(Student::new).collect(Collectors.toList());


        System.out.println(studentList);

    }
}
