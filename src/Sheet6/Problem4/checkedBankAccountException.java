package Sheet6.Problem4;

import java.io.IOException;

// Inherit from IOException class because it is checked
public class checkedBankAccountException extends IOException {
    public checkedBankAccountException(String error){
        super(error);
    }
}
