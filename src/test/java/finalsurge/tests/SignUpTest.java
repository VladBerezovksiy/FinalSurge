package finalsurge.tests;

import finalsurge.utils.PropertiesUtils;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    private static final String FIRSTNAME_PARAM = PropertiesUtils.getEnv("firstname_param");
    private static final String LASTNAME_PARAM = PropertiesUtils.getEnv("lastname_param");
    private static final int random = (int) (Math.random() * 1000);
    private static final String EMAIL_PARAM = PropertiesUtils.getEnv("email_login_param") + random + PropertiesUtils.getEnv("email_domain_param");
    private static final String PASSWORD_PARAM = PropertiesUtils.getEnv("password_param");
    private static final String RETYPE_PASSWORD_PARAM = PropertiesUtils.getEnv("retype_password_param");
    private static final String WRONG_PASSWORD_PARAM = PropertiesUtils.getEnv("wrong_password_param");
    private static final String WRONG_RETYPE_PASSWORD_PARAM = PropertiesUtils.getEnv("wrong_retype_password_param");
    private static final String REQUIRED_FIELD_MESSAGE = "This field is required.";
    private static final String WRONG_PASSWORD_MESSAGE = "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.";
    private static final String WRONG_RETYPE_PASSWORD_MESSAGE = "Error: The passwords you entered did not match.";

    @DataProvider(name = "Input data for auth")
    public Object[][] inputForSignUpTask() {
        return new Object[][]{

                {"", LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when firstname is absent  is not correct"},
                {FIRSTNAME_PARAM, "", EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, "", PASSWORD_PARAM, RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, "", RETYPE_PASSWORD_PARAM, REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, "", REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
        };
    }

    @DataProvider(name = "Input data for checking password and retypePassword")
    public Object[][] inputForCheckPasswordTask() {
        return new Object[][]{

                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, WRONG_PASSWORD_PARAM, WRONG_PASSWORD_PARAM, WRONG_PASSWORD_MESSAGE, "The text message when password is incorrect  is not correct"},
                {FIRSTNAME_PARAM, LASTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, WRONG_RETYPE_PASSWORD_PARAM, WRONG_RETYPE_PASSWORD_MESSAGE, "The text message when password isn't matched retype password  is not correct"},
        };
    }

    @Test
    public void createNewUser() {
        mainSteps
                .openFinalSurge()
                .openSignUpPage()
                .signUpWithValidCredits(FIRSTNAME_PARAM, FIRSTNAME_PARAM, EMAIL_PARAM, PASSWORD_PARAM, RETYPE_PASSWORD_PARAM);
    }

    @Test(dataProvider = "Input data for auth")
    @Description("Check a=that all fields are required")
    public void checkRequiredFieldsTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openFinalSurge()
                        .openSignUpPage()
                        .returnSignUpRequiredMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }

    @Test(dataProvider = "Input data for checking password and retypePassword")
    @Description("Check that the password matches the rules and retype password field")
    public void checkPasswordTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openFinalSurge()
                        .openSignUpPage()
                        .returnSignUpErrorPasswordMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }

}
