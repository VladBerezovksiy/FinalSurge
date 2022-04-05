package finalsurge.steps.pages.home;

import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.authorization.LogoutPage;

@Log4j2
public class LogoutSteps extends AbstractSteps {

    private LogoutPage logoutPage;
    private String logoutText = "You have been successfully logged out of the system.";

    public LogoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Logout")
    public LogoutSteps checkMessageInLogoutPage() {
        logoutPage = new LogoutPage(driver);
        logoutPage.waitPageLoaded();
        log.info("Logout message is displayed: [{}]", logoutText);
        Assert.assertEquals(logoutPage.getAllertText(), logoutText, "The text is different in the logout page");
        return this;
    }
}
