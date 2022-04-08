package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import models.WorkoutLibraryModel;
import org.testng.annotations.Test;

public class WorkoutLibraryTest extends BaseTest {

    private final WorkoutLibraryModel workoutLibraryModel = new WorkoutLibraryModel();

    @Test(groups = "smoke")
    public void addWorkoutLibraryTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openWorkoutLibrary()
                .createNewWorkout(
                        workoutLibraryModel.getLibrary(),
                        workoutLibraryModel.getActivity(),
                        workoutLibraryModel.getName()
                )
                .validateWorkoutDataCreated("Run", workoutLibraryModel.getName());
    }
}