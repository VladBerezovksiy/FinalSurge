package finalsurge.steps;

import finalsurge.utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class MainSteps extends AbstractSteps {

    private LoginPage loginPage;

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
}
