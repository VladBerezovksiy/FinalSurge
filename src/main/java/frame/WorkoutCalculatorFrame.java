package frame;

import constant.FrameConstants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

@Log4j2
public class WorkoutCalculatorFrame extends BasePage {

    private static final By FORM_TITLE_LOCATOR = By.xpath("//form[@id='intensity-calc']//h4");
    private static final By ALLERT_MESSAGE_LOCATOR = By.xpath("//div[@class='alert alert-error']");

    public WorkoutCalculatorFrame(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(FORM_TITLE_LOCATOR));
    }

    @Override
    public BasePage openPage() {
        return null;
    }

    public boolean checkTablePacesDisplay(String text) {
        return driver.findElements(By.xpath(String.format(FrameConstants.TABLE_LOCATOR_PATTERN, text))).isEmpty();
    }

    public String getAllertText() {
        return driver.findElement(ALLERT_MESSAGE_LOCATOR).getText();
    }
}
