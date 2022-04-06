package pages.authorization;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class LogoutPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/logout.cshtml";

    private static final By LOGOUT_MESSAGE = By.xpath("//div[@class='alert alert-success']");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_MESSAGE));
    }

    @Override
    public BasePage openPage() {
        log.info("Insert [{}] into [{}] field", BASE_URL, "url");
        driver.get(BASE_URL);
        return this;
    }

    public String getAllertText() {
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }
}
