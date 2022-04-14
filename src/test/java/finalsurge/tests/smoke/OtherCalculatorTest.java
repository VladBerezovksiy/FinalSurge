package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.OtherCalcModel;
import org.testng.annotations.Test;

public class OtherCalculatorTest extends BaseTest {

    private final OtherCalcModel otherCalcModel = new OtherCalcModel();

    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = "smoke")
    public void otherCalculatorTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openOtherCalculator()
                .calc(
                        otherCalcModel.getDistance(),
                        otherCalcModel.getMeasure(),
                        otherCalcModel.getHours(),
                        otherCalcModel.getMinutes(),
                        otherCalcModel.getSeconds()
                )
                .validateCalcCreated();

    }
}