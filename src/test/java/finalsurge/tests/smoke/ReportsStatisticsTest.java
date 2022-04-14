package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class ReportsStatisticsTest extends BaseTest {

    @Severity(value = SeverityLevel.CRITICAL)
    @Test(groups = "negative")
    public void checkReportByDate() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                .clickButtonViewReport()
                .checkDateInReport();
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Test(groups = "smoke")
    public void checkReportByDateAndActivityType() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openReportPage()
                .removeValueByDefaultFromCalendars()
                .addValueToCalendars()
                .selectActivityType()
                .clickButtonViewReport()
                .checkDateAndActivityInReport();
    }
}

