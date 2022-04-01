package component.forms.fieldAddWorkout;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton extends AbstractComponent {

    public static final String RADIO_BUTTON_LOCATOR_PATTERN =
            "//span[contains(.,'%s')]/ancestor::label[contains(@class,'radio')]/input";

    private final By radioButtonLocator;

    public RadioButton(WebDriver driver, String label) {
        super(driver);
        this.radioButtonLocator = By.xpath(String.format(RADIO_BUTTON_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(radioButtonLocator).isDisplayed();
    }

    public void click() {
        log.info("Click on RadioButton");
        driver.findElement(radioButtonLocator).click();
    }
}
