package org.example.pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.data.UserRegistrationDataVO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDataFormPage {
    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(UserDataFormPage.class);

    @FindBy (id = "TextInputField-1")
    private WebElement lastNameField;
    @FindBy (id = "TextInputField-2")
    private WebElement firstNameField;
    @FindBy (id = "TextInputField-3")
    private WebElement middleNameField;
    @FindBy (id = "TextInputField-4")
    private WebElement phoneNumberField;
    @FindBy (id = "TextInputField-5")
    private WebElement passportNumberField;
    @FindBy (id = "TextInputField-6")
    private WebElement addressField;
    @FindBy (xpath = "//*/button[text()='Далее']")
    private WebElement nextButton;
    @FindBy (xpath = "//*/button[text()='Регистрация рождения']")
    private WebElement birthdaySelectButton;
    @FindBy (xpath = "//*/button[text()='Регистрация брака']")
    private WebElement marriageSelectButton;
    @FindBy (xpath = "//*/button[text()='Регистрация смерти']")
    private WebElement deathSelectButton;
    @FindBy (id = "TextInputField-7")
    private WebElement citizenLastNameField;
    @FindBy (id = "TextInputField-8")
    private WebElement citizenFirstNameField;
    @FindBy (id = "TextInputField-9")
    private WebElement citizenMiddleNameField;
    @FindBy (id = "TextInputField-10")
    private WebElement citizenDateOfBirthField;
    @FindBy (id = "TextInputField-11")
    private WebElement citizenPassportNumberField;
    @FindBy (id = "TextInputField-12")
    private WebElement citizenSexField;
    @FindBy (xpath = "//label[text()='Дата регистрации']/following-sibling::input")
    private WebElement registrationDateField;
    @FindBy (xpath = "//label[text()='Новая фамилия']/following-sibling::input")
    private WebElement newLastNameField;
    @FindBy (xpath = "//label[text()='Фамилия супруга/и']/following-sibling::input")
    private WebElement spouseLastNameField;
    @FindBy (xpath = "//label[text()='Имя супруга/и']/following-sibling::input")
    private WebElement spouseFirstNameField;
    @FindBy (xpath = "//label[text()='Отчество супруга/и']/following-sibling::input")
    private WebElement spouseMiddleNameField;
    @FindBy (xpath = "//label[text()='Дата рождения супруга/и']/following-sibling::input")
    private WebElement spouseDateOfBirthField;
    @FindBy (xpath = "//label[text()='Номер паспорта супруга/и']/following-sibling::input")
    private WebElement spousePassportNumberField;
    @FindBy (xpath = "//*/button[text()='Завершить']")
    private WebElement finishButton;
    @FindBy (xpath = "//*/button[text()='Обновить']")
    private WebElement refreshApplicantButton;
    @FindBy (xpath = "//*/button[text()='Создать новую заявку']")
    private WebElement createNewApplicantButton;
    @FindBy (xpath = "//*/button[text()='Закрыть']")
    private WebElement exitButton;
    @FindBy (xpath = "//label[text()='Место рождения']/following-sibling::input")
    private WebElement placeOfBirthField;
    @FindBy (xpath = "//label[text()='Мать']/following-sibling::input")
    private WebElement motherNameField;
    @FindBy (xpath = "//label[text()='Отец']/following-sibling::input")
    private WebElement fatherNameField;
    @FindBy (xpath = "//label[text()='Дата смерти']/following-sibling::input")
    private WebElement dateOfDeathField;
    @FindBy (xpath = "//label[text()='Место смерти']/following-sibling::input")
    private WebElement placeOfDeathField;

    public UserDataFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step ("Заполнение данных заявителя")
    public void fillApplicantDetails(UserRegistrationDataVO.ApplicantData applicantData) {
        logger.info("Filling data to applicants form");

        lastNameField.sendKeys(applicantData.getLastName());
        firstNameField.sendKeys(applicantData.getFirstName());
        middleNameField.sendKeys(applicantData.getMiddleName());
        phoneNumberField.sendKeys(applicantData.getPhoneNumber());
        passportNumberField.sendKeys(applicantData.getPassportNumber());
        addressField.sendKeys(applicantData.getAddress());
        nextButton.click();
    }

    @Step ("Выбор услуги 'регистрация рождения' ")
    public void selectBirthdayService() {
        logger.info("select birthday service");

        birthdaySelectButton.click();
    }
    @Step ("Выбор услуги 'регистрация брака' ")
    public void selectMarriageService() {
        logger.info("select marriage service");

        marriageSelectButton.click();
    }
    @Step ("Выбор услуги 'регистрация смерти' ")
    public void selectDeathService() {
        logger.info("select death service");

        deathSelectButton.click();
    }

    @Step ("Заполнение данных гражданина")
    public void fillCitizenDate(UserRegistrationDataVO.CitizenData citizenData) {
        logger.info("Filling data to citizen form");

        citizenLastNameField.sendKeys(citizenData.getCitizenLastName());
        citizenFirstNameField.sendKeys(citizenData.getCitizenFirstName());
        citizenMiddleNameField.sendKeys(citizenData.getCitizenMiddleName());
        citizenDateOfBirthField.sendKeys(citizenData.getCitizenDoB());
        citizenPassportNumberField.sendKeys(citizenData.getCitizenPassportNumber());
        citizenSexField.sendKeys(citizenData.getCitizenSex());
        nextButton.click();
    }

    @Step ("Заполнение данных о рождении")
    public void fillBirthdayServiceForm(UserRegistrationDataVO.ServiceData birthServiceData) {
        logger.info("Filling data to birthday form");

        placeOfBirthField.sendKeys(birthServiceData.getPlaceOfBirth());
        motherNameField.sendKeys(birthServiceData.getMotherName());
        fatherNameField.sendKeys(birthServiceData.getFatherName());
        finishButton.click();
    }
    @Step ("Заполнение данных о смерти")
    public void fillDeathServiceForm(UserRegistrationDataVO.ServiceData deathServiceData) {
        logger.info("Filling data to death form");

        placeOfDeathField.sendKeys(deathServiceData.getPlaceOfDeath());
        dateOfDeathField.sendKeys(deathServiceData.getDeathDate());
        finishButton.click();
    }

    @Step ("Заполнение данных о браке")
    public void fillMarriageServiceForm(UserRegistrationDataVO.ServiceData marrigeService) {
        logger.info("Filling data to marriage form");

        registrationDateField.sendKeys(marrigeService.getRegistrationDate());
        newLastNameField.sendKeys(marrigeService.getNewLastName());
        spouseLastNameField.sendKeys(marrigeService.getSpouseLastName());
        spouseFirstNameField.sendKeys(marrigeService.getSpouseFirstName());
        spouseMiddleNameField.sendKeys(marrigeService.getSpouseMiddleName());
        spousePassportNumberField.sendKeys(marrigeService.getSpousePassportNumber());
        spouseDateOfBirthField.sendKeys(marrigeService.getSpouseDateOfBirth());
        finishButton.click();
    }

    public String resultOfSendingRequest() {
        return driver.findElement(By.xpath("//*/span[text()='Ваша заявка отправлена на рассмотрение.']")).getText();
    }
}
