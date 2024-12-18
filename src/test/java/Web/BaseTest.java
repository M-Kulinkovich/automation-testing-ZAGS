package Web;

import io.qameta.allure.Epic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.drivers.DriverSingleton;
import org.example.config.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

@Epic ("WEB tests")
public abstract class BaseTest {
    protected WebDriver driver;
    protected static final Logger Weblogger = LogManager.getLogger(BaseTest.class);

    @Parameters ("browser")
    public void setUp(String browser) throws Exception {
        driver = DriverSingleton.getDriver(browser);
        driver.get(ConfProperties.getProperty("BASE_URL"));
    }

    @BeforeMethod
    @Parameters ("browser")
    public void init(String browser) throws Exception {
        setUp(browser);
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quitDriver();
        Weblogger.info("WEB test completed \n ------------------------------------------------------------------");

    }
}

