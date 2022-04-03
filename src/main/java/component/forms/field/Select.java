package component.forms.field;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Log4j2
public class Select extends AbstractComponent {

    private static final String SELECT_OPTION_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='span3']//select/option[contains(.,'%s')]";
    private static final String SELECT_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='span3']//select";
    private final String label;
    private final By selectLocator;


    public Select(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.selectLocator = By.xpath(String.format(SELECT_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(selectLocator).isDisplayed();
    }

    private void openOptionsPopup() {
        driver.findElement(selectLocator).click();
    }

    public void selectOption(String optionName1) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(SELECT_OPTION_PATTERN, label, optionName1));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        log.info("Select [{}] ", "option");
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(selectLocator, optionName1));
    }
}



