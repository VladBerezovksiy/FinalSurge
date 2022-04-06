package component.forms.fieldDailyVitals;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Calendar extends AbstractComponent {

    private static final String CALENDAR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='input-append date']//input";

    private final By inputLocator;

    public Calendar(WebDriver driver, String label) {
        super(driver);
        this.inputLocator = By.xpath(String.format(CALENDAR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void insertValue(String text) {
        log.info("Click [{}] to insert  data into ", "the calendar");
        driver.findElement(inputLocator).sendKeys(text);
    }
}
