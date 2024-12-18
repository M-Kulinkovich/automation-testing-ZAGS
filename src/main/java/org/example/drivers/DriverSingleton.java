package org.example.drivers;

import com.google.common.collect.ImmutableMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;


public class DriverSingleton {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);

    private DriverSingleton() {
    }

    public static WebDriver getDriver(String browser) throws Exception {

        if (driver == null) {
            System.out.println("Initializing WebDriver");

            Capabilities capabilities = null;
            URL selenoidURL = new URL("http://localhost:4444/wd/hub");

            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setCapability("browserName", "chrome");
                    capabilities = chromeOptions;
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("browserName", "firefox");
                    capabilities = firefoxOptions;
                    break;
                case "opera":
                    ChromeOptions operaOptions = new ChromeOptions();
                    operaOptions.setCapability("browserName", "opera");
                    operaOptions.setCapability("browserVersion", "latest");
                    capabilities = operaOptions;
                    break;
                default:
                    throw new IllegalArgumentException("Browser error: " + browser);
            }
            driver = new RemoteWebDriver(selenoidURL, capabilities);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            logger.info("close WebDriver");
            driver.quit();
            driver = null;
        }
    }
}
