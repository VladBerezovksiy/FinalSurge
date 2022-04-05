package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends BaseTest {

    @Test(groups = "smoke")
    public void otherCalculatorTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openOtherCalculator()
                .calc("12", "Kilometers", "3", "59", "40");
    }
}