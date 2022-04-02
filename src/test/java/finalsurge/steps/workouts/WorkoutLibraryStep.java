package finalsurge.steps.workouts;

import component.forms.CreateActivityFormComponent;
import component.forms.fieldWorkoutLibrary.DropDown;
import component.forms.fieldWorkoutLibrary.Input;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.workouts.WorkoutLibraryPage;

public class WorkoutLibraryStep extends AbstractSteps {

    private WorkoutLibraryPage workoutLibraryPage;

    public WorkoutLibraryStep(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Workout to Library with {library}, {activityType} and {name} data")
    @Description("Check that it is possible to add valid data in Workout Library")
    public WorkoutLibraryStep createNewWorkout(String library, String activityType, String name) {
        workoutLibraryPage = new WorkoutLibraryPage(driver);
        validatePageIsLoaded(workoutLibraryPage);
        CreateActivityFormComponent form = new CreateActivityFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not displayed")
        );
        fillWorkoutForm(library, activityType, name);
        form.save();
        return this;
    }

    private void fillWorkoutForm(String library, String activityType, String name) {
        new DropDown(driver, "Library").selectOption(library);
        new DropDown(driver, "Activity Type").selectOption(activityType);
        new Input(driver, "Name").insert(name);
    }

    @Step("Check {typeActivity}, {nameWorkout} data from 'Workout Library' table is matched")
    @Description("Check that added data from 'Workout Library' table is matched")
    public void validateWorkoutDataCreated(String typeActivity, String nameWorkout) {
        workoutLibraryPage.validateValueFormTable(typeActivity, nameWorkout);
    }

}
