package org.example.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoleSelectPage {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(RoleSelectPage.class);

    @FindBy (xpath = "//*/button[text()='Войти как пользователь']")
    private WebElement userButton;

    @FindBy (xpath = "//*/button[text()='Войти как администратор']")
    private WebElement adminButton;

    public RoleSelectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step ("Войти как пользователь")
    public void clickUserButton() {
        logger.info("Login as user");

        userButton.click();
    }

    @Step ("Войти как администратор")
    public void clickAdminButton() {
        logger.info("Login as admin");

        adminButton.click();
    }
}



