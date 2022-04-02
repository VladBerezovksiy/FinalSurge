package finalsurge.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BasePage;

public abstract class AbstractSteps {

    protected WebDriver driver;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
    }

    protected void validatePageIsLoaded(BasePage page) {
        Assert.assertTrue(page.isPageLoaded(), page.getClass().getSimpleName().concat(" is not opened!"));
    }
}
