package finalsurge.steps.frame.otherCalculator;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Input;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import frame.OtherCalculatorFrame;
import org.testng.Assert;

public class OtherCalculatorStep extends AbstractSteps {

    private final WebElement frame = driver.findElement(By.xpath("//iframe[@id='OtherCalciFrame']"));

    private OtherCalculatorFrame otherCalculatorFrame;

    public OtherCalculatorStep(WebDriver driver) {
        super(driver);
    }

    public void createNewPaceInCalculator(String distance, String measurer, String hours, String minutes, String seconds) {
        driver.switchTo().frame(frame);
        otherCalculatorFrame = new OtherCalculatorFrame(driver);
        otherCalculatorFrame.clickOnButtonSectionOnCalc("Pace Calculator");
        otherCalculatorFrame.isPageLoaded();
        new Input(driver, "RunDist").insert(distance);
        new DropDown(driver, "DistType").selectOption(measurer);
        new Input(driver, "TimeHH").insert(hours);
        new Input(driver, "TimeMM").insert(minutes);
        new Input(driver, "TimeSS").insert(seconds);
        new CreateActivityFormComponent(
                driver, "saveButtonSettings", "Pace Calculator"
        ).save();
    }

    @Step("Check that calculator works")
    public OtherCalculatorStep calc(String distance, String measurer, String hours, String minutes, String seconds) {
        createNewPaceInCalculator(distance, measurer, hours, minutes, seconds);
        Assert.assertFalse(
                otherCalculatorFrame.checkTablePacesDisplay("Pace Chart"),
                "The table  isn't displayed"
        );
        return this;
    }
}
