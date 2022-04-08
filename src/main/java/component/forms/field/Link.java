package component.forms.field;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Link extends AbstractComponent {

    private static final String BUTTON_LOCATOR_PATTERN = "//a[contains(.,'%s')]";

    private final By buttonLocator;

    public Link(WebDriver driver, String text) {
        super(driver);
        this.buttonLocator = By.xpath(String.format(BUTTON_LOCATOR_PATTERN, text));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void click() {
        log.info("Click [{}] ", "the link");
        driver.findElement(buttonLocator).click();
    }
}
