package component.forms.fieldReport;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends AbstractComponent {
    private static final By BUTTON_PATTERN = By.id("saveButton");
    private String label;
    public Button(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public void clickButton() {
        driver.findElement(BUTTON_PATTERN).click();
    }

}
