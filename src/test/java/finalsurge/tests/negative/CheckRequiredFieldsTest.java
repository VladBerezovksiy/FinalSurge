package finalsurge.tests.negative;

import finalsurge.tests.BaseTest;
import finalsurge.utils.DataProviders;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckRequiredFieldsTest extends BaseTest {

    @Test(dataProvider = "Input data for auth", dataProviderClass = DataProviders.class, groups = "negative")
    @Description("Check that all fields are required")
    public void checkRequiredFieldsTest(String firstname, String lastname, String email, String password, String retypePassword, String exp_message, String act_message) {
        Assert.assertEquals(
                mainSteps
                        .openLoginPage()
                        .openSignUpPage()
                        .returnSignUpRequiredMessage(firstname, lastname, email, password, retypePassword)
                , exp_message
                , act_message);
    }
}
