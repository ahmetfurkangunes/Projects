package combinatorpattern;

import java.time.*;


public class CustomerValidator {
    private boolean isEmailValid(String email){
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+0");
    }
    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }
    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail()) && isPhoneNumberValid(customer.getPhone()) && isAdult(customer.getDob());
            }
}
