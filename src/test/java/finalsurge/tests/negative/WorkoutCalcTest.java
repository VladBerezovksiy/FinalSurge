package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkoutCalcTest extends BaseTest {
    @Test(dataProvider = "Input data for workout calculator", dataProviderClass = DataProviders.class, groups="negative")
    @Description("Check that the message is displayed with wrong params")
    public void checkPasswordTest(String event, String hh, String mm, String ss,  String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .loginWithValidCredits()
                        .openWorkoutCalc()
                        .checkMessage(event, hh,mm,ss)
                , exp_message
                , act_message);
    }
}
