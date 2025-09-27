package java8.fi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionEx {

    static Function<String,String> function = n -> n.toUpperCase();
    static Function<String,String> addAtEnd = n->n.toUpperCase().concat("default");
    static Function<List<Student>,Map<String,Double>> studentFunction = (studentList -> {
        Map<String,Double> gradeMap = new HashMap<>();
        studentList.forEach(s->{
            if(PredicateConsumer.p2.test(s)){
            gradeMap.put(s.getName(),s.getGpa());
        }
        });
        return gradeMap;
    });


    public static void main(String[] args) {

        System.out.println("function: " + function.apply("akshatha"));
        System.out.println("result of addThen :" + function.andThen(addAtEnd).apply("java8"));

        List<Student> studentList = StudentDataBase.getAllStudents();
        System.out.println(studentFunction.apply(studentList));
    }

}
