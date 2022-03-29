package finalsurge.tests;

import finalsurge.steps.MainSteps;
import finalsurge.utils.CapabilitiesGenerator;
import finalsurge.utils.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.SignUpPage;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected SignUpPage signUpPage;




    @BeforeMethod
    public void setup(ITestContext iTestContext) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        setContextAttribute(iTestContext, "driver", driver);
        mainSteps = new MainSteps(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}