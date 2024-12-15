package Cucumber.Steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.dataProviders.WEB.RegistrationUserDataProvider;
import org.example.models.WEB.UserRegistrationDataVO;
import org.example.pages.UserDataFormPage;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.example.utils.Constants.APPLICATION_SENDING_INFO;
import static org.example.utils.Constants.FORM_NOT_SUBMITTED_MESSAGE;


public class FillDataAndSendRequestStep {
    private static final Logger logger = LogManager.getLogger(UserDataFormPage.class);

    private final SelenideElement lastNameField = $("#TextInputField-1");
    private final SelenideElement firstNameField = $("#TextInputField-2");
    private final SelenideElement middleNameField = $("#TextInputField-3");
    private final SelenideElement phoneNumberField = $("#TextInputField-4");
    private final SelenideElement passportNumberField = $("#TextInputField-5");
    private final SelenideElement addressField = $("#TextInputField-6");
    private final SelenideElement nextButton = $x("//*/button[text()='Далее']");
    private final SelenideElement birthdaySelectButton = $x("//*/button[text()='Регистрация рождения']");
    private final SelenideElement citizenLastNameField = $("#TextInputField-7");
    private final SelenideElement citizenFirstNameField = $("#TextInputField-8");
    private final SelenideElement citizenMiddleNameField = $("#TextInputField-9");
    private final SelenideElement citizenDateOfBirthField = $("#TextInputField-10");
    private final SelenideElement citizenPassportNumberField = $("#TextInputField-11");
    private final SelenideElement citizenSexField = $("#TextInputField-12");
    private final SelenideElement finishButton = $x("//*/button[text()='Завершить']");
    private final SelenideElement placeOfBirthField = $x("//label[text()='Место рождения']/following-sibling::input");
    private final SelenideElement motherNameField = $x("//label[text()='Мать']/following-sibling::input");
    private final SelenideElement fatherNameField = $x("//label[text()='Отец']/following-sibling::input");
    private final SelenideElement resultOfSendingRequest = $x("//*/span[text()='Ваша заявка отправлена на рассмотрение.']");


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


    @And ("Заполняем поля валидными данными")
    public void fillDataUserBirthdayService() {
        UserRegistrationDataVO.ApplicantData applicantData = RegistrationUserDataProvider.getApplicantData();
        UserRegistrationDataVO.CitizenData citizenData = RegistrationUserDataProvider.getCitizenData();
        UserRegistrationDataVO.ServiceData birthdayServiceData = RegistrationUserDataProvider.getBirthdayServiceData();

        fillApplicantDetails(applicantData);
        selectBirthdayService();
        fillCitizenDate(citizenData);
        fillBirthdayServiceForm(birthdayServiceData);
    }

    @Then ("Проверяем что заявка успешно отправлена")
    public void checkResultOfSending() {
        String resultText = resultOfSendingRequest.getText();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);
        logger.info("Application sent successfully");
    }

}
