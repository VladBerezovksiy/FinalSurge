package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class ViewAddVitalsTest extends BaseTest {

    @Test(groups = "smoke")
    public void checkAddElementsNotDisplayed() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openDailyVitalsPage()
                .checkingMissingDailyVitalsAdd();
    }

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
