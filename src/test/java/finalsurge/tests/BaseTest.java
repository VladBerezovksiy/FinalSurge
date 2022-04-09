package finalsurge.tests;

import finalsurge.constants.size.WindowSizeConstants;
import finalsurge.steps.pages.authorization.SingInSteps;
import finalsurge.steps.pages.home.MainSteps;
import finalsurge.utils.CapabilitiesGenerator;
import finalsurge.utils.PropertiesUtils;
import finalsurge.utils.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected MainSteps mainSteps;
    protected SingInSteps singInSteps;

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext iTestContext) {
        String browser = PropertiesUtils.getEnv("browser");
        String os = System.getProperty("os.name").toLowerCase();

        if (browser.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } else if (browser.contains("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(CapabilitiesGenerator.getFirefoxOptions());
        }
        log.info("Operational System: " + os + "; Browser: " + browser);
        Dimension dimension = new Dimension(
                WindowSizeConstants.WIGHT_WINDOW,
                WindowSizeConstants.HEIGHT_WINDOW
        );
        setContextAttribute(iTestContext, "driver", driver);
        log.info("Size of window browser [{}]x[{}]",
                WindowSizeConstants.HEIGHT_WINDOW,
                WindowSizeConstants.WIGHT_WINDOW
        );
        driver.manage().window().setSize(dimension);
        driver.manage().deleteAllCookies();

        mainSteps = new MainSteps(driver);
        singInSteps = new SingInSteps(driver);
    }

    private void setContextAttribute(ITestContext iTestContext, String attributeKey, Object attributeValue) {
        iTestContext.setAttribute(attributeKey, attributeValue);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}