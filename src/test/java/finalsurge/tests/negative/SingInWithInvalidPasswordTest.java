package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SingInWithInvalidPasswordTest extends BaseTest {

    @Test
    public void signInWithInvalidPasswordTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidPassword();
    }
}
