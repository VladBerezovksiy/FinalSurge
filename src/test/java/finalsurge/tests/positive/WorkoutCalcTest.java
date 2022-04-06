package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutCalcTest extends BaseTest {

    @Test(dataProvider = "Input right data for workout calculator", dataProviderClass = DataProviders.class, groups="smoke")
    @Description("Calc workout")
    public void checkWorkoutCalcTest(String event, String hh, String mm, String ss){
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openWorkoutCalc()
                .calc(event, hh, mm, ss);
    }

    @Test(dataProvider = "Input data for workout calculator", dataProviderClass = DataProviders.class, groups = "negative")
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
