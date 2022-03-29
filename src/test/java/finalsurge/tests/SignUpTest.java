package finalsurge.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SignUpTest extends BaseTest {
    private static final String firstname = "Tom";
    private static final String lastname = "Rich";
    private static final int random = (int) (Math.random() * 1000);
    private static final String email = "test" + random + "@gmail.com";
    private static final String password = "1qaz2WSX";
    private static final String retypePassword = "1qaz2WSX";
    private static final String wrongpassword = "12345678";
    private static final String wrongretypePassword = "1qaz22345";

    public static final String REQUIRED_FIELD_MESSAGE = "This field is required.";
    public static final String WRONG_PASSWORD_MESSAGE = "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.";
    public static final String WRONG_RETYPE_PASSWORD_MESSAGE = "Error: The passwords you entered did not match.";
    @Test
    public void createNewUser() {
        mainSteps
                .openFinalSurge()
                .openSignUpPage()
                .signUp(firstname, lastname, email, password, retypePassword);
    }

    @DataProvider(name = "Input data for auth")
    public Object[][] inputForSignUpTask() {
        return new Object[][]{

                {"", lastname, email, password, retypePassword, REQUIRED_FIELD_MESSAGE, "The text message when firstname is absent  is not correct"},
                {firstname, "", email, password, retypePassword, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {firstname, lastname, "", password, retypePassword, REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
                {firstname, lastname, email, "", retypePassword, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {firstname, lastname, email, password, "", REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
        };
    }

    @DataProvider(name = "Input data for checking password and retypePassword")
    public Object[][] inputForCheckPasswordTask() {
        return new Object[][]{

                {firstname, lastname, email, wrongpassword, wrongpassword, WRONG_PASSWORD_MESSAGE, "The text message when password is incorrect  is not correct"},
                {firstname, lastname, email, password, wrongretypePassword, WRONG_RETYPE_PASSWORD_MESSAGE, "The text message when password isn't matched retype password  is not correct"},
        };
    }

    @Test(dataProvider = "Input data for auth", description="check a=that all fields are required")
    public void checkRequiredFieldsTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps.openFinalSurge()
                        .openSignUpPage()
                        .returnSignUpRequiredMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }

    @Test(dataProvider = "Input data for checking password and retypePassword", description="check that the password matches the rules and retype password field")
    public void checkPasswordTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps.openFinalSurge()
                        .openSignUpPage()
                        .returnSignUpErrorPasswordMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }
}
