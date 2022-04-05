package pages.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class WorkoutCalcFrame extends BasePage {


    private static final By FORM_TITLE = By.xpath("//form[@id='intensity-calc']//h4");

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
}
