package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SmokeTests extends BaseTest {

    @Test
    public void signInTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits();
    }

    @Test
    public void signUpTest() {
        mainSteps
                .openSignUpPage()
                .signUpPageWithValidCredits();
    }

    @Test
    public void addWorkoutTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openAddWorkout();
    }


}
