package Web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.drivers.DriverSingleton;
import org.example.utils.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {
    protected WebDriver driver;
    protected static final Logger Weblogger = LogManager.getLogger(BaseTest.class);

    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(ConfProperties.getProperty("BASE_URL"));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void init() {
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quitDriver();
        Weblogger.info("test completed \n ------------------------------------------------------------------");

    }
}

