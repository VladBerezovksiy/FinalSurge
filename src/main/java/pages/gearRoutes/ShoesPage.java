package pages.gearRoutes;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class ShoesPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/EquipmentShoes.cshtml";

    private static final By BREADCRUMB = By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Shoes')]");
    private static final String VALUE_TABLE_LOCATOR_PATTERN =
            "";

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMB));
    }

    public void validateValueFromTable() {

    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
