package frame;

import constant.FrameConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class OtherCalculatorFrame extends BasePage {

    private static final By MODAL_WINDOW_LOCATOR = By.xpath("//iframe[@id='OtherCalciFrame']");
    private static final String SECTION_BUTTON_LOCATOR_PATTERN =
            "//form[@id='calorie-calc']//a[contains(.,'%s')]";
    private static final By PACE_CHART_TABLE_LOCATOR =
            By.xpath("//form[@id='intensity-calc']//table[@class='table table-condensed table-hover']");
    private static final By PACE_SPLITS_TABLE_LOCATOR =
            By.xpath("//form[@id='intensity-calc']//table[@class='table table-condensed table-striped table-hover']");

    public OtherCalculatorFrame(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_WINDOW_LOCATOR));
    }

    public boolean checkPaceChartIsEmpty() {
        return driver.findElements(PACE_CHART_TABLE_LOCATOR).isEmpty();
    }

    public boolean checkPaceSplitIsEmpty() {
        return driver.findElements(PACE_SPLITS_TABLE_LOCATOR).isEmpty();
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public boolean checkTablePacesDisplay(String text) {
        return driver.findElements(By.xpath(String.format(FrameConstants.TABLE_LOCATOR_PATTERN, text))).isEmpty();
    }

    public void clickOnButtonSectionOnCalc(String sectionText) {
        driver.findElement(By.xpath(String.format(SECTION_BUTTON_LOCATOR_PATTERN, sectionText))).click();
    }
}