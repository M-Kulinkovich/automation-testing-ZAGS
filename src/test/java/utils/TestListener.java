package utils;

import io.qameta.allure.Allure;
import org.example.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverSingleton.getDriver();
        if (driver != null) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot_Failure", new ByteArrayInputStream(screenshotBytes));
        }
    }
}
