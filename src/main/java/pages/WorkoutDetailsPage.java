package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkoutDetailsPage extends BasePage {

    private static final By BREADCRUMBS =
            By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Workout Details')]");

    public WorkoutDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMBS));
    }

    @Override
    public BasePage openPage() {
        return this;
    }
}
