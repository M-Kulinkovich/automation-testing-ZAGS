package org.example.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.AdminDataFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            logger.info("Initialization WebDriver");
            driver = new ChromeDriver();
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
