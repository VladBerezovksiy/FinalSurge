package component.forms.fieldDailyVitals;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends AbstractComponent {
    private static final String BUTTON_PATTERN = "//button[@title='%s']";
    private  final String label;
    private final By buttonLocator;

    public Button(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(BUTTON_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void clickButton() {
        driver.findElement(buttonLocator).click();
    }

    public void getButtonName() {
        driver.findElement(buttonLocator).getText();
    }
}
