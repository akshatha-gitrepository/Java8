package java8.streams;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlatMapEx {

    public static List<String> printStudentActivities(){

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(printStudentActivities());
    }
}
