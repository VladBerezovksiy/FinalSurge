package component.forms.fieldReport;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarComponent extends AbstractComponent {

    private static final String CALENDAR_PATTERN = "//label[contains(.,'%s')]/ancestor::div[@class='span2']//input";
    private String label;
    private By inputLocator;

    public CalendarComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.inputLocator = By.xpath(String.format(CALENDAR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public void deleteValueByDefault() {
        driver.findElement(inputLocator).clear();
    }

    public void insertValue(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }
}
