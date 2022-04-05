package pages.gearRoutes;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;

@Log4j2
public class RoutesPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/Routes.cshtml";

    private static final By BREADCRUMB = By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Routes')]");
    private static final By TABLE_PATTERN =
            By.xpath("//div[contains(@class,'w-box-content')]/table");
    private static final String NAME_LOCATOR_PATTERN = "//td/strong/a[contains(.,'%s')]";
    private static final String DATA_LOCATOR_PATTERN =
            "//td//a[contains(.,'%s')]/ancestor::tr//span[contains(.,'%s')]";

    public RoutesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMB));
    }

    private boolean checkTableIsEmpty() {
        return driver.findElements(TABLE_PATTERN).isEmpty();
    }

    public boolean validateValueFromTable(String name, String activity, String distances) {
        String[] arr = {name, activity, distances};
        boolean result = false;
        if (!checkTableIsEmpty()) {

            By nameValue = By.xpath(String.format(NAME_LOCATOR_PATTERN, name));
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(nameValue));

            for (int i = 1; i < arr.length; i++) {
                By anotherValue = By.xpath(String.format(DATA_LOCATOR_PATTERN, name, arr[i]));
                explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(anotherValue));
            }
            result = true;
        }
        Assert.assertTrue(result, "Value doesn't match from Table");
        return result;
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

}