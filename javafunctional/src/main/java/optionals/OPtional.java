package optionals;

import java.util.Optional;

public class OPtional {
    public static void main(String[] args){
            Optional.ofNullable(null).ifPresentOrElse(email -> System.out.println("Sending email to " + email), () -> {
            System.out.println("Cannot send e-mail");
        });
        
    }
    
}
