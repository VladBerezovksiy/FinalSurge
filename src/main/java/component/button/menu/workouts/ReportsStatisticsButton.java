package component.button.menu.workouts;


import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class ReportsStatisticsButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_LABEL = "Workouts";
    private static final String REPORT_BUTTON_LABEL = "Reports & Statistics";

    public ReportsStatisticsButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_LABEL, REPORT_BUTTON_LABEL);
    }
}