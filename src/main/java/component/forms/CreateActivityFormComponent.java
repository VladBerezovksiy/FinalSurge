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

    private static final By HEADER = By.xpath("//h4[contains(.,'Add New Workout')]");
    private static final By SAVE_BUTTON = By.xpath("//input[@id='saveButton']");


    public CreateActivityFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public void save() {
        WebElement button = driver.findElement(SAVE_BUTTON);
        log.info("Click [{}] for save workout data", "button");
        button.click();
    }
}
