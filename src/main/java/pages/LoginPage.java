package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/login.cshtml";

    private static final By USERNAME_FIELD = By.id("login_name");
    private static final By PASSWORD_FIELD = By.id("login_password");
    private static final By LOGIN_BUTTON = By.xpath("//button[@type='submit' and text()='Login']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void authentication(String username, String password) {
        log.info("Insert [{}] into [{}] field", username,"username");
        driver.findElement(USERNAME_FIELD).sendKeys(username);
        log.info("Insert [{}] into [{}] field", password,"password");
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        log.info("Click [{}] button", "Login");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
