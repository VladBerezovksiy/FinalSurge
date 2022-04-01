package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

public class ReportTest extends BaseTest {

    @Test (groups="negative")

    public void checkReportByDate() {
        mainSteps
                .openFinalSurge()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                .clickButtonViewReport()
                .checkDateInReport();
    }

    @Test(groups="smoke")
    public void checkReportByDateAndActivityType() {
        mainSteps
                .openFinalSurge()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                .selectActivityType()
                .clickButtonViewReport()
                .checkDateAndActivityInReport();
    }
}

