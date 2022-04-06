package pages.gearRoutes;

import constant.GearRoutesConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;

@Log4j2
public class ShoesPage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/EquipmentShoes.cshtml";

    private static final By BREADCRUMB = By.xpath("//ul[@id='breadcrumbs']//a[contains(.,'Shoes')]");
    private static final String MODEL_LOCATOR_PATTERN = "//td[contains(.,'%s')]";
    private static final String DATA_LOCATOR_PATTERN =
            "//table//tr/td[contains(.,'%s')]/span[contains(.,'%s')]";

    public ShoesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(BREADCRUMB));
    }

    private boolean checkTableIsEmpty() {
        return driver.findElements(GearRoutesConstants.TABLE_PATTERN).isEmpty();
    }

    public boolean validateValueFromTable(String name, String model, String cost, String size, String distances) {
        String[] arr = {name, model, cost, size, distances};
        boolean result = false;
        if (!checkTableIsEmpty()) {

            By nameValue = By.xpath(String.format(GearRoutesConstants.NAME_LOCATOR_PATTERN, name));
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(nameValue));

            By modeValue = By.xpath(String.format(MODEL_LOCATOR_PATTERN, model));
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(modeValue));

            for (int i = 2; i < arr.length; i++) {
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
        log.info("Open [{}] url", BASE_URL);
        driver.get(BASE_URL);
        return this;
    }
}
