package finalsurge.steps.pages.gearRoutes;

import component.forms.CreateActivityFormComponent;
import component.forms.field.DropDown;
import component.forms.field.Input;
import finalsurge.constants.button.SaveButtonConstants;
import finalsurge.constants.forms.FormNameConstants;
import finalsurge.steps.AbstractSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.gearRoutes.RoutesPage;

public class RoutesSteps extends AbstractSteps {

    private RoutesPage routesPage;

    public RoutesSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Create new Route with {routeName} name, {routeActivity} activity and {routeDist} distance")
    @Description("Check that it is possible to add valid data in Route Form")
    public RoutesSteps createNewRoutes(String routeName, String routeActivity, String routeDist) {
        routesPage = new RoutesPage(driver);
        CreateActivityFormComponent form = new CreateActivityFormComponent(
                driver, SaveButtonConstants.SAVE_BUTTON, FormNameConstants.ROUTE_FORM
        );
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not display")
        );
        fillShoeForm(routeName, routeActivity, routeDist);
        form.save();
        return this;
    }

    private void fillShoeForm(String routeName, String routeActivity, String routeDist) {
        new Input(driver, "RouteName").insert(routeName);
        new DropDown(driver, "Activity").selectOption(routeActivity);
        new Input(driver, "Distance").insert(routeDist);
    }

    @Step("Check data from 'Route' table is matched")
    @Description("Check that added data from 'Route' table is matched")
    public void validateRoutesCreated(String name, String activity, String distances) {
        routesPage.validateValueFromTable(name, activity, distances);
    }
}
