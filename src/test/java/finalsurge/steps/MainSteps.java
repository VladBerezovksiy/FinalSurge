package finalsurge.steps;

import finalsurge.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    private static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    private static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    private static final String INVALID_LOGIN = PropertiesUtils.getEnv("invalid_login");
    private static final String INVALID_PASSWORD = PropertiesUtils.getEnv("invalid_password");


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open FinalSurge page")
    public MainSteps openFinalSurge() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with valid credentials")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                VALID_LOGIN,
                VALID_PASSWORD
        );
        dashboardPage = new DashboardPage(driver);
        validatePageIsLoaded(dashboardPage);
        return this;
    }

    @Step("Sign in with invalid credentials")
    public MainSteps loginWithInvalidCredits() {
        loginPage.authentication(
                INVALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Email")
    public MainSteps loginWithInvalidEmail() {
        loginPage.authentication(
                INVALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Password")
    public MainSteps loginWithInvalidPassword() {
        loginPage.authentication(
                VALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Email field")
    public MainSteps loginWithEmptyEmailField() {
        loginPage.authentication(
                "",
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Password field")
    public MainSteps loginWithEmptyPasswordField() {
        loginPage.authentication(
                VALID_LOGIN,
                ""
        );
        validatePageIsLoaded(loginPage);
        return this;
    }
}
