package finalsurge.steps;

import component.button.menu.AddWorkoutButton;
import finalsurge.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AddWorkoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.SignUpPage;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;
    private SignUpPage signUpPage;
    private AddWorkoutButton addWorkoutButton;

    private static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    private static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    private static final String INVALID_LOGIN = PropertiesUtils.getEnv("invalid_login");
    private static final String INVALID_PASSWORD = PropertiesUtils.getEnv("invalid_password");


    public MainSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Login' page")
    public MainSteps openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Open SignUp page")
    public MainSteps openSignUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.openPage();
        validatePageIsLoaded(signUpPage);
        return this;
    }

    @Step("Sign up with valid credentials")
    public MainSteps signUpPageWithValidCredits() {
        signUpPage.signUp(
                "",
                "",
                "",
                "",
                ""
        );
        validatePageIsLoaded(new DashboardPage(driver));
        return this;
    }

    @Step("Sign up with invalid credentials")
    public MainSteps signUpPageWithInvalidCredits() {
        signUpPage.signUp(
                "",
                "",
                "",
                "",
                ""
        );
        validatePageIsLoaded(new DashboardPage(driver));
        validatePageIsLoaded(signUpPage);
        return this;
    }



    // Еще доделать остальные кейсы с 'Sign-up' page!!!




    @Step("Sign in with valid credentials")
    public MainSteps loginWithValidCredits() {
        loginPage.authentication(
                VALID_LOGIN,
                VALID_PASSWORD
        );
        validatePageIsLoaded(new DashboardPage(driver));
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

    @Step("Open 'Add Workout' page")
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
}
