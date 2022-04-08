package pages.workouts;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class AddWorkoutPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/WorkoutAdd.cshtml";

    private static final By BREADCRUMBS = By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Add Workout')]");
    private static final String SELECT_ACTIVITY_LOCATOR_PATTERN =
            "//div[@id='blog_accordion_left']//a[contains(.,'%s')]/ancestor::div[@class='accordion-group']";
    private static final String OPTION_ACTIVITY_LOCATOR_PATTERN =
            "//div[@id='blog_accordion_left']//a[contains(.,'%s')]/ancestor::div[@class='accordion-group']//a[text()='%s']";

    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    public void selectAnyActivityType(String label, String option) {
        log.info("Click [{}] activity in sidebar", label);
        driver.findElement(By.xpath(String.format(SELECT_ACTIVITY_LOCATOR_PATTERN, label))).click();
        explicitlyWait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(String.format(OPTION_ACTIVITY_LOCATOR_PATTERN, label, option))));
        log.info("Click [{}] activity in [{}] option", label, option);
        driver.findElement(By.xpath(String.format(
                OPTION_ACTIVITY_LOCATOR_PATTERN, label, option))).click();
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMBS));
    }

    @Override
    public BasePage openPage() {
        log.info("Open [{}] url", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }
}