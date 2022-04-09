package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import finalsurge.utils.Retry;
import models.WorkoutModel;
import org.testng.annotations.Test;

public class AddWorkoutTest extends BaseTest {

    private final WorkoutModel workoutModel = new WorkoutModel();

    @Test(groups = "smoke", retryAnalyzer = Retry.class)
    public void addWorkoutTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openAddWorkout()
                .createNewWorkout(
                        workoutModel.getActivity(),
                        workoutModel.getOptionActivity(),
                        workoutModel.getDate(),
                        workoutModel.getName(),
                        workoutModel.getDistance(),
                        workoutModel.getPerceivedEffort(),
                        workoutModel.getHowIFeel()
                )
                .validateWorkoutCreated(
                        workoutModel.getActivity(),
                        workoutModel.getOptionActivity(),
                        workoutModel.getName(),
                        workoutModel.getDistance(),
                        workoutModel.getPerceivedEffort(),
                        workoutModel.getHowIFeel()
                );
    }
}