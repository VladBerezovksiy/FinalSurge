package component.button.menu.dailyVitals;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class ViewAddVitalsButton extends AbstractMenuButton {

    private static final String DAILY_VITALS_MENU_TEXT = "Daily Vitals";
    private static final String ITEM_MENU_TEXT = "View & Add Vitals";

    public ViewAddVitalsButton(WebDriver driver) {
        super(driver, DAILY_VITALS_MENU_TEXT, ITEM_MENU_TEXT);
    }
}
