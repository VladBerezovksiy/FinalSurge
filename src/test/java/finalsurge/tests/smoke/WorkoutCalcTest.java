package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import finalsurge.tests.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutCalcTest extends BaseTest {

    @Severity(value = SeverityLevel.NORMAL)
    @Test( dataProvider= "inputRightDataForWorkoutCalc", dataProviderClass = DataProviders.class, groups="smoke")
    @Description("Calc workout")
    public void checkWorkoutCalcTest(String event, String hh, String mm, String ss){
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openWorkoutCalc()
                .calc(event, hh, mm, ss);
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Test(dataProvider = "inputForWorkoutCalc", dataProviderClass = DataProviders.class, groups = "negative")
    @Description("Check that the message is displayed with wrong params")
    public void checkAlertToWrongDataTest(String event, String hh, String mm, String ss, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .loginWithValidCredits()
                        .openWorkoutCalc()
                        .checkMessage(event, hh, mm, ss)
                , exp_message
                , act_message);
    }
}
