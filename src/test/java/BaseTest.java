import org.example.drivers.DriverSingleton;
import org.example.utils.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public abstract class BaseTest {
    protected WebDriver driver;

    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.get(ConfProperties.getProperty("BASE_URL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void init() {
        setUp();
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quitDriver();
    }
}

