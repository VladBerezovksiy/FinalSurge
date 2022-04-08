package finalsurge.steps.pages.workouts;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.fieldReportsStatistics.CalendarComponent;
import component.forms.field.Table;
import finalsurge.constants.button.SaveButtonConstants;
import finalsurge.constants.forms.FormAddVitalsConstants;
import finalsurge.constants.forms.FormNameConstants;
import finalsurge.constants.forms.FormReportConstants;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.workouts.ReportsStatisticsPage;

public class ReportsStatisticsSteps extends AbstractSteps {

    private ReportsStatisticsPage reportPage;

    public ReportsStatisticsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Remove data from the calendar's fields")
    @Description("Remove data by default from the calendar's fields")
    public ReportsStatisticsSteps removeValueByDefaultFromCalendars() {
        reportPage = new ReportsStatisticsPage(driver);
        new CalendarComponent(driver, FormAddVitalsConstants.START_DATE_FIELD).deleteValueByDefault();
        new CalendarComponent(driver, FormAddVitalsConstants.END_DATE_FIELD).deleteValueByDefault();
        return this;
    }

    @Step("Insert data to the calendar's fields")
    @Description("Enter data to the calendar's fields")
    public ReportsStatisticsSteps addValueToCalendars() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new CalendarComponent(
                driver,
                FormAddVitalsConstants.START_DATE_FIELD
        ).insertValue(FormReportConstants.START_DATE);
        new CalendarComponent(
                driver,
                FormAddVitalsConstants.END_DATE_FIELD
        ).insertValue(FormReportConstants.END_DATE);
        return this;
    }

    @Step("Select option in the select")
    @Description("Enter data to the calendar's fields")
    public ReportsStatisticsSteps selectActivityType() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new DropDown(driver, "ActivityType").selectOption(FormReportConstants.OPTION);
        return this;
    }

    @Step("Click the button View Report")
    @Description("Save the Report")
    public ReportsStatisticsSteps clickButtonViewReport() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new CreateActivityFormComponent(
                driver,
                SaveButtonConstants.SAVE_BUTTON_ID,
                FormNameConstants.REPORT_FILTERS_FORM
        ).save();
        return this;
    }

    @Step("Check report by dates")
    @Description("Check report by entered dates in the table")
    public ReportsStatisticsSteps checkDateInReport() {
        Table table = new Table(driver);
        String partOfStartDate =
                FormReportConstants.START_DATE.substring(0, FormReportConstants.START_DATE.length() - 5);
        String partOfEndDate =
                FormReportConstants.END_DATE.substring(0, FormReportConstants.END_DATE.length() - 5);
        boolean result = false;
        if (table.listOfDate() != null) {
            for (int i = 0; i < table.listOfDate().size(); i++) {
                if ((table.listOfDate().get(i).contains(partOfStartDate)) ||
                        (table.listOfDate().get(i).contains(partOfEndDate))) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        Assert.assertTrue(result, "Selected data doesn't match the result");
        return this;
    }

    @Step("Check report by dates and activity")
    @Description("Check report by entered dates and activity in the table")
    public ReportsStatisticsSteps checkDateAndActivityInReport() {
        Table table = new Table(driver);
        String partOfStartDate =
                FormReportConstants.START_DATE.substring(0, FormReportConstants.START_DATE.length() - 5);
        String partOfEndDate =
                FormReportConstants.END_DATE.substring(0, FormReportConstants.END_DATE.length() - 5);
        boolean result = false;
        if (table.listOfDate() != null) {
            for (int i = 0; i < table.listOfDate().size(); i++) {
                if (((table.listOfDate().get(i).contains(partOfStartDate)) ||
                        (table.listOfDate().get(i).contains(partOfEndDate))) &&
                        (table.listOfDateActivity(FormReportConstants.OPTION).get(i).contains(FormReportConstants.OPTION))) {

                    result = true;
                } else {
                    result = false;
                }
            }
        }
        Assert.assertTrue(result, "Selected data doesn't match the result");
        return this;
    }
}
