package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class CheckBox extends AbstractComponent {

    public CheckBox(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
