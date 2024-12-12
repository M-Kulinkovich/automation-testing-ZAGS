package API;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.example.dataProviders.API.UserRegistrationProvider;
import org.example.models.API.UserRegistrationRequest;
import org.example.models.API.UserSuccessRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.example.utils.UserDBUtils.UserDBUtils.*;

public class UserApiTest extends BaseTest {
    private UserSuccessRegistration userSuccessRegistration;

    private UserSuccessRegistration sendPostRequest(UserRegistrationRequest testUser, String serviceDescription) {
        APIlogger.info("Sending POST request to register user for " + serviceDescription);

        ValidatableResponse response = given()
                .body(testUser)
                .when()
                .post("sendUserRequest")
                .then().log().all();

        String apiResponse = response.extract().asPrettyString();
        APIlogger.info("Response: " + apiResponse);

        UserSuccessRegistration userRegistration = response.extract().jsonPath().getObject("data", UserSuccessRegistration.class);

        Assert.assertNotNull(userRegistration.getApplicantid(), "Applicant is null!");

        return userRegistration;
    }

    @Test
    @Description ("Отправка валидных данных пользователя для регистрации рождения")
    public void testRegisterUserWithBirthService() throws Exception {
        UserRegistrationRequest testUser = UserRegistrationProvider.getTestUserDataToBirthService();
        UserSuccessRegistration userSuccessRegistration = sendPostRequest(testUser, "BirthCertificate");

        Assert.assertNotNull(userSuccessRegistration.getBirthcertificateid(), "Birth Certificate is null!");

        //      check creation User birthday service in DB
        UserRegistrationRequest actualUser = checkCreatingUserWithBirthServiceInDB(userSuccessRegistration.getBirthcertificateid());
        APIlogger.info("comparison data sent birthday certificate to API and database");

        Assert.assertEquals(actualUser.getPersonalFirstName(), testUser.getPersonalFirstName(),
                "First name mismatch");
        Assert.assertEquals(actualUser.getPersonalLastName(), testUser.getPersonalLastName(),
                "Last name mismatch");
        Assert.assertEquals(actualUser.getPersonalMiddleName(), testUser.getPersonalMiddleName(),
                "Middle name mismatch");
        Assert.assertEquals(actualUser.getPersonalNumberOfPassport(), testUser.getPersonalNumberOfPassport(),
                "Passport number mismatch");
        Assert.assertEquals(actualUser.getPersonalPhoneNumber(), testUser.getPersonalPhoneNumber(),
                "Phone number mismatch");
        Assert.assertEquals(actualUser.getCitizenGender(), testUser.getCitizenGender(),
                "Citizen gender mismatch");
        Assert.assertEquals(actualUser.getCitizenNumberOfPassport(), testUser.getCitizenNumberOfPassport(),
                "Citizen passport number mismatch");
        Assert.assertEquals(actualUser.getCitizenFirstName(), testUser.getCitizenFirstName(),
                "Citizen first name mismatch");
        Assert.assertEquals(actualUser.getCitizenLastName(), testUser.getCitizenLastName(),
                "Citizen last name mismatch");
        Assert.assertEquals(actualUser.getCitizenMiddleName(), testUser.getCitizenMiddleName(),
                "Citizen middle name mismatch");

        Assert.assertEquals(actualUser.getBirth_father(), testUser.getBirth_father(),
                "Mother name mismatch");
        Assert.assertEquals(actualUser.getBirth_mother(), testUser.getBirth_mother(),
                "Father name mismatch");
        Assert.assertEquals(actualUser.getBirth_place(), testUser.getBirth_place(),
                "Place of birth mismatch");


    }

