package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups="smoke")
    public void Logout() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openLogoutPage()
                .checkMessageInLogoutPage();
    }

}
