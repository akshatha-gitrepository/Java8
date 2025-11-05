package java8.Optional;

import java8.fi.Bike;
import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapEx {

    public static void optionalFilter(){
        Optional<Student> studentOptional = StudentDataBase.getOptionalStudent()
                .filter(s->s.getGpa()>=3.5);
        studentOptional.ifPresent(s-> System.out.println(s));
    }

    public static void optionalMap(){
        Optional<Student> optionalStudent = StudentDataBase.getOptionalStudent();
        if(optionalStudent.isPresent()){
            Optional<String> nameOptional = optionalStudent
                    .map(Student::getName);
            System.out.println("nameOptional : " + nameOptional.get());
        }
    }

    public static void optionalFlatMap(){
        Optional<Student> optionalStudent = StudentDataBase.getOptionalStudent();
        if(optionalStudent.isPresent()){
            Optional<Bike> bikeOptional = optionalStudent
                    .flatMap(Student::getBike);
            System.out.println("nameOptional : " + bikeOptional.get().getName());
        }
    }

    public static void main(String[] args) {
        optionalFilter();
        optionalMap();
        optionalFlatMap();
    }
}
