package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class AddShoesTest extends BaseTest {

    @Test
    public void addShoesTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openShoes();

    }
}
