package java8.terminal;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class joiningEX {

    public static String joining(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining(","));
    }

    public static long count(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(counting());// .count();
    }

    public static long countLong(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGpa()>=3.9)
                .map(Student::getName)
                .collect(counting());
    }


    public static Optional<Student> minBy_Ex(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxBy_Ex(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));
    }

    public static int sumEx(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static double avgEx(){
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.averagingInt(Student::getNoteBooks));
    }

    public static void main(String[] args) {
        System.out.println("Joining ex: "+ joining());

        System.out.println("Count of students :" + count());

        System.out.println("Count of students :" + countLong());

        List<String> genderList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping((Student::getGender),toList()));
        genderList.forEach(System.out::println);

        System.out.println(maxBy_Ex());
        System.out.println(minBy_Ex());
        System.out.println(sumEx());
        System.out.println(avgEx());
    }
}
