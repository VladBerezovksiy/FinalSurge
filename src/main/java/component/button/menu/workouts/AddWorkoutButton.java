package component.button.menu.workouts;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class AddWorkoutButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_LABEL = "Workouts";
    private static final String ADDWORKOUT_BUTTON_LABEL = "Add Workout";

    public AddWorkoutButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_LABEL, ADDWORKOUT_BUTTON_LABEL);
    }
}
