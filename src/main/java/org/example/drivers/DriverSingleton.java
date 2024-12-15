package org.example.drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.AdminDataFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSingleton {
    private static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverSingleton.class);

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {

        if (driver == null) {
            logger.info("Initialization WebDriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
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
