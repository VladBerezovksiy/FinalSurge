package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SignInWithEmptyPasswordFieldTest extends BaseTest {

    @Test
    public void signInWithEmptyPasswordFieldTest() {
        mainSteps
                .openLoginPage()
                .loginWithEmptyPasswordField();
    }
}
