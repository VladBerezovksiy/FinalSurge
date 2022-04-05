package frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class WorkoutCalcFrame extends BasePage {

    private static final String TABLE_LOCATOR_PATTERN = "//h4[contains(.,'%s')]";
    private static final By FORM_TITLE = By.xpath("//form[@id='intensity-calc']//h4");
    private static By ALLERT_MESSAGE = By.xpath("//div[@class='alert alert-error']");
    public WorkoutCalcFrame(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(FORM_TITLE));
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public boolean checkTablePacesDisplay(String label) {
        return driver.findElements(By.xpath(String.format(TABLE_LOCATOR_PATTERN,label))).isEmpty();
    }

    public String getAllertText() {
        return driver.findElement(ALLERT_MESSAGE).getText();
    }
}
