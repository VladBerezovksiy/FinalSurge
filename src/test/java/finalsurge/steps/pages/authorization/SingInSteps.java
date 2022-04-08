package finalsurge.steps.pages.authorization;

import finalsurge.constants.credantials.LoginDataConstant;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.authorization.LoginPage;

public class SingInSteps extends AbstractSteps {

    private LoginPage loginPage;

    public SingInSteps(WebDriver driver) {
        super(driver);
    }

    // TODO: Надо добавить URL
    @Step("Open 'Login' page")
    @Link(url = "https://log.finalsurge.com/login.cshtml", name = "Final Surge")
    public SingInSteps openLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid credentials")
    @Description("Check that it is impossible to enter the site with a invalid login and password")
    public SingInSteps loginWithInvalidCredits() {
        loginPage.authentication(
                LoginDataConstant.INVALID_LOGIN,
                LoginDataConstant.INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Email")
    @Description("Check that it is impossible to enter the site with a invalid login")
    public SingInSteps loginWithInvalidEmail() {
        loginPage.authentication(
                LoginDataConstant.INVALID_LOGIN,
                LoginDataConstant.VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with invalid Password")
    @Description("Check that it is impossible to enter the site with a invalid password")
    public SingInSteps loginWithInvalidPassword() {
        loginPage.authentication(
                LoginDataConstant.VALID_LOGIN,
                LoginDataConstant.INVALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Email field")
    @Description("Check that it is impossible to enter the site without a login")
    public SingInSteps loginWithEmptyEmailField() {
        loginPage.authentication(
                "",
                LoginDataConstant.VALID_PASSWORD
        );
        validatePageIsLoaded(loginPage);
        return this;
    }

    @Step("Sign in with empty Password field")
    @Description("Check that it is impossible to enter the site without a password")
    public SingInSteps loginWithEmptyPasswordField() {
        loginPage.authentication(
                LoginDataConstant.VALID_LOGIN,
                ""
        );
        validatePageIsLoaded(loginPage);
        return this;
    }
}
