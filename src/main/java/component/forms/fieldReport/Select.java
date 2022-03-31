package component.forms.fieldReport;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Select extends AbstractComponent {

    private static final String SELECT_OPTION_PATTERN = "//label[contains(.,'%s')]/ancestor::form[@id='dash-form']//select/option[contains(.,'%s')]";
    private static final String SELECT_PATTERN = "//label[contains(.,'%s')]/ancestor::form[@id='dash-form']//select";
    private String label;
    private By selectLocator;

    public Select(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.selectLocator = By.xpath(String.format(SELECT_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    private void openOptionsPopup() {
        driver.findElement(selectLocator).click();
    }

    public void selectOption(String optionName1) {
        openOptionsPopup();
        By optionLocator = By.xpath(String.format(SELECT_OPTION_PATTERN, label, optionName1));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(selectLocator, optionName1));
    }
}



