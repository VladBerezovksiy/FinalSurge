package finalsurge.steps.frames;

import component.forms.CreateActivityFormComponent;
import component.forms.field.Input;
import component.forms.fieldWorkoutCalc.RadioButton;
import finalsurge.steps.AbstractSteps;
import frame.WorkoutCalcFrame;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WorkoutCalcSteps  extends AbstractSteps {

    private WorkoutCalcFrame calcFrame;
    private String headerName = "Running Workout Intensity Calculator";
    private String buttonName = "saveButtonSettings";
    private String tableName = "Your Workout Paces";

    public WorkoutCalcSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Check that calculator works")
    public WorkoutCalcSteps calc(String event, String hh, String mm, String ss) {
        enterValues( event,  hh,  mm,  ss);
        Assert.assertFalse(calcFrame.checkTablePacesDisplay(tableName),"The table  isn't displayed");
        return this;
    }
    @Step("Check that the message is displayed")
    public String checkMessage(String event, String hh, String mm, String ss) {
        enterValues( event,  hh,  mm,  ss);
        return calcFrame.getAllertText();
    }
    public void enterValues(String event, String hh, String mm, String ss) {
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='IntensityCalciFrame']"));
        driver.switchTo().frame(frame);
        calcFrame = new WorkoutCalcFrame(driver);
        calcFrame.openPage();
        calcFrame.isPageLoaded();
        new RadioButton(driver,event).click();
        new Input(driver, "TimeHH").insert(hh);
        new Input(driver, "TimeMM").insert(mm);
        new Input(driver, "TimeSS").insert(ss);
        new CreateActivityFormComponent(driver, buttonName, headerName).save();

    }
}
