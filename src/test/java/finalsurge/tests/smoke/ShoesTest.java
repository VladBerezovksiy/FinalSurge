package finalsurge.tests.smoke;

import finalsurge.tests.BaseTest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.ShoeModel;
import org.testng.annotations.Test;

public class ShoesTest extends BaseTest {

    private final ShoeModel shoeModel = new ShoeModel();

    @Severity(value = SeverityLevel.NORMAL)
    @Test(groups = "smoke")
    public void addShoesTest() {
        mainSteps
                .openLoginPage()
                .loginWithValidCredits()
                .openShoes()
                .createNewShoe(shoeModel.getName(),
                        shoeModel.getModel(),
                        shoeModel.getCost(),
                        shoeModel.getDistance(),
                        shoeModel.getSize()
                )
                .validateShoeCreated(shoeModel.getName(),
                        shoeModel.getModel(),
                        shoeModel.getCost(),
                        shoeModel.getDistance(),
                        shoeModel.getSize()
                );
    }
}