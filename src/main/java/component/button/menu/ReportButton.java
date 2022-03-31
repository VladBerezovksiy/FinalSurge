package component.button.menu;


import org.openqa.selenium.WebDriver;

public class ReportButton extends AbstractMenuButton {

    private static final String WORKOUTS_BUTTON_LABEL = "Workouts";
    private static final String REPORT_BUTTON_LABEL = "Reports & Statistics";

    public ReportButton(WebDriver driver) {
        super(driver, WORKOUTS_BUTTON_LABEL, REPORT_BUTTON_LABEL);
    }
}