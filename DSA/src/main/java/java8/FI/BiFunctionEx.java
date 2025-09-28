package java8.fi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionEx {

    static BiFunction<List<Student>, Predicate<Student>, Map<String,Double>> studentGradeMap = ((studentList, integerPredicate) -> {
        Map<String,Double>  gradeMap = new HashMap<>();
        studentList.forEach(s->{
            if (integerPredicate.test(s)) {

                gradeMap.put(s.getName(),s.getGpa());
              }
            }
        );
        return gradeMap;
    });


    public static void main(String[] args) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        System.out.println(studentGradeMap.apply(studentList,PredicateConsumer.p2));

    }
}
