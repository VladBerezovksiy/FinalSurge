package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import finalsurge.tests.DataProviders;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test (dataProvider = "inputForValidRegTask", dataProviderClass = DataProviders.class, groups="smoke")
    public void createNewUser(String firstname, String lastname, String email, String password, String retypePassword) {
        mainSteps
                .openLoginPage()
                .openSignUpPage()
                .signUpWithValidCredits( firstname,  lastname,  email,  password,  retypePassword);
    }

}