package finalsurge.steps.frames;

import component.forms.CreateActivityFormComponent;
import component.forms.field.Input;
import component.forms.field.RadioButton;
import finalsurge.constants.frames.WorkoutCalculatorConstants;
import finalsurge.steps.AbstractSteps;
import frame.WorkoutCalculatorFrame;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WorkoutCalcSteps extends AbstractSteps {

    private WorkoutCalculatorFrame calcFrame;

    public WorkoutCalcSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check that calculator works")
    @Description("Check that it is possible to add valid data in calculator")
    public WorkoutCalcSteps calc(String event, String hh, String mm, String ss) {
        enterValues(event, hh, mm, ss);
        Assert.assertFalse(calcFrame.checkTablePacesDisplay(
                        WorkoutCalculatorConstants.TABLE_NAME),
                "The table  isn't displayed"
        );
        return this;
    }

    @Step("Check that the message is displayed")
    @Description("Check that the alert with the message is displayed if wrong data was entered")
    public String checkMessage(String event, String hh, String mm, String ss) {
        enterValues(event, hh, mm, ss);
        return calcFrame.getAllertText();
    }

    private void enterValues(String event, String hh, String mm, String ss) {
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='IntensityCalciFrame']"));
        driver.switchTo().frame(frame);
        calcFrame = new WorkoutCalculatorFrame(driver);
        calcFrame.isPageLoaded();
        new RadioButton(driver, event).click();
        new Input(driver, "TimeHH").insert(hh);
        new Input(driver, "TimeMM").insert(mm);
        new Input(driver, "TimeSS").insert(ss);
        new CreateActivityFormComponent(
                driver,
                WorkoutCalculatorConstants.BUTTON_NAME,
                WorkoutCalculatorConstants.HEADER_NAME
        ).save();
    }
}
