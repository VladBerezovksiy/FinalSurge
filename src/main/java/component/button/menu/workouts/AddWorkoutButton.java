package component.button.menu.workouts;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class AddWorkoutButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_TEXT = "Workouts";
    private static final String ADD_WORKOUT_BUTTON_TEXT = "Add Workout";

    public AddWorkoutButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_TEXT, ADD_WORKOUT_BUTTON_TEXT);
    }
}
