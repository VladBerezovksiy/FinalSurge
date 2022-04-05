package finalsurge.steps.pages.workouts;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Input;
import component.forms.fieldAddWorkout.RadioButton;
import finalsurge.constants.button.SaveButtonConstants;
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

    @Step("Create new Workout with {label} activity and {option} option")
    @Description("Check that it is possible to add valid data in Workout Form")
    public AddWorkoutSteps createNewWorkout(String label, String option) {
        addWorkoutPage = new AddWorkoutPage(driver);
        addWorkoutPage.selectAnyActivityType(label, option);
        CreateActivityFormComponent form = new CreateActivityFormComponent(driver, SaveButtonConstants.saveButton, "Add New Workout");
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed!")
        );
        fillWorkoutForm(new WorkoutModel());
        form.save();
        validatePageIsLoaded(new WorkoutDetailsPage(driver));
        return this;
    }

    private void fillWorkoutForm(WorkoutModel workoutModel) {
        new Input(driver, "WorkoutDate").insert(workoutModel.getDate());
        new Input(driver, "Name").insert(workoutModel.getName());
        new Input(driver, "Distance").insert(workoutModel.getDistance());
        new DropDown(driver, "PerEffort").selectOption(workoutModel.getPerceivedEffort());
        new RadioButton(driver, workoutModel.getHowIFeel()).click();
    }

    @Step("Check data from 'Workout Details' page is matched")
    @Description("Check that added data from 'Workout Details' page is matched")
    public void validateWorkoutCreated(WorkoutModel expectedModel) {
        Assert.assertEquals(
                new WorkoutModel().getName(),
                expectedModel.getName(),
                String.format("'%s' is not valid", expectedModel.getName())
        );
        Assert.assertEquals(
                new WorkoutModel().getDistance(),
                expectedModel.getDistance(),
                String.format("'%s' is not valid", expectedModel.getDistance())
        );
    }
}
