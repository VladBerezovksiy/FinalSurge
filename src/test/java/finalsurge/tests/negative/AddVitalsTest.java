package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddVitalsTest extends BaseTest {

    @Test(dataProvider = "Input data for vitals", dataProviderClass = DataProviders.class, groups="negative")
    @Description("Check that the message is displayed if wrong data is entered")
    public void checkMessageForWrongData(String date, String steps, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openFinalSurge()
                        .loginWithValidCredits()
                        .openDailyVitalsPage()
                        .checkMessage(date, steps)
                , exp_message
                , act_message);
    }

}
