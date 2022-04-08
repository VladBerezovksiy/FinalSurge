package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.tests.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInAndSignUpTests extends BaseTest {

    @Test(groups = "negative")
    public void signInWithInvalidCreditsTest() {
        singInSteps
                .openLoginPage()
                .loginWithInvalidCredits();

        singInSteps
                .openLoginPage()
                .loginWithInvalidEmail();

        singInSteps
                .openLoginPage()
                .loginWithInvalidPassword();

        singInSteps
                .openLoginPage()
                .loginWithEmptyEmailField();

        singInSteps
                .openLoginPage()
                .loginWithEmptyPasswordField();
    }

    @Test(dataProvider = "inputForSignUpTask", dataProviderClass = DataProviders.class, groups = "negative")
    @Description("Check a=that all fields are required")
    public void checkRequiredFieldsTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .openSignUpPage()
                        .returnSignUpRequiredMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }

    @Test(dataProvider = "inputForCheckPasswordTask", dataProviderClass = DataProviders.class, groups = "negative")
    @Description("Check that the password matches the rules and retype password field")
    public void checkPasswordTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .openSignUpPage()
                        .returnSignUpErrorPasswordMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }
}
