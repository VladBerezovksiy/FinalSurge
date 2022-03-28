package finalsurge.steps;

import finalsurge.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SignUpPage;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;
    private SignUpPage signUpPage;

    private static final String VALID_LOGIN = PropertiesUtils.getEnv("valid_login");
    private static final String VALID_PASSWORD = PropertiesUtils.getEnv("valid_password");

    public MainSteps(WebDriver driver) {
        super(driver);
    }

    public MainSteps openFinalSurge() {
        loginPage = new LoginPage(driver);
        loginPage.openPage();
        validatePageIsLoaded(loginPage);
        return this;
    }

    // Доделать
    public MainSteps loginWithValidCredits(){
        loginPage.authentication(
                VALID_LOGIN,
                VALID_PASSWORD
        );
        return this;
    }

    public SignUpPage openSignUpPage(){
        signUpPage = new SignUpPage(driver);
        signUpPage.openSignInPage();
        return new SignUpPage(driver);
    }



}
