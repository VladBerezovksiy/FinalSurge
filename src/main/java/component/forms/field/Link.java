package component.forms.field;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Link extends AbstractComponent {

    private static final String BUTTON_PATTERN = "//a[contains(.,'%s')]";
    private  final String label;
    private final By buttonLocator;

    public Link(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.buttonLocator = By.xpath(String.format(BUTTON_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(buttonLocator).isDisplayed();
    }

    public void clickLink() {
        log.info("Click [{}] ", "the link");
        driver.findElement(buttonLocator).click();
    }


}
