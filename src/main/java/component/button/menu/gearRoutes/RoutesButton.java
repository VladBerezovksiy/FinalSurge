package component.button.menu.gearRoutes;

import component.button.menu.AbstractMenuButton;
import org.openqa.selenium.WebDriver;

public class RoutesButton extends AbstractMenuButton {

    private static final String GEAR_ROUTES_LABEL = "Gear & Routes";
    private static final String ROUTES_LABEL = "Routes";

    public RoutesButton(WebDriver driver) {
        super(driver, GEAR_ROUTES_LABEL, ROUTES_LABEL);
    }
}
