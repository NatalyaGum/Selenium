package by.epam.pageobject_model.utils;

import by.epam.pageobject_model.driver.DriverSingleton;
import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private final Logger LOGGER = LogManager.getRootLogger();

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult iTestResult) {
        saveScreenshot();
        LOGGER.error(iTestResult.getThrowable().getMessage());
    }

    public void onTestSkipped(ITestResult iTestResult) {
        try { File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
            File copy=new File(".//target/screenshots/"
                    + getCurrentTimeAsString() +
                    ".png");
            FileUtils.copyFile(screenCapture, copy);
            LOGGER.error("RP_MESSAGE#FILE#{}#{}", copy.getAbsolutePath()," - Saved screenshot");
        } catch (Exception e) {
            LOGGER.error("Failed: " + e.getMessage());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }

    private void saveScreenshot() {
        try { File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
            File copy=new File(".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png");
            FileUtils.copyFile(screenCapture, copy);
            LOGGER.error("RP_MESSAGE#FILE#{}#{}", copy.getAbsolutePath()," - Saved screenshot");
        } catch (Exception e) {
            LOGGER.error("Failed: " + e.getMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
