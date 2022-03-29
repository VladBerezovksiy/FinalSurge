package finalsurge.tests;

import org.testng.annotations.Test;

public class ExampleTest extends BaseTest {

    @Test
    public void example1() {
        mainSteps.
                openFinalSurge()
                .loginWithValidCredits();
    }

    @Test
    public void example2() {
        mainSteps.
                openFinalSurge()
                .loginWithInvalidCredits();
    }

    @Test
    public void example3() {
        mainSteps.
                openFinalSurge()
                .loginWithInvalidEmail();
    }

    @Test
    public void example4() {
        mainSteps.
                openFinalSurge()
                .loginWithInvalidPassword();
    }

    @Test
    public void example5() {
        mainSteps.
                openFinalSurge()
                .loginWithEmptyEmailField();
    }

    @Test
    public void example6() {
        mainSteps.
                openFinalSurge()
                .loginWithEmptyPasswordField();
    }
}
