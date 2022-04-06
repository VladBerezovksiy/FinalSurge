package finalsurge.steps.pages.vitals;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Table;
import component.forms.fieldDailyVitals.Button;
import component.forms.field.Input;
import component.forms.fieldDailyVitals.Calendar;
import component.forms.field.Link;
import component.forms.fieldReportsStatistics.CalendarComponent;
import finalsurge.constants.forms.FormNameConstants;
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

    public AddVitalsSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Checking for missing elements to add")
    public AddVitalsSteps checkingMissingDailyVitalsAdd() {
        viewPage = new ViewPage(driver);
        String buttonName = new Button(driver, FormNameConstants.ADD_BUTTON_NAME).getButtonName();
        System.out.println("buttonName: " + buttonName);
        if (buttonName.equals(FormNameConstants.ADD_BUTTON_NAME)) {
            viewPage.checkAddElementsDisplay();
            Assert.assertTrue(
                    viewPage.checkAddElementsDisplay(),
                    "the table with elements for adding is displayed"
            );
        } else if (buttonName.equals(FormNameConstants.CANCEL_BUTTON_NAME)) {
            Assert.assertFalse(
                    viewPage.checkAddElementsDisplay(),
                    "the table with elements for adding isn't displayed"
            );
        } else {
            Assert.assertTrue(
                    viewPage.checkAddElementsDisplay(),
                    "the table with elements for adding isn't displayed"
            );
        }
        return this;
    }

    @Step("Adding the new Vitals")
    public AddVitalsSteps addNewVitals() {
        viewPage = new ViewPage(driver);
        new Button(driver, FormNameConstants.ADD_BUTTON_NAME).click();
        new Calendar(driver, FormNameConstants.DATE_FIELD).insertValue(new VitalsModel().getDate());
        new Input(driver, FormNameConstants.STEPS).insert(new VitalsModel().getSteps());
        new DropDown(driver, FormNameConstants.SLEEP_AMOUNT).selectOption("Not Enough");
        new Input(driver, FormNameConstants.WEIGHT).insert(new VitalsModel().getWeight());
        new DropDown(driver, FormNameConstants.WEIGHT_SELECT).selectOption(new VitalsModel().getWeight_dimension());
        new CreateActivityFormComponent(
                driver,
                FormNameConstants.ADD_BUTTON_ID,
                FormNameConstants.DAILY_VITALS_FORM
        ).isComponentDisplayed();
        new CreateActivityFormComponent(
                driver,
                FormNameConstants.ADD_BUTTON_ID,
                FormNameConstants.DAILY_VITALS_FORM
        ).save();
        return this;
    }

    @Step("Check entered data in the table")
    public AddVitalsSteps checkDateInTable() {
        new Link(driver, FormNameConstants.CUSTOM_VIEW_LINK).click();
        new CalendarComponent(driver, FormNameConstants.START_DATE_FIELD).deleteValueByDefault();
        new CalendarComponent(driver, FormNameConstants.START_DATE_FIELD).insertValue(new VitalsModel().getDate());
        new CalendarComponent(driver, FormNameConstants.END_DATE_FIELD).deleteValueByDefault();
        new CalendarComponent(driver, FormNameConstants.END_DATE_FIELD).insertValue(new VitalsModel().getEndDate());
        new CreateActivityFormComponent(
                driver,
                FormNameConstants.VIEW_BUTTON_ID,
                FormNameConstants.DAILY_VITALS_FORM
        ).save();
        Table table = new Table(driver);
        boolean result = false;
        log.info("Table with data is displayed [{}] ", "option");
        table.isComponentDisplayed();
        if (table.listOfVitalDate() != null) {
            for (int i = 0; i < table.listOfVitalDate().size(); i++) {
                if (table.listOfDateVatals(new VitalsModel().getDate()).get(i).contains(new VitalsModel().getDate())
                        && (table.listOfDateVatals(
                        new VitalsModel().getSteps()).get(i).contains(new VitalsModel().getSteps()))
                        && (table.listOfDateVatals(
                        new VitalsModel().getWeight()).get(i).contains(new VitalsModel().getWeight()))
                        && (table.listOfDateVatals(
                        new VitalsModel().getWeight_dimension()).get(i).contains(
                        new VitalsModel().getWeight_dimension()))
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
        new Button(driver, FormNameConstants.ADD_BUTTON_NAME).click();
        new Calendar(driver, FormNameConstants.DATE_FIELD).insertValue(date);
        new Input(driver, FormNameConstants.STEPS).insert(step);
        new CreateActivityFormComponent(
                driver,
                FormNameConstants.ADD_BUTTON_ID,
                FormNameConstants.DAILY_VITALS_FORM
        ).save();
        return viewPage.getAllertText();
    }
}
