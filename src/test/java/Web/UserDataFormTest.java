package Web;

import io.qameta.allure.Description;
import org.example.data.RegistrationUserDataProvider;
import org.example.pages.RoleSelectPage;
import org.example.pages.UserDataFormPage;
import org.example.data.UserRegistrationDataVO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.utils.Constants.APPLICATION_SENDING_INFO;
import static org.example.utils.Constants.FORM_NOT_SUBMITTED_MESSAGE;

public class UserDataFormTest extends BaseTest {
    private UserDataFormPage userDataFormPage;
    private RoleSelectPage roleSelectPage;

    @BeforeMethod
    public void setupTest() {
        roleSelectPage = new RoleSelectPage(driver);
        userDataFormPage = new UserDataFormPage(driver);
        roleSelectPage.clickUserButton();

    }

    UserRegistrationDataVO.ApplicantData applicantData = RegistrationUserDataProvider.getApplicantData();
    UserRegistrationDataVO.CitizenData citizenData = RegistrationUserDataProvider.getCitizenData();

    @Test
    @Description ("Проверка регистрации брака")
    public void testUserMarriageService() {
        Weblogger.info("Starting test: testUserMarriageService");

        UserRegistrationDataVO.ServiceData marriageData = RegistrationUserDataProvider.getMarriageServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectMarriageService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillMarriageServiceForm(marriageData);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);
    }

    @Test
    @Description ("Проверка регистрации смерти")
    public void testUserDeathService() {
        Weblogger.info("Starting test: testUserDeathService");

        UserRegistrationDataVO.ServiceData deathData = RegistrationUserDataProvider.getDeathServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectDeathService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillDeathServiceForm(deathData);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);
    }

    @Test
    @Description ("Проверка регистрации рождения")
    public void testUserBirthService() {
        Weblogger.info("Starting test: testUserBirthService");

        UserRegistrationDataVO.ServiceData birthdayDaya = RegistrationUserDataProvider.getBirthdayServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectBirthdayService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillBirthdayServiceForm(birthdayDaya);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);
    }
}
