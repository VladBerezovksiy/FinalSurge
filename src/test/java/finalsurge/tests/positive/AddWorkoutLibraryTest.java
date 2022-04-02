package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class AddWorkoutLibraryTest extends BaseTest {

    @Test
    public void addWorkoutLibraryTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openWorkoutLibrary()
                .createNewWorkout("Default Library", "Hills", "Anything")
                .validateWorkoutDataCreated("Run", "Anything");
    }
}
