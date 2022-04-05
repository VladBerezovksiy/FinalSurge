package component.button.menu.gearRoutes;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class ShoesButton extends AbstractMenuButton {

    private static final String GEAR_ROUTES_LABEL = "Gear & Routes";
    private static final String SHOES_LABEL = "Shoes";

    public ShoesButton(WebDriver driver) {
        super(driver, GEAR_ROUTES_LABEL, SHOES_LABEL);
    }
}
