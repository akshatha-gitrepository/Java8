package java8.MR;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceEx {
    static Function<String,String> lambda = (s)->s.toLowerCase();

    static Function<String,String> methRef = String::toLowerCase;

    static Consumer<Student> c1 = System.out :: println;
    static Consumer<Student> c2 = Student::printAllActivities;


    public static void main(String[] args) {
        System.out.println(methRef.apply("AKSHATHA"));

        StudentDataBase.getAllStudents().forEach(c1);
        StudentDataBase.getAllStudents().forEach(c2);
    }
}
