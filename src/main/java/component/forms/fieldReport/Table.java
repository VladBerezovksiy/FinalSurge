package component.forms.fieldReport;

import component.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table extends AbstractComponent {
    private static final By TABLE_PATTERN = By.xpath("//div[contains(@class,'w-box-content')]/table");
    private static final String ROW_NAME="//td[@nowrap]";
    private static final String ROW_ACTIVITY_NAME= "//td/a[contains(.,'%s')]";
    private String label;
    public Table(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isComponentDisplayed() {
        return false;
    }

    public boolean CheckListOfProducts() {
        return driver.findElements(TABLE_PATTERN).isEmpty();
    }


    /*
          public String CheckCountIcon() {
              return driver.findElement(By.cssSelector(COUNT_ICON)).getText();
          }
      */
    public List<String> ListOfDate() {
        List<WebElement> elems;
        List<String> expectedProductList = new ArrayList<>();
        String str;
        if (!CheckListOfProducts()) {
            elems = driver.findElements(TABLE_PATTERN);
            System.out.println("size:"+elems.size());
            for (int i = 0; i < elems.size(); i++) {
                //  expectedProductList.add("[class='cart_item']");
                str=driver.findElements(By.xpath(ROW_NAME)).get(i).getText();
                System.out.println("str"+str);
                expectedProductList.add(driver.findElements(By.xpath(ROW_NAME)).get(i).getText());
            }
            return expectedProductList;
        } else {
            return null;
        }
    }

    public List<String> ListOfDateActivity(String activity) {
        List<WebElement> elems;
        List<String> expectedProductList = new ArrayList<>();
        String str;
        if (!CheckListOfProducts()) {
            elems = driver.findElements(TABLE_PATTERN);
            System.out.println("size:"+elems.size());
            for (int i = 0; i < elems.size(); i++) {
                //  expectedProductList.add("[class='cart_item']");
                str=driver.findElements(By.xpath(String.format(ROW_ACTIVITY_NAME, activity))).get(i).getText();
                System.out.println("str"+str);
                expectedProductList.add(driver.findElements(By.xpath(String.format(ROW_ACTIVITY_NAME, activity))).get(i).getText());
            }
            return expectedProductList;
        } else {
            return null;
        }
    }

}
