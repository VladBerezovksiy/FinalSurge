package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
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

    @Test
    public void sigUpWithInvalidCreditsTest() {
        mainSteps
                .openSignUpPage()
                .signUpPageWithInvalidCredits();
    }


    // Дописать остальные тесты 'Sign up' page!!!!!!



}
