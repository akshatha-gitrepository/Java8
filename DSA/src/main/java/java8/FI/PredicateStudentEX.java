package java8.fi;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentEX {

    static Predicate<Student> p1 = p -> p.getGpa() > 3.9;
    static Predicate<Student> p2= p -> p.getGradeLevel() >=3;

    public static void filterByGradeLevel(){
        System.out.println("Filter Student By GPA Level:");
        List<Student> studentList = StudentDataBase.getAllStudents();
       studentList.forEach(s->{
           if(p1.test(s))
               System.out.println(s);
       });

    }

    public void filterbyGPA(){
        System.out.println("Filter Student By Grade Level:");

        List<Student> studentList = StudentDataBase.getAllStudents();

         studentList.forEach(student -> {
            if(p2.test(student))
              System.out.println(student);

         });
    }

    public void filterStudents(){
        System.out.println("Filter Student By Grade and GPA Level:");

        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if((p1.or(p2)).negate().test(student)) {
       //     if((p1.and(p2)).test(student)) {
                System.out.println(student);
            }else{
                System.out.println(student);
            }
        }));
    }

    public static void main(String[] args) {

        PredicateStudentEX ex = new PredicateStudentEX();
        ex.filterbyGPA();
        filterByGradeLevel();
        ex.filterStudents();
    }



}
