import org.example.pages.RoleSelectPage;
import org.example.pages.UserDataFormPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserDataFormTest extends BaseTest {
    private UserDataFormPage userDataFormPage;
    private RoleSelectPage roleSelectPage;

    // TEST DATA
    private final String lastName = "Doe";
    private final String firstName = "John";
    private final String middleName = "Michael";
    private final String phoneNumber = "1234567890";
    private final String passportNumber = "AB1234567";
    private final String address = "Street 4";

    private final String citizenLastName = "Ivanov";
    private final String citizenFirstName = "Ivan";
    private final String citizenMiddleName = "Ivanovich";
    private final String citizenDoB = "1990-01-01";
    private final String citizenPassportNumber = "AB3456789";
    private final String citizenSex = "Male";

    private final String registrationDate = "2024-11-25";
    private final String spouseLastName = "Petrova";
    private final String newLastName = "Ivanova";
    private final String spouseFirstName = "Anna";
    private final String spouseMiddleName = "Petrovna";
    private final String spouseDateOfBirth = "1992-08-05";
    private final String spousePassportNumber = "AB1234567";
    private final String placeOfDeath = "Moskow";
    private final String deathDate = "2024-11-15";
    private final String placeOfBirth = "Warshaw";
    private final String motherName = "Barbara";
    private final String fatherName = "Oleg";


    @BeforeMethod
    public void setupTest() {
        roleSelectPage = new RoleSelectPage(driver);
        userDataFormPage = new UserDataFormPage(driver);
        roleSelectPage.clickUserButton();

    }

    @Test
    public void testUserMarriageService() {
        userDataFormPage.fillApplicantDetails(lastName, firstName, middleName, phoneNumber, passportNumber, address);
        userDataFormPage.selectMarriageService();
        userDataFormPage.fillCitizenDate(citizenLastName, citizenFirstName, citizenMiddleName,
                citizenDoB, citizenPassportNumber, citizenSex);
        userDataFormPage.fillMarriageServiceForm(registrationDate, spouseLastName, newLastName,
                spouseFirstName, spouseMiddleName, spouseDateOfBirth, spousePassportNumber);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains("Ваша заявка отправлена на рассмотрение."), "Форма не отправлена");

    }

    @Test
    public void testUserDeathService() {
        userDataFormPage.fillApplicantDetails(lastName, firstName, middleName, phoneNumber, passportNumber, address);
        userDataFormPage.selectDeathService();
        userDataFormPage.fillCitizenDate(citizenLastName, citizenFirstName, citizenMiddleName,
                citizenDoB, citizenPassportNumber, citizenSex);
        userDataFormPage.fillDeathServiceForm(deathDate, placeOfDeath);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains("Ваша заявка отправлена на рассмотрение."), "Форма не отправлена");

    }

    @Test
    public void testUserBirthService() {
        userDataFormPage.fillApplicantDetails(lastName, firstName, middleName, phoneNumber, passportNumber, address);
        userDataFormPage.selectBirthdayService();
        userDataFormPage.fillCitizenDate(citizenLastName, citizenFirstName, citizenMiddleName,
                citizenDoB, citizenPassportNumber, citizenSex);
        userDataFormPage.fillBirthdayServiceForm(placeOfBirth, motherName, fatherName);

        String resultText = userDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultText.contains("Ваша заявка отправлена на рассмотрение."), "Форма не отправлена");

    }
}
