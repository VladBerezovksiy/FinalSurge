package pages.workouts;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class WorkoutLibraryPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/WorkoutLibrary.cshtml";

    private static final By BREADCRUMBS =
            By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Workout Library')]");
    private static final String TABLE_LOCATOR_PATTERN = "//h4[contains(.,'%s')]";
    private static final String VALUE_TABLE_LOCATOR_PATTERN =
            "//h4[contains(.,'%s')]/ancestor::div[contains(@class,'w-box hideable')]//tbody//td[contains(.,'%s')]";

    public WorkoutLibraryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMBS));
    }

    public void openDetails(String label) {
        log.info("Click on [{}] table", label);
        driver.findElement(By.xpath(String.format(TABLE_LOCATOR_PATTERN, label))).click();
    }

    public void validateValueFormTable(String label, String value) {
        openDetails(label);
        By valueLocator = By.xpath(String.format(VALUE_TABLE_LOCATOR_PATTERN, label, value));
        log.info("Value [{}] from [{}] table ", value, label);
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(valueLocator));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
