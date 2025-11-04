package terminal;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class groupingByEx {

    public static void groupByGender(){
        Map<String, List<Student>> stringListMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));


        Stream.of(stringListMap).forEach(System.out::println);
    }

    public static void customizedGroupingBy(){
        Map<String,List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(s->s.getGpa() > 3.5 ? "outstanding" : "average"));

        Stream.of(studentMap).forEach(System.out::println);
    }

    public static void twoLevelGrouping_1(){
       Map<Integer, Map<String,List<Student>>> studentList = StudentDataBase.getAllStudents()
               .stream()
               .collect(groupingBy(Student::getGradeLevel,groupingBy(s->s.getGpa()>3.5 ? "good" : "avg")));

       Stream.of(studentList).forEach(System.out::println);
       
    }

    public static void twolevelGrouping_2(){
        Map<String,Integer> groupByNotebook = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName,summingInt(Student::getNoteBooks)));

        System.out.println(groupByNotebook);
    }

    public static void main(String[] args) {
        groupByGender();
        twoLevelGrouping_1();
        twolevelGrouping_2();
    }
}
