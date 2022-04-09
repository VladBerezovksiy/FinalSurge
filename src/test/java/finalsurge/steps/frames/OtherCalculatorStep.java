package finalsurge.steps.frames;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Input;
import finalsurge.constants.frames.OtherCalculatorConstants;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import frame.OtherCalculatorFrame;
import org.testng.Assert;

public class OtherCalculatorStep extends AbstractSteps {

    private final WebElement FRAME = driver.findElement(By.xpath("//iframe[@id='OtherCalciFrame']"));

    private OtherCalculatorFrame otherCalculatorFrame;

    public OtherCalculatorStep(WebDriver driver) {
        super(driver);
    }

    private void createNewPaceInCalculator(String distance, String measurer, String hours, String minutes, String seconds) {
        driver.switchTo().frame(FRAME);
        otherCalculatorFrame = new OtherCalculatorFrame(driver);
        otherCalculatorFrame.isPageLoaded();
        otherCalculatorFrame.clickOnButtonSectionOnCalc(OtherCalculatorConstants.PACE_CALC_SECTION);
        new Input(driver, "RunDist").insert(distance);
        new DropDown(driver, "DistType").selectOption(measurer);
        new Input(driver, "TimeHH").insert(hours);
        new Input(driver, "TimeMM").insert(minutes);
        new Input(driver, "TimeSS").insert(seconds);
        new CreateActivityFormComponent(
                driver, OtherCalculatorConstants.SAVE_BUTTON, OtherCalculatorConstants.PACE_CALC_SECTION
        ).save();
    }

    @Step("Create new Pace with {distance} distance, {measurer} measurer, {hours} hours, {minutes} minutes and {seconds} seconds")
    @Description("Check that it is possible to add valid data in Other Calculator on Pace Calculator section")
    public OtherCalculatorStep calc(String distance, String measurer, String hours, String minutes, String seconds) {
        createNewPaceInCalculator(distance, measurer, hours, minutes, seconds);
        Assert.assertFalse(
                otherCalculatorFrame.checkTablePacesDisplay("Pace Chart"),
                "The table  isn't displayed"
        );
        return this;
    }

    @Step("Check data from 'Shoe' table is matched")
    @Description("Check that added data from 'Shoe' table is matched")
    public boolean validateCalcCreated() {
        boolean result = false;
        if ((!otherCalculatorFrame.checkPaceChartIsEmpty()) || (!otherCalculatorFrame.checkPaceSplitIsEmpty())){
            result = true;
        }
        Assert.assertTrue(result, "Value doesn't match from Table");
        return result;
    }
}
