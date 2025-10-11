package java8.streams;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsComparatorEX {

    public static List<Student> sortedOrderByName(){

        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparingDouble(Student::getGpa))
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {

        sortedOrderByName().forEach(System.out::println);
    }
}
