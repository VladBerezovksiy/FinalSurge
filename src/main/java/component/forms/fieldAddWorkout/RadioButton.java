package component.forms.fieldAddWorkout;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(radioButtonLocator).click();
    }
}
