package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class SignIntWithInvalidEmailTest extends BaseTest {

    @Test
    public void signInWithInvalidEmailTest() {
        mainSteps
                .openLoginPage()
                .loginWithInvalidEmail();
    }
}
