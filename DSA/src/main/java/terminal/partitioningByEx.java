package terminal;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

public class partitioningByEx {

    public static void main(String[] args) {
        Predicate<Student> gpaStudent = student->student.getGpa() >= 4;

        Map<Boolean, List<Student>> studentListBygpa =StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaStudent));

        System.out.println(studentListBygpa);

        Map<Boolean, Set<Student>> studentListBygpatoSet =StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaStudent,toSet()));

        System.out.println(studentListBygpatoSet);

    }
}
