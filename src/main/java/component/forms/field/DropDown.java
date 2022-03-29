package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class DropDown extends AbstractComponent {

    public DropDown(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
