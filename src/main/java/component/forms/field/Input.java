package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class Input extends AbstractComponent {

    public Input(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
