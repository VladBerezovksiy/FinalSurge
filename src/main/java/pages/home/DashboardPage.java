package pages.home;

import component.forms.fieldDailyVitals.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class DashboardPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/Default.cshtml";
    private String logoutLink = "Logout";

    public static final By HEADER = By.id("fade-menu");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void openLogoutPage() {
        new Link(driver, logoutLink).clickLink();
    }
}
