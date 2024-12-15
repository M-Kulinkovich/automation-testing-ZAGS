package Cucumber.Steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.UserDataFormPage;

import static com.codeborne.selenide.Selenide.$x;

public class LoginAsUserStep {
    private static final SelenideElement loginUser = $x("//*/button[text()='Войти как пользователь']");
    private static final Logger logger = LogManager.getLogger(UserDataFormPage.class);

    @When ("Входим как пользователь")
    public static void loginAsUser() {
        logger.info("Login as user");
        loginUser.click();
    }
}
