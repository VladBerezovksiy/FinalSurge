package pages.dailyVitals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class ViewPage extends BasePage {

    private static final By BREADCRUMBS =
            By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Daily Vitals')]");

    private static final String BASE_URL = "https://log.finalsurge.com/DailyVitals.cshtml";
    private static final By DAILY_VITALS_TABLE_LABEL= By.xpath("//div[@class='w-box w-box-blue']");
    private static final By DAILY_VITALS_ADD_TABLE_LABEL= By.xpath("//div[@class='w-box w-box-green']");

    public ViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMBS));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(DAILY_VITALS_TABLE_LABEL));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public boolean checkAddElementsDisplay() {
        return driver.findElements(DAILY_VITALS_ADD_TABLE_LABEL).isEmpty();
    }


}
