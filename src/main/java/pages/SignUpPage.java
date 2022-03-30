package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class SignUpPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/register.cshtml";

    private static final By FIRSTNAME_FIELD = By.id("create_first");
    private static final By LASTNAME_FIELD = By.id("create_last");
    private static final By EMAIL_FIELD = By.id("create_email");
    private static final By PASSWORD_FIELD = By.id("password_meter");
    private static final By RETYPE_PASSWORD_FIELD = By.id("create_passwordmatch");
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@type='submit' and text()='Create New Account']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_ACCOUNT_BUTTON));
    }

    public void signUp(String firstname, String lastname, String email, String password, String retypePassword) {
        log.info("Insert [{}] into [{}] field", firstname, "firstname");
        driver.findElement(FIRSTNAME_FIELD).sendKeys(firstname);
        log.info("Insert [{}] into [{}] field", lastname, "lastname");
        driver.findElement(LASTNAME_FIELD).sendKeys(lastname);
        log.info("Insert [{}] into [{}] field", email, "email");
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        log.info("Insert [{}] into [{}] field", password, "password");
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        log.info("Insert [{}] into [{}] field", retypePassword, "retypePassword");
        driver.findElement(RETYPE_PASSWORD_FIELD).sendKeys(retypePassword);
        log.info("Click [{}] button", "Create New Account");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}

