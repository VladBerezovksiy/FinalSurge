package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import finalsurge.utils.Retry;
import models.WorkoutModel;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    @Test (groups="smoke", retryAnalyzer = Retry.class)
    public void addWorkoutTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openAddWorkout()
                .createNewWorkout("Swim", "Drills")
                .validateWorkoutCreated(new WorkoutModel());
    }

}