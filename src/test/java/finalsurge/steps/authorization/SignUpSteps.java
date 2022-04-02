package finalsurge.steps.authorization;

import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.home.DashboardPage;
import pages.authorization.SignUpPage;

public class SignUpSteps extends AbstractSteps {

    private SignUpPage signUpPage;

    public SignUpSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Sign up with valid parameters")
    public SignUpSteps signUpWithValidCredits(String firstname, String lastname, String email, String password, String retype_password) {
        signUpPage = new SignUpPage(driver);
        signUpPage.signUp(firstname, lastname, email, password, retype_password);
        validatePageIsLoaded(new DashboardPage(driver));
        return this;
    }

    @Step("Check required parameters")
    public String returnSignUpRequiredMessage(String firstname, String lastname, String email, String password, String retypePassword) {
        signUpPage = new SignUpPage(driver);
        signUpPage
                .requiredFieldsInSignUp(firstname, lastname, email, password, retypePassword)
                .checkEmptyField(firstname, lastname, email, password, retypePassword);
        return signUpPage.getErrorText(signUpPage.checkEmptyField(firstname, lastname, email, password, retypePassword));
    }

    @Step("Check that the password is mathed the ruls")
    public String returnSignUpErrorPasswordMessage(String firstname, String lastname, String email, String password, String retypePassword) {
        signUpPage = new SignUpPage(driver);
        signUpPage
                .requiredFieldsInSignUp(firstname, lastname, email, password, retypePassword);
        return signUpPage.getAllertTextForPassword();
    }
}
