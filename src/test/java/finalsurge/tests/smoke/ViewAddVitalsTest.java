package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class ViewAddVitalsTest extends BaseTest {

    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = "smoke")
    public void checkAddElementsNotDisplayed() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openDailyVitalsPage()
                .checkingMissingDailyVitalsAdd();
    }

    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = "smoke")
    public void addNewVital() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openDailyVitalsPage()
                .addNewVitals()
                .checkDateInTable();
    }



}
