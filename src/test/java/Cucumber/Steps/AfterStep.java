package Cucumber.Steps;

import io.cucumber.java.After;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.UserDataFormPage;

import static org.example.drivers.DriverSingleton.quitDriver;

public class AfterStep {
    private static final Logger logger = LogManager.getLogger(UserDataFormPage.class);

    @After
    public void tearDown() {
        quitDriver();
        logger.info("Cucumber test completed \n --------------------------------------------------------------------");
    }

}
