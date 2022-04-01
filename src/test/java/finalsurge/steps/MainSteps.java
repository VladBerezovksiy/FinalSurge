package finalsurge.steps;

import component.button.menu.AddWorkoutButton;
import component.button.menu.ReportButton;
import finalsurge.utils.PropertiesUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private AddWorkoutButton addWorkoutButton;
    private ReportButton reportButton;

    private static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    private static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    private static final String INVALID_LOGIN = PropertiesUtils.getEnv("invalid_login");
    private static final String INVALID_PASSWORD = PropertiesUtils.getEnv("invalid_password");


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Login' page")
    @Link("https://log.finalsurge.com/login.cshtml")
    public MainSteps openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open 'FinalSurge' page")
    @Description("Open Home page of Final Surge after signing in")
    public MainSteps openFinalSurge() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open SignUp page")
    public SignUpSteps openSignUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.openSignInPage();
        return new SignUpSteps(driver);
    }

    @Step("Sign in with valid credentials")
    @Description("Check that it is possible to enter the site with a valid login and password")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                VALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(new DashboardPage(driver));
        return this;
    }

    @Step("Sign in with invalid credentials")
    @Description("Check that it is impossible to enter the site with a invalid login and password")
    public MainSteps loginWithInvalidCredits() {
        loginPage.authentication(
                INVALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Email")
    @Description("Check that it is impossible to enter the site with a invalid login")
    public MainSteps loginWithInvalidEmail() {
        loginPage.authentication(
                INVALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Password")
    @Description("Check that it is impossible to enter the site with a invalid password")
    public MainSteps loginWithInvalidPassword() {
        loginPage.authentication(
                VALID_LOGIN,
                INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Email field")
    @Description("Check that it is impossible to enter the site without a login")
    public MainSteps loginWithEmptyEmailField() {
        loginPage.authentication(
                "",
                VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Password field")
    @Description("Check that it is impossible to enter the site without a password")
    public MainSteps loginWithEmptyPasswordField() {
        loginPage.authentication(
                VALID_LOGIN,
                ""
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open 'Add Workout' page")
    @Description("Check that it is possible to open 'Add Workout' page from Header")
    public AddWorkoutSteps openAddWorkout() {
        addWorkoutButton = new AddWorkoutButton(driver);
        Assert.assertTrue(
                addWorkoutButton.isComponentDisplayed(),
                addWorkoutButton.getClass().getSimpleName().concat(" not displayed")
        );
        addWorkoutButton.click();
        validatePageIsLoaded(new AddWorkoutPage(driver));
        return new AddWorkoutSteps(driver);
    }

    @Step("Open 'Report' page")
    public ReportSteps openReportPage() {
        reportButton = new ReportButton(driver);
        Assert.assertTrue(
                reportButton.isComponentDisplayed(),
                reportButton.getClass().getSimpleName().concat(" not displayed")
        );
        reportButton.click();
        validatePageIsLoaded(new ReportPage(driver));
        return new ReportSteps(driver);
    }
}
