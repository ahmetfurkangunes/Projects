package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistration.*;



public class Main {

    public static void main(String[] args){
        Customer customer = new Customer
        ( "Ahmet Furkan",
          "furkanngunes@gmail.com",
          "+0235678906644",
          LocalDate.of(2001,6, 19));
          System.out.println(new CustomerValidator().isValid(customer));

          // if valid we can store customer in db
          // Using combinator pattern
           ValidationResult result = CustomerRegistration.isEmailValid().and(CustomerRegistration.isPhoneNumberValid()).and(CustomerRegistration.isAdult()).apply(customer);
        
        
         System.out.println(result);
         if (result != ValidationResult.SUCCESS){
            throw new IllegalArgumentException(result.name());
         }
    }

    
    

    
}
