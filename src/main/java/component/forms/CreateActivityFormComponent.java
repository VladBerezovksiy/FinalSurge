package component.forms;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CreateActivityFormComponent extends AbstractComponent {

    private static final String HEADER_LOCATOR_PATTERN = "//h4[contains(.,'%s')]";
    private static final String BUTTON_LOCATOR_PATTERN = "//input[@id='%s']";

    private final By headerLocator;
    private final By buttonLocator;

    public CreateActivityFormComponent(WebDriver driver, String buttonId, String headerText) {
        super(driver);
        this.headerLocator = By.xpath(String.format(HEADER_LOCATOR_PATTERN, headerText));
        this.buttonLocator = By.xpath(String.format(BUTTON_LOCATOR_PATTERN, buttonId));
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void save() {
        WebElement button = driver.findElement(buttonLocator);
        log.info("Click [{}] for save data", "button");
        button.click();
    }
}
