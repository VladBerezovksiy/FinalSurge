package component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractComponent {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    abstract public boolean isComponentDisplayed();
}
