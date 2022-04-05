package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class WorkoutCalcTest extends BaseTest {

    @Test(dataProvider = "Input right data for workout calculator", dataProviderClass = DataProviders.class, groups="smoke")
    @Description("Calc workout")
    public void checkPasswordTest(String event, String hh, String mm, String ss){
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openWorkoutCalc()
                .calc(event, hh, mm, ss);
    }
}
