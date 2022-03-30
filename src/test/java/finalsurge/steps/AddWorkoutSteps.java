package finalsurge.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AddWorkoutSteps extends AbstractSteps {

    public AddWorkoutSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Workout")
    public AddWorkoutSteps createNewWorkout() {

        return this;
    }
}
