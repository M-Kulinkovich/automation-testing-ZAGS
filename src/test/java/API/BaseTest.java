package API;

import API.config.Specifications;
import io.qameta.allure.Epic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.drivers.DriverSingleton;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

@Epic ("API tests")
public abstract class BaseTest {
    protected static final Logger APIlogger = LogManager.getLogger(Web.BaseTest.class);
    @BeforeClass
    public void setup() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
    }

    @AfterMethod
    public void tearDown() {
        DriverSingleton.quitDriver();
        APIlogger.info("API test completed \n ------------------------------------------------------------------");

    }
}
