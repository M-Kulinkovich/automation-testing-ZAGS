package Cucumber.Steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.config.ConfProperties;
import org.example.pages.UserDataFormPage;

public class BeforeStep {
    private static final Logger logger = LogManager.getLogger(UserDataFormPage.class);

    @Given ("Открываем сайт {string}")
    public void openWebSite(String url) {
        logger.info("Open site \"https://regoffice.senla.eu/\"");
        Selenide.open(ConfProperties.getProperty("BASE_URL"));
    }
}
