package component.forms.fieldAddWorkout;

import component.AbstractComponent;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class DropDown extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN = "//select[@id='%s']";
    private static final String OPTION_LIST_PATTERN =
            "//select[@id='%s']//option[contains(.,'%s')]";

    private final By optionLocator;
    private final By dropDownLocator;

    public DropDown(WebDriver driver, String label, String optionName) {
        super(driver);
        this.dropDownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN, label));
        this.optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, label, optionName));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(dropDownLocator).isDisplayed();
    }

    private void openOptionsPopup() {
        log.info("Click on Dropdown");
        driver.findElement(dropDownLocator).click();
    }

    public void selectOption() {
        openOptionsPopup();
        By option = optionLocator;
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(option));
        log.info("Click on Option from Dropdown");
        driver.findElement(option).click();
    }
}
