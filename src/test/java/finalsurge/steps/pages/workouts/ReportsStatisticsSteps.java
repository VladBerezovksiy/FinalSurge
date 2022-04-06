package finalsurge.steps.pages.workouts;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.fieldReportsStatistics.CalendarComponent;
import component.forms.field.Table;
import finalsurge.constants.forms.FormNameConstants;
import finalsurge.steps.AbstractSteps;
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
    public ReportsStatisticsSteps removeValueByDefaultFromCalendars() {
        reportPage = new ReportsStatisticsPage(driver);
        new CalendarComponent(driver, FormNameConstants.DATE_START_FIELD).deleteValueByDefault();
        new CalendarComponent(driver, FormNameConstants.DATE_END_FIELD).deleteValueByDefault();
        return this;
    }

    @Step("Insert data to the calendar's fields")
    public ReportsStatisticsSteps addValueToCalendars() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new CalendarComponent(
                driver,
                FormNameConstants.DATE_START_FIELD
        ).insertValue(FormNameConstants.START_DATE);
        new CalendarComponent(
                driver,
                FormNameConstants.DATE_END_FIELD
        ).insertValue(FormNameConstants.END_DATE);
        return this;
    }

    @Step("Select option in the select")
    public ReportsStatisticsSteps selectActivityType() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new DropDown(driver, "ActivityType").selectOption(FormNameConstants.OPTION);
        return this;
    }

    @Step("Click the button View Report")
    public ReportsStatisticsSteps clickButtonViewReport() {
        reportPage = new ReportsStatisticsPage(driver);
        reportPage.waitPageLoaded();
        new CreateActivityFormComponent(
                driver,
                FormNameConstants.BUTTON,
                FormNameConstants.REPORT_FILTERS_FORM
        ).save();
        return this;
    }

    @Step("Check report by dates")
    public ReportsStatisticsSteps checkDateInReport() {
        Table table = new Table(driver);
        String partOfStartDate =
                FormNameConstants.START_DATE.substring(0, FormNameConstants.START_DATE.length() - 5);
        String partOfEndDate =
                FormNameConstants.END_DATE.substring(0, FormNameConstants.END_DATE.length() - 5);
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

    @Step("Check report by dates and Activity")
    public ReportsStatisticsSteps checkDateAndActivityInReport() {
        Table table = new Table(driver);
        String partOfStartDate =
                FormNameConstants.START_DATE.substring(0, FormNameConstants.START_DATE.length() - 5);
        String partOfEndDate =
                FormNameConstants.END_DATE.substring(0, FormNameConstants.END_DATE.length() - 5);
        boolean result = false;
        if (table.listOfDate() != null) {
            for (int i = 0; i < table.listOfDate().size(); i++) {
                if (((table.listOfDate().get(i).contains(partOfStartDate)) ||
                        (table.listOfDate().get(i).contains(partOfEndDate))) &&
                        (table.listOfDateActivity(FormNameConstants.OPTION).get(i).contains(FormNameConstants.OPTION))) {

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
