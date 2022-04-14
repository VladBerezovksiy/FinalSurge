package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Severity(value = SeverityLevel.MINOR)
    @Test(groups="smoke")
    public void Logout() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openLogoutPage()
                .checkMessageInLogoutPage();
    }

}
