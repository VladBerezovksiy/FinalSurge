package component.forms.field;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
@Log4j2
public class DropDown extends AbstractComponent {
    private static final String DROPDOWN_LOCATOR_PATTERN = "//select[@id='%s']";
    private static final String OPTION_LOCATOR_PATTERN = "//select[@id='%s']/option[contains(.,'%s')]";

    private final By dropdownLocator;
    //private final By optionLocator;
    private final String label;

    public DropDown(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, label));
      //  this.optionLocator = By.xpath(String.format(OPTION_LOCATOR_PATTERN, label));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    private void openOptionPopup() {
        log.info("Click on Dropdown");
        driver.findElement(dropdownLocator).click();
    }

    public void selectOption(String optionName) {
        openOptionPopup();
        By optionLocator = By.xpath(String.format(OPTION_LOCATOR_PATTERN, label, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        log.info("Click on [{}] option from Dropdown", optionName);
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, optionName));
    }
}
