package finalsurge.steps.pages.workouts;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Input;
import component.forms.field.RadioButton;
import finalsurge.constants.button.SaveButtonConstants;
import finalsurge.constants.forms.FormNameConstants;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import models.WorkoutModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.workouts.AddWorkoutPage;
import pages.workouts.WorkoutDetailsPage;

public class AddWorkoutSteps extends AbstractSteps {

    private AddWorkoutPage addWorkoutPage;

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Workout with {label} activity, {option} option, {date} date, {name} name, {distance}, dist, {perceivedEffort} effort and {howFeel} feel")
    @Description("Check that it is possible to add valid data in Workout Form")
    public AddWorkoutSteps createNewWorkout(String label, String option, String date, String name, String distance, String perceivedEffort, String howFell) {
        addWorkoutPage = new AddWorkoutPage(driver);
        addWorkoutPage.selectAnyActivityType(label, option);
        CreateActivityFormComponent form = new CreateActivityFormComponent(
                driver,
                SaveButtonConstants.SAVE_BUTTON_ID,
                FormNameConstants.ADD_NEW_WORKOUT_FORM
        );
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed!")
        );
        fillWorkoutForm(date, name, distance, perceivedEffort, howFell);
        form.save();
        validatePageIsLoaded(new WorkoutDetailsPage(driver));
        return this;
    }

    private void fillWorkoutForm(String date, String name, String distance, String perceivedEffort, String howFell) {
        new Input(driver, "WorkoutDate").insert(date);
        new Input(driver, "Name").insert(name);
        new Input(driver, "Distance").insert(distance);
        new DropDown(driver, "PerEffort").selectOption(perceivedEffort);
        new RadioButton(driver, howFell).click();
    }

    @Step("Check data from 'Workout Details' page is matched")
    @Description("Check that added data from 'Workout Details' page is matched")
    public void validateWorkoutCreated(String activity, String optionActivity, String name, String distance, String perceivedEffort, String howFell) {
        addWorkoutPage.validateValueFromWorkoutDetails(activity, optionActivity, name, distance, perceivedEffort, howFell);
    }
}
