package java8.Optional;

import java8.fi.Student;
import java8.fi.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseEx {

    static String getDefaultValue() {
        System.out.println("getDefaultValue() called"); //lazily evaluated by orElseGet() and eagerly by orElse()
        return "Default";
    }

    public static String optionalOrElse() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = studentOptional.map(Student::getName).orElse(getDefaultValue());
        return name;
    }

    public static String optionalOrElseGet() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        String name = studentOptional.map(Student::getName).orElseGet(()->getDefaultValue());
        return name;
    }

    public static String optionalOrElseThrow(){
        Optional<Student> studentOptional = Optional.ofNullable(null);
        String name = studentOptional.map(Student::getName)
                .orElseThrow(()-> new RuntimeException("No Data available"));
        return name;
    }


    public static void main(String[] args) {

        System.out.println("orElse :  "+optionalOrElse());
        System.out.println("orElseGet:  "  + optionalOrElseGet());
        System.out.println("orElseThrow:  "  + optionalOrElseThrow());
    }
}
