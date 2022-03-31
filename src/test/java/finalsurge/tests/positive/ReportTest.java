package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportTest extends BaseTest {

    @Test
    public void checkReportByDate() {
            mainSteps.
                openFinalSurge()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                .clickButtonViewReport()
                .checkDateInReport();
    }

    @Test
    public void checkReportByDateAndActivityType() {
        mainSteps.
                openFinalSurge()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                  .selectActivityType()
                .clickButtonViewReport()
                .checkDateAndActivityInReport();
    }
}

