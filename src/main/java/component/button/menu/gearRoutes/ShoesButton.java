package component.button.menu.gearRoutes;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class ShoesButton extends AbstractMenuButton {

    private static final String GEAR_ROUTES_TEXT = "Gear & Routes";
    private static final String SHOES_TEXT = "Shoes";

    public ShoesButton(WebDriver driver) {
        super(driver, GEAR_ROUTES_TEXT, SHOES_TEXT);
    }
}
