package component.forms.fieldReportsStatistics;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CalendarComponent extends AbstractComponent {

    private static final String CALENDAR_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='span2']//input";

    private final By inputLocator;

    public CalendarComponent(WebDriver driver, String text) {
        super(driver);
        this.inputLocator = By.xpath(String.format(CALENDAR_LOCATOR_PATTERN, text));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void deleteValueByDefault() {
        driver.findElement(inputLocator).clear();
    }

    public void insertValue(String text) {
        log.info("Click [{}] to insert  data into ", "the calendar");
        driver.findElement(inputLocator).sendKeys(text);
    }
}
