package java8.streams;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsEx {

    public static void main(String[] args) {

        Predicate<Student> p1 = student -> student.getGradeLevel()>=3;
        Predicate<Student> p2 = student -> student.getGpa()>=3.9;

        Map<String, List<String>> studentActivity = StudentDataBase.getAllStudents()
                .stream()
                .filter(p1)
                .filter(p2)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentActivity);
    }
}
