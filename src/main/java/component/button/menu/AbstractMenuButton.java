package component.button.menu;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public abstract class AbstractMenuButton {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait explicitlyWait;

    private static final String BUTTON_LOCATOR_PATTERN =
            "//div[@id='fade-menu']//a[text()='%s']";
    public static final String OPTION_LOCATOR_PATTERN =
            "//div[@id='fade-menu']//a[text()='%s']";

    private final By buttonLocator;
    private final By optionLocator;

    public AbstractMenuButton(WebDriver driver, String label, String option) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.buttonLocator = By.xpath(String.format(BUTTON_LOCATOR_PATTERN, label));
        this.optionLocator = By.xpath(String.format(OPTION_LOCATOR_PATTERN, option));
    }

    public boolean isComponentDisplayed() {
        try {
            actions.moveToElement(driver.findElement(buttonLocator)).perform();
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void click() {
        log.info("Click on Option from Menu");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(optionLocator));
    }
}