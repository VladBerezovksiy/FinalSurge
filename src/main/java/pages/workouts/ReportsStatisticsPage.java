package pages.workouts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ReportsStatisticsPage extends BasePage {

    private static final By BREADCRUMBS =
            By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Athlete Workout Report')]");
    private static final By REPORT_FILTERS_TITLE = By.xpath("//h4[contains(.,'Report Filters')]");
    private static final String BASE_URL = "https://log.finalsurge.com/WorkoutReport.cshtml";

    public ReportsStatisticsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMBS));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(REPORT_FILTERS_TITLE));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}