package java8.terminal;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java8.fi.StudentDataBase.getAllStudents;

public class groupingByEx {

    public static void groupByGender(){
        Map<String, List<Student>> stringListMap = getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));


        Stream.of(stringListMap).forEach(System.out::println);
    }

    public static void customizedGroupingBy(){
        Map<String,List<Student>> studentMap = getAllStudents()
                .stream()
                .collect(groupingBy(s->s.getGpa() > 3.5 ? "outstanding" : "average"));

        Stream.of(studentMap).forEach(System.out::println);
    }

    public static void twoLevelGrouping_1(){
       Map<Integer, Map<String,List<Student>>> studentList = getAllStudents()
               .stream()
               .collect(groupingBy(Student::getGradeLevel,groupingBy(s->s.getGpa()>3.5 ? "good" : "avg")));

       Stream.of(studentList).forEach(System.out::println);
       
    }

    public static void twolevelGrouping_2(){
        Map<String,Integer> groupByNotebook = getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName,summingInt(Student::getNoteBooks)));

        System.out.println(groupByNotebook);
    }

    public static void threeLevelGrouping(){
     LinkedHashMap<String, Set<Student>>  students= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getName, LinkedHashMap::new,toSet()));

     Stream.of(students).forEach(System.out::println);
    }

    public static void calculateToMaxGpa(){

        Map<Integer,Optional<Student>> maxByStudent = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,maxBy(Comparator.comparing(Student::getGpa))));

       // Stream.of(maxByStudent).forEach(System.out::println);

        Map<Integer,Student> maxByOptinalStudent = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println(maxByOptinalStudent);

    }

    public static void calculateToMinGpa(){
        Map<Integer,Student> minByOptinalStudent= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel, collectingAndThen(minBy(Comparator.comparing(Student::getGpa)),Optional::get)));
        System.out.println(minByOptinalStudent);
    }


    public static void main(String[] args) {
        groupByGender();
        twoLevelGrouping_1();
        twolevelGrouping_2();
        threeLevelGrouping();
        calculateToMaxGpa();
        calculateToMinGpa();
    }
}
