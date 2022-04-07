package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.tests.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddVitalsTest extends BaseTest {

    // TODO: Удалить нейм, вызывать через название метода датапровайдера

    @Test(dataProvider = "Input data for vitals", dataProviderClass = DataProviders.class, groups = "negative")
    @Description("Check that the message is displayed if wrong data is entered")
    public void checkMessageForWrongData(String date, String steps, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .loginWithValidCredits()
                        .openDailyVitalsPage()
                        // TODO: Добавить метод Add
                        .checkMessage(date, steps)
                , exp_message
                , act_message);
    }

}
