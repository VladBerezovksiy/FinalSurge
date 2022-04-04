package component.forms.field;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MainButton extends AbstractComponent {

    private static final String BUTTON_PATTERN = "//input[@type='submit' and @value='%s']";
    private  final String label;
    private final By buttonLocator;

    public MainButton(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(BUTTON_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void clickButton() {
        log.info("Click [{}] main", "button");
        driver.findElement(buttonLocator).click();
    }
}
