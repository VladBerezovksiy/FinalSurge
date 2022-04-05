package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class OtherCalculatorFrame extends BasePage {

    private static final By MODAL_WINDOW = By.xpath("//iframe[@id='OtherCalciFrame']");
    private static final String TABLE_LOCATOR_PATTERN = "//h4[contains(.,'%s')]";
    private static final String SECTION_BUTTON_LOCATOR_PATTERN =
            "//form[@id='calorie-calc']//a[contains(.,'%s')]";

    public OtherCalculatorFrame(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_WINDOW));
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public boolean checkTablePacesDisplay(String label) {
        return driver.findElements(By.xpath(String.format(TABLE_LOCATOR_PATTERN, label))).isEmpty();
    }

    public void clickOnButtonSectionOnCalc(String sectionName) {
        driver.findElement(By.xpath(String.format(SECTION_BUTTON_LOCATOR_PATTERN, sectionName))).click();
    }
}