package component.button.menu.dailyVitals;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class ViewAddVitalsButton extends AbstractMenuButton {

    public static final String DAILY_VITALS_MENU_LABEL = "Gear & Routes";
    public static final String ITEM_MENU_LABEL = "Shoes";

    public ViewAddVitalsButton(WebDriver driver) {
        super(driver, DAILY_VITALS_MENU_LABEL, ITEM_MENU_LABEL);
    }
}
