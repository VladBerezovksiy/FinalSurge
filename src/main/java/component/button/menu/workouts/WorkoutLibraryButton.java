package component.button.menu.workouts;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class WorkoutLibraryButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_TEXT = "Workouts";
    private static final String WORKOUT_LIBRARY_BUTTON_TEXT = "Workout Library";

    public WorkoutLibraryButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_TEXT, WORKOUT_LIBRARY_BUTTON_TEXT);
    }
}
