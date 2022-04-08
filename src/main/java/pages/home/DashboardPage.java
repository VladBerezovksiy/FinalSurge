package pages.home;

import component.forms.field.Link;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class DashboardPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/Default.cshtml";

    public static final By HEADER = By.id("fade-menu");
    private static final String logoutLink = "Logout";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        log.info("Open [{}] url", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }

    public void openLogoutPage() {
        new Link(driver, logoutLink).click();
    }
}
