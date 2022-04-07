package component.button.header;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class IconMenuButton extends AbstractIconButton {

    private static final String ICON_PATTERN = "//nav[@class='nav-icons']//a[@data-reveal-id='%s']";
    private final By iconLocator;

    public IconMenuButton(WebDriver driver, String id) {
        super(driver);
        this.iconLocator = By.xpath(String.format(ICON_PATTERN, id));
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(iconLocator).isDisplayed();
    }

    public void click() {
        log.info("Click [{}] ", "the icon");
        driver.findElement(iconLocator).click();
    }
}