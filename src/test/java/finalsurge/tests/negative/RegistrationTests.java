package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void signInWithInvalidCreditsTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidCredits();
    }

    @Test
    public void signInWithInvalidEmailTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidEmail();
    }

    @Test
    public void signInWithInvalidPasswordTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidPassword();
    }

    @Test
    public void signInWithEmptyEmailFieldTest() {
        mainSteps
                .openLoginPage()
                .loginWithEmptyEmailField();
    }

    @Test
    public void signInWithEmptyPasswordFieldTest() {
        mainSteps
                .openLoginPage()
                .loginWithEmptyPasswordField();
    }

    @Test(dataProvider = "Input data for auth", dataProviderClass = DataProviders.class)
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

    @Test(dataProvider = "Input data for checking password and retypePassword", dataProviderClass = DataProviders.class)
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
