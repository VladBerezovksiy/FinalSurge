package finalsurge.steps.vitals;

import component.forms.fieldDailyVitals.Button;
import component.forms.fieldReport.CalendarComponent;
import finalsurge.steps.AbstractSteps;
import finalsurge.steps.workouts.ReportSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.DailyVitals.ViewPage;
import pages.workouts.ReportPage;

public class AddVitalsSteps extends AbstractSteps {

    private ViewPage viewPage;

    private String addButtonName = "Add Vitals";
    private String cancelButtonName = "Cancel Add";
    private String startDate = "4/4/2022";


    public AddVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Remove data from the calendar's fields")
    public AddVitalsSteps removeValueByDefaultFromCalendars() {
        viewPage = new ViewPage(driver);
        new Button(driver, addButtonName);
        return this;
    }

}
