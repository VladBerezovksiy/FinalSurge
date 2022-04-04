package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {
    @Test(groups="smoke")
    public void Logout() {
        mainSteps
                .openFinalSurge()
                .loginWithValidCredits()
                .openLogoutPage()
                .checkMessageInLogoutPage();
    }
}
