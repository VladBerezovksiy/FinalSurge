package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SignInWithInvalidCreditsTest extends BaseTest {

    @Test
    public void signInWithInvalidCreditsTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidCredits();
    }
}
