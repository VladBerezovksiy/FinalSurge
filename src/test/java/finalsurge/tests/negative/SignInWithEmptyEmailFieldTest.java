package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SignInWithEmptyEmailFieldTest extends BaseTest {

    @Test
    public void signInWithEmptyEmailFieldTest() {
        mainSteps
                .openLoginPage()
                .loginWithEmptyEmailField();
    }
}