    @Test
    @Description ("Отправка валидных данных пользователя для регистрации смерти")
    public void testRegisterUserWithDeathService() throws Exception {
        UserRegistrationRequest testUser = UserRegistrationProvider.getTestUserDataToDeathService();
        UserSuccessRegistration userSuccessRegistration = sendPostRequest(testUser, "DeathCertificate");

        Assert.assertNotNull(userSuccessRegistration.getDeathcertificateid(), "Death Certificate is null!");

        //      check creation User death service in DB
        UserRegistrationRequest actualUser = checkCreatingUserWithDeathServiceInDB(userSuccessRegistration.getDeathcertificateid());
        APIlogger.info("comparison data sent death certificate to API and database");

        Assert.assertEquals(actualUser.getPersonalFirstName(), testUser.getPersonalFirstName(),
                "First name mismatch");
        Assert.assertEquals(actualUser.getPersonalLastName(), testUser.getPersonalLastName(),
                "Last name mismatch");
        Assert.assertEquals(actualUser.getPersonalMiddleName(), testUser.getPersonalMiddleName(),
                "Middle name mismatch");
        Assert.assertEquals(actualUser.getPersonalNumberOfPassport(), testUser.getPersonalNumberOfPassport(),
                "Passport number mismatch");
        Assert.assertEquals(actualUser.getPersonalPhoneNumber(), testUser.getPersonalPhoneNumber(),
                "Phone number mismatch");
        Assert.assertEquals(actualUser.getCitizenGender(), testUser.getCitizenGender(),
                "Citizen gender mismatch");
        Assert.assertEquals(actualUser.getCitizenNumberOfPassport(), testUser.getCitizenNumberOfPassport(),
                "Citizen passport number mismatch");
        Assert.assertEquals(actualUser.getCitizenFirstName(), testUser.getCitizenFirstName(),
                "Citizen first name mismatch");
        Assert.assertEquals(actualUser.getCitizenLastName(), testUser.getCitizenLastName(),
                "Citizen last name mismatch");
        Assert.assertEquals(actualUser.getCitizenMiddleName(), testUser.getCitizenMiddleName(),
                "Citizen middle name mismatch");

        Assert.assertEquals(actualUser.getDeath_dateOfDeath(), testUser.getDeath_dateOfDeath(),
                "Death date mismatch");
        Assert.assertEquals(actualUser.getDeath_placeOfDeath(), testUser.getDeath_placeOfDeath(),
                "Death place mismatch");
    }

    @Test
    @Description ("Отправка валидных данных пользователя для регистрации брака")
    public void testRegisterUserWithMarriageService() throws Exception {
        UserRegistrationRequest testUser = UserRegistrationProvider.getTestUserDataToMarriageService();
        UserSuccessRegistration userSuccessRegistration = sendPostRequest(testUser, "MarriageCertificate");

        Assert.assertNotNull(userSuccessRegistration.getMerrigecertificateid(), "Marriage Certificate is null!");

//      check creation User marriage service in DB
        UserRegistrationRequest actualUser = checkCreatingUserWithMarriageServiceInDB(userSuccessRegistration.getMerrigecertificateid());
        APIlogger.info("comparison data sent marriage certificate to API and database");

        Assert.assertEquals(actualUser.getPersonalFirstName(), testUser.getPersonalFirstName(),
                "First name mismatch");
        Assert.assertEquals(actualUser.getPersonalLastName(), testUser.getPersonalLastName(),
                "Last name mismatch");
        Assert.assertEquals(actualUser.getPersonalMiddleName(), testUser.getPersonalMiddleName(),
                "Middle name mismatch");
        Assert.assertEquals(actualUser.getPersonalNumberOfPassport(), testUser.getPersonalNumberOfPassport(),
                "Passport number mismatch");
        Assert.assertEquals(actualUser.getPersonalPhoneNumber(), testUser.getPersonalPhoneNumber(),
                "Phone number mismatch");
        Assert.assertEquals(actualUser.getCitizenGender(), testUser.getCitizenGender(),
                "Citizen gender mismatch");
        Assert.assertEquals(actualUser.getCitizenNumberOfPassport(), testUser.getCitizenNumberOfPassport(),
                "Citizen passport number mismatch");
        Assert.assertEquals(actualUser.getCitizenFirstName(), testUser.getCitizenFirstName(),
                "Citizen first name  mismatch");
        Assert.assertEquals(actualUser.getCitizenLastName(), testUser.getCitizenLastName(),
                "Citizen last name  mismatch");
        Assert.assertEquals(actualUser.getCitizenMiddleName(), testUser.getCitizenMiddleName(),
                "Citizen middle name  mismatch");

        Assert.assertEquals(actualUser.getAnotherPersonLastName(), testUser.getAnotherPersonLastName(),
                "Last name of spouse mismatch");
        Assert.assertEquals(actualUser.getAnotherPersonFirstName(), testUser.getAnotherPersonFirstName(),
                "First name of spouse mismatch");
        Assert.assertEquals(actualUser.getAnotherPersonMiddleName(), testUser.getAnotherPersonMiddleName(),
                "Middle name of spouse mismatch");
        Assert.assertEquals(actualUser.getAnotherPersonPassport(), testUser.getAnotherPersonPassport(),
                "Passport of spouse mismatch");
        Assert.assertEquals(actualUser.getNewLastName(), testUser.getNewLastName(),
                "New last name mismatch");
    }
}



