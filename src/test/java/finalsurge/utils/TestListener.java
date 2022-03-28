package finalsurge.utils;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.Date;

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult iTestResult) {
        AllureUtils.attachScreenshot(getScreenshot(iTestResult));
    }

    private byte[] getScreenshot(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            if (driver != null) {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } else {
                return null;
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return null;
        }
    }

    private File takeScreenshotToFile(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        try {
            WebDriver driver = (WebDriver) context.getAttribute("driver");
            System.out.println("driver = " +  String.valueOf(driver));
            if (driver != null) {
                String filename = String.format("%s%s_screenshot.jpg", "target/site/", new Date());
                byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                return FileUtils.bytesToFile(filename, bytes);
            } else {
                return null;
            }
        } catch (NoSuchSessionException | IllegalStateException ex) {
            return null;
        }
    }
}