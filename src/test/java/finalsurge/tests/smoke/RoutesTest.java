package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import models.RoutesModel;
import org.testng.annotations.Test;

public class RoutesTest extends BaseTest {

    private final RoutesModel routesModel = new RoutesModel();

    @Test(groups = "smoke")
    public void addRoutesTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openRoutes()
                .createNewRoutes(routesModel.getName(),
                        routesModel.getActivity(),
                        routesModel.getDistance()
                )
                .validateRoutesCreated(routesModel.getName(),
                        routesModel.getActivity(),
                        routesModel.getDistance()
                );
    }

}