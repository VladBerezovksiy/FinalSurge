package component.forms.fieldReportsStatistics;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarComponent extends AbstractComponent {

    private static final String CALENDAR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='span2']//input";
    private final String label;
    private final By inputLocator;

    public CalendarComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(CALENDAR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(inputLocator).isDisplayed();
    }

    public void deleteValueByDefault() {
        driver.findElement(inputLocator).clear();
    }

    public void insertValue(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }
}
