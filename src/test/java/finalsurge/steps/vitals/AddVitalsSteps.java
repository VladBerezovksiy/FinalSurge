package finalsurge.steps.vitals;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Table;
import component.forms.fieldDailyVitals.Button;

import component.forms.field.Input;
import component.forms.fieldDailyVitals.Calendar;
import component.forms.fieldDailyVitals.Link;
import component.forms.fieldReportsStatistics.CalendarComponent;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.VitalsModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.dailyVitals.ViewPage;

@Log4j2
public class AddVitalsSteps extends AbstractSteps {

    private ViewPage viewPage;

    private String addButtonName = "Add Vitals";
    private String addButtonId = "saveButton";
    private String cancelButtonName = "Cancel Add";
    private String dateField = "Date";
    private String steps = "Steps";
    private String weight = "Weight";
    private String weight_select = "WeightType";
    private String sleep_amount = "SleepAmount";
    private String viewButtonID = "viewButton";
    private String customViewLink = "Custom View";
    private String startDateField = "Start Date";
    private String endDateField = "End Date";

    public AddVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Checking for missing elements to add")
    public AddVitalsSteps checkingMissingDailyVitalsAdd() {
        viewPage = new ViewPage(driver);
        String buttonName = new Button(driver, addButtonName).getButtonName();
        System.out.println("buttonName: " + buttonName);
        if (buttonName.equals(addButtonName)) {
            viewPage.checkAddElementsDisplay();
            Assert.assertTrue(viewPage.checkAddElementsDisplay(), "the table with elements for adding is displayed");
        } else if (buttonName.equals(cancelButtonName)) {
            Assert.assertFalse(viewPage.checkAddElementsDisplay(), "the table with elements for adding isn't displayed");
        } else {
            Assert.assertTrue(viewPage.checkAddElementsDisplay(), "the table with elements for adding isn't displayed");
        }
        return this;
    }

    @Step("Adding the new Vitals")
    public AddVitalsSteps addNewVitals() {
        viewPage = new ViewPage(driver);
        new Button(driver, addButtonName).clickButton();
        new Calendar(driver, dateField).insertValue(new VitalsModel().getDate());
        new Input(driver, steps).insert(new VitalsModel().getSteps());
        new DropDown(driver, sleep_amount).selectOption("Not Enough");
        new Input(driver, weight).insert(new VitalsModel().getWeight());
        new DropDown(driver, weight_select).selectOption(new VitalsModel().getWeight_dimension());
        new CreateActivityFormComponent(driver, addButtonId, "Daily Vitals").isComponentDisplayed();
        new CreateActivityFormComponent(driver, addButtonId, "Daily Vitals").save();
        return this;
    }


    @Step("Check entered data in the table")
    public AddVitalsSteps checkDateInTable() {
        new Link(driver, customViewLink).clickLink();
        new CalendarComponent(driver, startDateField).deleteValueByDefault();
        new CalendarComponent(driver, startDateField).insertValue(new VitalsModel().getDate());
        new CalendarComponent(driver, endDateField).deleteValueByDefault();
        new CalendarComponent(driver, endDateField).insertValue(new VitalsModel().getEndDate());
        new CreateActivityFormComponent(driver, viewButtonID, "Daily Vitals").save();
        Table table = new Table(driver);
        boolean result = false;
        log.info("Table with data is displayed [{}] ", "option");
        table.isComponentDisplayed();
        if (table.ListOfVitalDate() != null) {
            for (int i = 0; i < table.ListOfVitalDate().size(); i++) {
                if (table.listOfDateVatals(new VitalsModel().getDate()).get(i).contains(new VitalsModel().getDate())
                        && (table.listOfDateVatals(new VitalsModel().getSteps()).get(i).contains(new VitalsModel().getSteps()))
                        && (table.listOfDateVatals(new VitalsModel().getWeight()).get(i).contains(new VitalsModel().getWeight()))
                        && (table.listOfDateVatals(new VitalsModel().getWeight_dimension()).get(i).contains(new VitalsModel().getWeight_dimension()))
                ) {

                    result = true;
                } else {
                    result = false;
                }
            }
        }
        Assert.assertTrue(result, "Selected data doesn't match the info in the table");
        return this;
    }

    @Step("Check that the message is displayed")
    public String checkMessage(String date, String step) {
        viewPage = new ViewPage(driver);
        new Button(driver, addButtonName).clickButton();
        new Calendar(driver, dateField).insertValue(date);
        new Input(driver, steps).insert(step);
        new CreateActivityFormComponent(driver, addButtonId, "Daily Vitals").save();
        return viewPage.getAllertText();

    }
}
