package Web;

import org.example.data.RegistrationAdminDataProvider;
import org.example.data.RegistrationUserDataProvider;
import org.example.pages.RoleSelectPage;
import org.example.pages.UserDataFormPage;
import org.example.utils.AdminRegistrationDataVO;
import org.example.utils.UserRegistrationDataVO;
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
    public void testUserMarriageService() {
        UserRegistrationDataVO.ServiceData marriageData = RegistrationUserDataProvider.getMarriageServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectMarriageService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillMarriageServiceForm(marriageData);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);

    }

    @Test
    public void testUserDeathService() {
        UserRegistrationDataVO.ServiceData deathData = RegistrationUserDataProvider.getDeathServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectDeathService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillDeathServiceForm(deathData);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);

    }

    @Test
    public void testUserBirthService() {
        UserRegistrationDataVO.ServiceData birthdayDaya = RegistrationUserDataProvider.getBirthdayServiceData();

        userDataFormPage.fillApplicantDetails(applicantData);
        userDataFormPage.selectBirthdayService();
        userDataFormPage.fillCitizenDate(citizenData);
        userDataFormPage.fillBirthdayServiceForm(birthdayDaya);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains(APPLICATION_SENDING_INFO), FORM_NOT_SUBMITTED_MESSAGE);

    }
}
