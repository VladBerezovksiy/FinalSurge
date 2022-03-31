package component.button.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_LABEL = "Workouts";
    private static final String REPORT_BUTTON_LABEL = "Reports & Statistics";

    public ReportButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_LABEL, REPORT_BUTTON_LABEL);
    }
}