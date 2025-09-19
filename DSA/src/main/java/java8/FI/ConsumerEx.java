package java8.FI;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerEx {

    static Consumer<Student>  c1= p -> System.out.println(p);

    static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());

    public static void printName(){
        List<Student> stlist = StudentDataBase.getAllStudents();
        stlist.forEach(c1);

        //stlist.forEach(c2.andThen(c3));

        stlist.forEach(s->{
            if(s.getGradeLevel()>=3 && s.getGpa()>3.9){
                c2.andThen(c3).accept(s);
            }
        });

    }

    public static void main(String[] args) {

        //Consumer
        Consumer<String> consumer = (s)-> {
            System.out.println(s.toLowerCase());
        };

        consumer.accept("AKSHATHA");

        printName();




        //BiConsumer
        BiConsumer<Integer,Integer> multiply = (a,b)->{
            System.out.println("Multiplication is:" + (a*b));
        };

        BiConsumer<Integer,Integer> division = (a,b)->{
            System.out.println("Division is :" + (a/b));
        };

        multiply.andThen(division).accept(6,3);
    }
}
