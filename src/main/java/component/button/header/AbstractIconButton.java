package component.button.header;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractIconButton {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public AbstractIconButton(WebDriver driver) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    abstract public boolean isComponentDisplayed();
}
