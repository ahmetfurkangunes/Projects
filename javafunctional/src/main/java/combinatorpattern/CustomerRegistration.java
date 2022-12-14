package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static combinatorpattern.CustomerRegistration.*;
import static combinatorpattern.CustomerRegistration.ValidationResult.*;

public interface CustomerRegistration extends Function <Customer, ValidationResult>{
    static CustomerRegistration isEmailValid () {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
        
    }
    static CustomerRegistration isPhoneNumberValid () {
        return customer -> customer.getPhone().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegistration isAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : IS_NOT_AN_ADULT;
    }
    default CustomerRegistration and (CustomerRegistration other) {
        return customer ->{
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }
    
    enum ValidationResult{
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
    }
    
}
