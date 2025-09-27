package java8.fi;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateConsumer {

    static Predicate<Student> p1 = student -> student.getGpa()>=3.9;
    static Predicate<Student> p2 = student -> student.getGradeLevel()>=3;

    BiConsumer<String, List<String>> studentBiConsumer = (n, a)-> System.out.println(n + ":" + a);

    BiPredicate<Integer,Double> studentBiPredicate = (n,a)-> n>=3 && a>=3.9;

    Consumer<Student> studentConsumer = student -> {
        if(p1.and(p2).test(student)){
            studentBiConsumer.accept(student.getName(),student.getActivities());
        }
    };

    Consumer<Student> studentBiPredicateEx = student -> {
        if(studentBiPredicate.test(student.getGradeLevel(),student.getGpa())){
            studentConsumer.accept(student);
        }
    };

    public void printNameAndActivities(List<Student> studentList){

       // studentList.forEach(studentConsumer);
        studentList.forEach(studentBiPredicateEx);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDataBase.getAllStudents();

        new PredicateConsumer().printNameAndActivities(studentList);

    }

}
