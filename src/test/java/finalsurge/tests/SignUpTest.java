package finalsurge.tests;

import constants.SignUpPageConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SignUpTest extends BaseTest {
     @Test
    public void createNewUser() {
        mainSteps
                .openFinalSurge()
                .openSignUpPage()
                .signUp(SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST,
                        SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.PASSWORD_CONST, SignUpPageConstants.RETYPE_PASSWORD_CONST);
    }

    @DataProvider(name = "Input data for auth")
    public Object[][] inputForSignUpTask() {
        return new Object[][]{

                {"", SignUpPageConstants.LASTNAME_CONST, SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.PASSWORD_CONST, SignUpPageConstants.RETYPE_PASSWORD_CONST, SignUpPageConstants.REQUIRED_FIELD_MESSAGE, "The text message when firstname is absent  is not correct"},
                {SignUpPageConstants.FIRSTNAME_CONST,"", SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.PASSWORD_CONST, SignUpPageConstants.RETYPE_PASSWORD_CONST, SignUpPageConstants.REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST, "", SignUpPageConstants.PASSWORD_CONST, SignUpPageConstants.RETYPE_PASSWORD_CONST, SignUpPageConstants.REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
                {SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST, SignUpPageConstants.EMAIL_CONST, "", SignUpPageConstants.RETYPE_PASSWORD_CONST, SignUpPageConstants.REQUIRED_FIELD_MESSAGE, "The text message when password is absent  is not correct"},
                {SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST, SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.PASSWORD_CONST, "", SignUpPageConstants.REQUIRED_FIELD_MESSAGE, "The text message when credentials are wrong is not correct"},
        };
    }

    @DataProvider(name = "Input data for checking password and retypePassword")
    public Object[][] inputForCheckPasswordTask() {
        return new Object[][]{

                {SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST, SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.WRONG_PASSWORD_CONST, SignUpPageConstants.WRONG_PASSWORD_CONST, SignUpPageConstants.WRONG_PASSWORD_MESSAGE, "The text message when password is incorrect  is not correct"},
                {SignUpPageConstants.FIRSTNAME_CONST, SignUpPageConstants.LASTNAME_CONST, SignUpPageConstants.EMAIL_CONST, SignUpPageConstants.PASSWORD_CONST, SignUpPageConstants.WRONG_RETYPE_PASSWORD_CONST, SignUpPageConstants.WRONG_RETYPE_PASSWORD_MESSAGE, "The text message when password isn't matched retype password  is not correct"},
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
