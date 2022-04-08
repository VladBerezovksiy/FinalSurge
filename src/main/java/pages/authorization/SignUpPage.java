package pages.authorization;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import pages.home.DashboardPage;

@Log4j2
public class SignUpPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/register.cshtml";

    private static final String FIRSTNAME_FIELD = "create_first";
    private static final String LASTNAME_FIELD = "create_last";
    private static final String EMAIL_FIELD = "create_email";
    private static final String PASSWORD_FIELD = "password_meter";
    private static final String RETYPE_PASSWORD_FIELD = "create_passwordmatch";
    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//button[@type='submit' and text()='Create New Account']");
    private static final By SIGNIN_LINK = By.xpath("//div[@class='signup']/a");
    private static final By ALERT_MESSAGE = By.className("alert");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void openSignInPage() {
        driver.findElement(SIGNIN_LINK).click();
    }

    private void enterValue (String firstname, String lastname, String email, String password, String retypePassword) {
        log.info("Insert [{}] into [{}] field", firstname, "firstname");
        driver.findElement(By.id(FIRSTNAME_FIELD)).sendKeys(firstname);
        log.info("Insert [{}] into [{}] field", lastname, "lastname");
        driver.findElement(By.id(LASTNAME_FIELD)).sendKeys(lastname);
        log.info("Insert [{}] into [{}] field", email, "email");
        driver.findElement(By.id(EMAIL_FIELD)).sendKeys(email);
        log.info("Insert [{}] into [{}] field", password, "password");
        driver.findElement(By.id(PASSWORD_FIELD)).sendKeys(password);
        log.info("Insert [{}] into [{}] field", retypePassword, "retypePassword");
        driver.findElement(By.id(RETYPE_PASSWORD_FIELD)).sendKeys(retypePassword);
        log.info("Click [{}] button", "Create New Account");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
    }
    public DashboardPage signUp(String firstname, String lastname, String email, String password, String retypePassword) {
        enterValue(firstname, lastname, email,  password,  retypePassword);
        return new DashboardPage(driver);

    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_ACCOUNT_BUTTON));
    }

    @Override
    public BasePage openPage() {
        log.info("Insert [{}] into [{}] field", BASE_URL, "url");
        driver.get(BASE_URL);
        return this;
    }

    public SignUpPage fillFieldsInSignUp(String firstname, String lastname, String email, String password, String retypePassword) {
        enterValue(firstname, lastname, email,  password,  retypePassword);
        return new SignUpPage(driver);
    }

    public String checkEmptyField(String firstname, String lastname, String email, String password, String retypePassword) {
        String str;
        if (firstname.equals("")) {
            str = FIRSTNAME_FIELD;
        } else if (lastname.equals("")) {
            str = LASTNAME_FIELD;
        } else if (email.equals("")) {
            str = EMAIL_FIELD;
        } else if (password.equals("")) {
            str = PASSWORD_FIELD;
        } else if (retypePassword.equals("")) {
            str = RETYPE_PASSWORD_FIELD;
        } else {
            str = "";
        }
        return str;
    }

    public String getErrorText(String fieldName) {
        String required_message = "//input[@id='" + fieldName + "']/ancestor::td//label[@class='error']";
        return driver.findElement(By.xpath(required_message)).getText();
    }

    public String getAllertTextForPassword() {
        return driver.findElement(ALERT_MESSAGE).getText();
    }
}

