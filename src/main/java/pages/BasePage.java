package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    abstract public void waitPageLoaded();

    abstract public BasePage openPage();

    public boolean isPageLoaded() {
        try {
            waitPageLoaded();
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }
}
