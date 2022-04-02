package finalsurge.steps.gearRoutes;

import component.forms.CreateActivityFormComponent;
import component.forms.fieldGearRoutes.DropDown;
import component.forms.fieldGearRoutes.Input;
import finalsurge.steps.AbstractSteps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.gearRoutes.ShoesPage;

public class ShoesSteps extends AbstractSteps {

    private ShoesPage shoesPage;

    public ShoesSteps(WebDriver driver) {
        super(driver);
    }

    public ShoesSteps createNewShoe(String shoeName, String shoeModel, String shoeCost, String distance, String brand, String size) {
        shoesPage = new ShoesPage(driver);
        CreateActivityFormComponent form = new CreateActivityFormComponent(driver);
        Assert.assertTrue(
                form.isComponentDisplayed(),
                form.getClass().getSimpleName().concat(" not display")
        );
        fillShoeForm(shoeName, shoeModel, shoeCost, distance, brand, size);
        form.save();
        return this;
    }

    private void fillShoeForm(String shoeName, String shoeModel, String shoeCost, String distance, String brand, String size) {
        new Input(driver, "ShoeName").insert(shoeName);
        new Input(driver, "ShoeModel").insert(shoeModel);
        new Input(driver, "ShoeCost").insert(shoeCost);
        new Input(driver, "DistAlert").insert(distance);
        new DropDown(driver, "ShoeBrand").selectOption(brand);
        new DropDown(driver, "ShoeSize").selectOption(size);
    }

    public void validateShoeCreated() {

    }
}
