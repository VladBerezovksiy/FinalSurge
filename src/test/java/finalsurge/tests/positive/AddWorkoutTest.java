package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import models.WorkoutModel;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    @Test
    public void addWorkoutTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openAddWorkout()
                .createNewWorkout("Swim", "Drills")
                .validateWorkoutCreated(new WorkoutModel());
    }
}
