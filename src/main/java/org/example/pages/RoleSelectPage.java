package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoleSelectPage {
    protected WebDriver driver;

    @FindBy (xpath = "//*/button[text()='Войти как пользователь']")
    private WebElement userButton;

    @FindBy (xpath = "//*/button[text()='Войти как администратор']")
    private WebElement adminButton;

    public RoleSelectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickUserButton() {
        userButton.click();
    }

    public void clickAdminButton() {
        adminButton.click();
    }
}



