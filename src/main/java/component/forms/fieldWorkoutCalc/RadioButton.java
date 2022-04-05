package component.forms.fieldWorkoutCalc;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class RadioButton extends AbstractComponent {

    private static final String RADIO_BUTTON_PATTERN = "//label[contains(.,'%s')]//input";

    private  final String label;
    private final By buttonLocator;

    public RadioButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(RADIO_BUTTON_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void click() {
        log.info("Click [{}] ", "radiobutton");
        driver.findElement(buttonLocator).click();
    }
}
