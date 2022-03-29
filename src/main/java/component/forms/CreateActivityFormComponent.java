package component.forms;

import component.AbstractComponent;
import org.openqa.selenium.WebDriver;

public class CreateActivityFormComponent extends AbstractComponent {

    public CreateActivityFormComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }
}
