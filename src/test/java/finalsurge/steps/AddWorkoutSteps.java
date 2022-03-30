package finalsurge.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.AddWorkoutPage;

public class AddWorkoutSteps extends AbstractSteps {

    private AddWorkoutPage addWorkoutPage;

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Workout")
    public AddWorkoutSteps createNewWorkout() {
        addWorkoutPage = new AddWorkoutPage(driver);
//        addWorkoutPage.selectAnyActivityType();
        return this;
    }

    private void fillForm() {

    }

    @Step("Check value from Workout form is valid")
    public void validateWorkoutFormCreated() {

    }
}
