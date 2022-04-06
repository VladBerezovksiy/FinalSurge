package component.forms.field;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractComponent {

    private static final By TABLE_PATTERN =
            By.xpath("//div[contains(@class,'w-box-content')]/table");
    private static final String ROW_NAME = "//td[@nowrap]";
    private static final String ROW_ACTIVITY_NAME = "//td/a[contains(.,'%s')]";
    private static final String ROW_VITAL = "//td/a";
    private static final String ROW_VITAL_NAME = " //td[contains(.,'%s')]";

    public Table(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return driver.findElement(TABLE_PATTERN).isDisplayed();
    }

    public boolean checkListInReport() {
        return driver.findElements(TABLE_PATTERN).isEmpty();
    }

    public List<String> listOfDate() {
        List<WebElement> elems;
        List<String> expectedReportList = new ArrayList<>();
        if (!checkListInReport()) {
            elems = driver.findElements(TABLE_PATTERN);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(driver.findElements(By.xpath(ROW_NAME)).get(i).getText());
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
            elems = driver.findElements(TABLE_PATTERN);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(
                        driver.findElements(By.xpath(String.format(ROW_ACTIVITY_NAME, activity))).get(i).getText()
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
            elems = driver.findElements(TABLE_PATTERN);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(driver.findElements(By.xpath(ROW_VITAL)).get(i).getText());
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
            elems = driver.findElements(TABLE_PATTERN);
            for (int i = 0; i < elems.size(); i++) {
                expectedReportList.add(
                        driver.findElements(By.xpath(String.format(ROW_VITAL_NAME, vitals))).get(i).getText()
                );
            }
            return expectedReportList;
        } else {
            return null;
        }
    }
}