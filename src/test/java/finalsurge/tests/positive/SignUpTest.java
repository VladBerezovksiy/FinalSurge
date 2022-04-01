package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test (dataProvider = "Input data for valid reg", dataProviderClass = DataProviders.class)
    public void createNewUser(String firstname, String lastname, String email, String password, String retypePassword) {
        mainSteps
                .openFinalSurge()
                .openSignUpPage()
                .signUpWithValidCredits( firstname,  lastname,  email,  password,  retypePassword);
    }
}
