package java8.streams;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FilterEX {

    public static List<Student> filterStudents(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(s->s.getGender().equals("female"))
                .filter(s->s.getGpa() >= 3.9)
                .collect(toList());
    }

    public static void main(String[] args) {

        System.out.println(filterStudents());
    }
}
