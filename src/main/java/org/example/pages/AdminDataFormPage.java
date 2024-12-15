package org.example.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.WEB.AdminRegistrationDataVO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDataFormPage {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(AdminDataFormPage.class);

    @FindBy (id = "TextInputField-1")
    private WebElement adminLastNameField;
    @FindBy (id = "TextInputField-2")
    private WebElement adminFirstNameField;
    @FindBy (id = "TextInputField-3")
    private WebElement adminMiddleNameField;
    @FindBy (id = "TextInputField-4")
    private WebElement adminPhoneNumberField;
    @FindBy (id = "TextInputField-5")
    private WebElement adminPassportNumberField;
    @FindBy (id = "TextInputField-6")
    private WebElement adminDoBField;
    @FindBy (xpath = "//*/button[text()='Далее']")
    private WebElement nextButton;

    public AdminDataFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step ("Заполнение формы администратора данными")
    public void fillRegistrationAdminForm(AdminRegistrationDataVO registrationData) {
        logger.info("Filling data to admin form");

        adminLastNameField.sendKeys(registrationData.getAdminLastName());
        adminFirstNameField.sendKeys(registrationData.getAdminFirstName());
        adminMiddleNameField.sendKeys(registrationData.getAdminMiddleName());
        adminPhoneNumberField.sendKeys(registrationData.getAdminPhoneNumber());
        adminPassportNumberField.sendKeys(registrationData.getAdminPassportNumber());
        adminDoBField.sendKeys(registrationData.getAdminDoB());
        nextButton.click();
    }

    public String resultOfSendingRequest() {
        return driver.findElement(By.xpath("//*/b[text()='Aдминистратор']")).getText();
    }

}