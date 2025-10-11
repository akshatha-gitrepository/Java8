package java8.streams;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceEx {

    public static int mulitiply(List<Integer> a){
        return a.stream().reduce(1,(b,c)->b*c);
    }

    public static Optional<Integer> performWithNoInitalVal(List<Integer> integerList){

        return integerList.stream().reduce((a,b)->a*b);
    }

    public static String combineStudentNames(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .distinct()
                .reduce("",(a,b)->a.concat(b));
    }

    public static Optional<Student> getHighestScore(){
        Optional<Student> studentOptional = StudentDataBase.getAllStudents()
                .stream()
                .reduce((a,b)->(a.getGpa()>b.getGpa())?a:b);

        return  studentOptional;
    }

    public static void main(String[] args) {

        System.out.println(mulitiply(Arrays.asList(1,2,3,4,5)));
        Optional<Integer> res = performWithNoInitalVal(Arrays.asList(1,2,3,4,5));
        if(res.isPresent()){
            System.out.println(res.get());
        }
        else{
            System.out.println("Res is 0");
        }

        System.out.println(combineStudentNames());

        Optional<Student> topStudent = getHighestScore();
        if(topStudent.isPresent())
            System.out.println(topStudent.get());
        else
            System.out.println("No topper in the class");


    }
}
