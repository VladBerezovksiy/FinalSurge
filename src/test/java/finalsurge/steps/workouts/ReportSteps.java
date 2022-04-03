package finalsurge.steps.workouts;

//import component.forms.field.SaveButton;
import component.forms.field.MainButton;
import component.forms.fieldReport.CalendarComponent;
import component.forms.field.Select;
import component.forms.field.Table;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.workouts.ReportPage;

public class ReportSteps extends AbstractSteps {

    private ReportPage reportPage;
    private String startDate = "4/4/2022";
    private String endDate = "4/6/2022";
    private String startDateField = "Start Date";
    private String endDateField = "End Date";
    private String option = "Hills";
    private String button = "View Report";

    public ReportSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Remove data from the calendar's fields")
    public ReportSteps removeValueByDefaultFromCalendars() {
        reportPage = new ReportPage(driver);
        new CalendarComponent(driver, startDateField).deleteValueByDefault();
        new CalendarComponent(driver, endDateField).deleteValueByDefault();
        return this;
    }

    @Step("Insert data to the calendar's fields")
    public ReportSteps addValueToCalendars() {
        reportPage = new ReportPage(driver);
        reportPage.waitPageLoaded();
        new CalendarComponent(driver, startDateField).insertValue(startDate);
        new CalendarComponent(driver, endDateField).insertValue(endDate);
        return this;
    }

    @Step("Select option in the select")
    public ReportSteps selectActivityType() {
        reportPage = new ReportPage(driver);
        reportPage.waitPageLoaded();
        new Select(driver, "Activity Type").selectOption(option);
        return this;
    }

    @Step("Select option in the select")
    public ReportSteps clickButtonViewReport() {
        reportPage = new ReportPage(driver);
        reportPage.waitPageLoaded();
        new MainButton(driver,button).clickButton();
        return this;
    }

    @Step("Check report by dates")
    public ReportSteps checkDateInReport() {
        Table table = new Table(driver);
        String partOfStartDate = startDate.substring(0, startDate.length() - 5);
        String partOfEndDate = endDate.substring(0, endDate.length() - 5);

        boolean result = false;
        if (table.ListOfDate() != null) {
            for (int i = 0; i < table.ListOfDate().size(); i++) {
                if ((table.ListOfDate().get(i).contains(partOfStartDate)) ||
                        (table.ListOfDate().get(i).contains(partOfEndDate))) {
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
    public ReportSteps checkDateAndActivityInReport() {
        Table table = new Table(driver);
        String partOfStartDate = startDate.substring(0, startDate.length() - 5);
        String partOfEndDate = endDate.substring(0, endDate.length() - 5);

        boolean result = false;
        if (table.ListOfDate() != null) {
            for (int i = 0; i < table.ListOfDate().size(); i++) {
                if (((table.ListOfDate().get(i).contains(partOfStartDate)) ||
                        (table.ListOfDate().get(i).contains(partOfEndDate))) &&
                        (table.listOfDateActivity(option).get(i).contains(option))) {

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
