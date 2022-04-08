package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractComponent {

    private static final By TABLE_LOCATOR =
            By.xpath("//div[contains(@class,'w-box-content')]/table");
    private static final String ROW_NAME_LOCATOR = "//td[@nowrap]";
    private static final String ROW_ACTIVITY_NAME_LOCATOR_PATTERN = "//td/a[contains(.,'%s')]";
    private static final String ROW_VITAL_LOCATOR = "//td/a";
    private static final String ROW_VITAL_NAME_PATTERN = " //td[contains(.,'%s')]";

    public Table(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(TABLE_LOCATOR).isDisplayed();
    }

    public boolean checkListInReport() {
        return driver.findElements(TABLE_LOCATOR).isEmpty();
    }

    public List<String> listOfDate() {
        List<WebElement> elems;
        List<String> expectedReportList = new ArrayList<>();
        if (!checkListInReport()) {
            elems = driver.findElements(TABLE_LOCATOR);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(driver.findElements(By.xpath(ROW_NAME_LOCATOR)).get(i).getText());
            }
            return expectedReportList;
        } else {
            return null;
        }
    }


    public List<String> listOfDateActivity(String activity) {
        List<WebElement> elems;
        List<String> expectedReportList = new ArrayList<>();
        if (!checkListInReport()) {
            elems = driver.findElements(TABLE_LOCATOR);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(
                        driver.findElements(By.xpath(String.format(ROW_ACTIVITY_NAME_LOCATOR_PATTERN, activity))).get(i).getText()
                );
            }
            return expectedReportList;
        } else {
            return null;
        }
    }

    //-------------FOR VITALS----------------------
    public List<String> listOfVitalDate() {
        List<WebElement> elems;
        List<String> expectedReportList = new ArrayList<>();
        if (!checkListInReport()) {
            elems = driver.findElements(TABLE_LOCATOR);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(driver.findElements(By.xpath(ROW_VITAL_LOCATOR)).get(i).getText());
            }
            return expectedReportList;
        } else {
            return null;
        }
    }

    public List<String> listOfDateVatals(String vitals) {
        List<WebElement> elems;
        List<String> expectedReportList = new ArrayList<>();
        if (!checkListInReport()) {
            elems = driver.findElements(TABLE_LOCATOR);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(
                        driver.findElements(By.xpath(String.format(ROW_VITAL_NAME_PATTERN, vitals))).get(i).getText()
                );
            }
            return expectedReportList;
        } else {
            return null;
        }
    }
}