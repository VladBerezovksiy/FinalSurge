package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class RoutesTest extends BaseTest {

    @Test(groups = "smoke")
    public void addRoutesTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openRoutes()
                .createNewRoutes("Test", "Walk", "101")
                .validateRoutesCreated("Test", "Walk", "101");
    }

}