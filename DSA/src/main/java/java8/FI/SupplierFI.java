package java8.fi;

import java.util.List;
import java.util.function.Supplier;

public class SupplierFI {

    static Supplier<List<Student>> getStudents = ()-> StudentDataBase.getAllStudents();

    public static void main(String[] args) {

        System.out.println(getStudents.get());
    }
}
