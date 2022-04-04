package finalsurge.tests.positive;

import finalsurge.tests.BaseTest;
import org.testng.annotations.Test;

public class ShoesTest extends BaseTest {

    @Test
    public void addShoesTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openShoes()
                .createNewShoe("Test", "Lui", "10", "63", "2")
                .validateShoeCreated("Test", "Lui", "10", "2", "63");
    }

}