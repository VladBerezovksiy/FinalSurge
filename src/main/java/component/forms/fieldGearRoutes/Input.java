package component.forms.fieldGearRoutes;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends AbstractComponent {

    private static final String INPUT_LOCATOR_PATTERN = "//input[@id='%s']";

    private final By inputLocator;

    public Input(WebDriver driver, String label) {
        super(driver);
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void insert(String text) {
        driver.findElement(inputLocator).clear();
        log.info("Insert [{}] into [{}] field", text,"input");
        driver.findElement(inputLocator).sendKeys(text);
    }
}
