package component.button.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractMenuButton {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    private static final String BUTTON_LOCATOR_PATTERN =
            "//div[@id='fade-menu']//a[text()='%s']/following-sibling::ul//a[text()='%s']";

    private final By buttonLocator;

    public AbstractMenuButton(WebDriver driver, String label, String option) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.buttonLocator = By.xpath(String.format(BUTTON_LOCATOR_PATTERN, label, option));
    }

    public void click() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(buttonLocator));
    }
}
