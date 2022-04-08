package component.forms.fieldWorkoutLibrary;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class DropDown extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='formSep']/select";
    private static final String OPTION_DROPDOWN_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[@class='formSep']/select/option[contains(.,'%s')]";

    private final By dropdownLocator;
    private final String text;

    public DropDown(WebDriver driver, String text) {
        super(driver);
        this.text = text;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, text));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    private void openOptionPopup() {
        log.info("Click on Dropdown");
        driver.findElement(dropdownLocator).click();
    }

    public void selectOption(String optionText) {
        openOptionPopup();
        By optionLocator = By.xpath(String.format(OPTION_DROPDOWN_LOCATOR_PATTERN, text, optionText));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        log.info("Click on [{}] option from Dropdown", optionText);
        driver.findElement(optionLocator).click();
        explicitlyWait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownLocator, optionText));
    }
}
