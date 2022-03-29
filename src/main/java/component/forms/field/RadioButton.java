package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class RadioButton extends AbstractComponent {

    public RadioButton(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
