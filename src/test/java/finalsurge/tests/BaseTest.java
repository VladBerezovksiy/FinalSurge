package finalsurge.tests;

import finalsurge.constants.WindowSizeConstants;
import finalsurge.steps.MainSteps;
import finalsurge.utils.CapabilitiesGenerator;
import finalsurge.utils.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;

    @BeforeMethod(alwaysRun = true, groups={"smoke", "negative"})
    public void setup(ITestContext iTestContext) {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        Dimension dimension = new Dimension(
                WindowSizeConstants.WIGHT_WINDOW,
                WindowSizeConstants.HEIGHT_WINDOW
        );
        setContextAttribute(iTestContext, "driver", driver);
        log.info("Size of window browser [{}]x[{}]",
                WindowSizeConstants.HEIGHT_WINDOW, WindowSizeConstants.WIGHT_WINDOW);
        driver.manage().window().setSize(dimension);
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