package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import models.OtherCalcModel;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends BaseTest {

    private final OtherCalcModel otherCalcModel = new OtherCalcModel();

    @Test(groups = "smoke")
    public void otherCalculatorTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openOtherCalculator()
                .calc(otherCalcModel.getDistance(),
                        otherCalcModel.getMeasure(),
                        otherCalcModel.getHours(),
                        otherCalcModel.getMinutes(),
                        otherCalcModel.getSeconds());
    }
}