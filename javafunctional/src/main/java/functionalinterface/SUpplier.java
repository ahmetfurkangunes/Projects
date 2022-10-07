package functionalinterface;


import java.util.List;
import java.util.function.Supplier;

public class SUpplier {
    public static void main(String[] args){
    System.out.println(getDBConnectionUrl());
    System.out.println(getDBConnectionUrlSupplier.get());
    }
    static String getDBConnectionUrl () {
        return "jdbc://localhost:5432/users";
    }
    static Supplier<List<String>> getDBConnectionUrlSupplier  = () -> {
         return List.of ("jdbc://localhost:5432/users", "jdbc://localhost:5432/customer");
         

    };
    
}
