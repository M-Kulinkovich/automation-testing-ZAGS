package API;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.example.dataProviders.API.AdminRegistrationProvider;
import org.example.dataProviders.API.RequestChangeStatusProvider;
import org.example.models.API.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.given;
import static org.example.utils.AdminDBUtils.checkCreatingAdminInDB;

public class AdminApiTest extends BaseTest {
    private AdminSuccessRegistration adminSuccessRegistration;
    private SuccessChangeStatus successChangeStatus;


    @Test
    @Description ("Отправка валидных данных для регистрации Admin")
    public void testRegisterAdmin() throws Exception {
        APIlogger.info("Sending POST request to registration Admin");

        AdminRegistrationRequest testAdmin = AdminRegistrationProvider.getTestAdminData();
        ValidatableResponse response = given()
                .body(testAdmin)
                .when()
                .post("sendAdminRequest")
                .then().log().all();
        adminSuccessRegistration = response.extract().jsonPath().getObject("data", AdminSuccessRegistration.class);

        String ApiResponse = response.extract().asPrettyString();
        APIlogger.info("Response: " + ApiResponse);

        Assert.assertNotNull(adminSuccessRegistration.getStaffid());

        //check creation admin in DB
        AdminRegistrationRequest actualAdmin = checkCreatingAdminInDB(adminSuccessRegistration.getStaffid());
        APIlogger.info("comparison data sent to API and database");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAdmin.getPersonalFirstName(), testAdmin.getPersonalFirstName()
                , "First name mismatch");
        softAssert.assertEquals(actualAdmin.getPersonalLastName(), testAdmin.getPersonalLastName(),
                "Last name mismatch");
        softAssert.assertEquals(actualAdmin.getPersonalMiddleName(), testAdmin.getPersonalMiddleName(),
                "Middle name mismatch");
        softAssert.assertEquals(actualAdmin.getPersonalNumberOfPassport(), testAdmin.getPersonalNumberOfPassport(),
                "Passport number mismatch");
        softAssert.assertEquals(actualAdmin.getPersonalPhoneNumber(), testAdmin.getPersonalPhoneNumber(),
                "Phone number mismatch");
        softAssert.assertAll();

    }

    @Test
    @Description ("Отправка данных для изменения статуса заявки")
    public void testRequestToChangeStatus() {
        APIlogger.info("Sending POST request to change applications status");

        ChangeStatusRequest statusRequest = RequestChangeStatusProvider.changeStatus();
        ValidatableResponse response = given()
                .body(statusRequest)
                .when()
                .post("requestProcess")
                .then().log().all();
        successChangeStatus = response.extract().jsonPath().getObject("data", SuccessChangeStatus.class);

        String ApiResponse = response.extract().asPrettyString();
        APIlogger.info("Response: " + ApiResponse);

        Assert.assertNotNull(successChangeStatus.getApplicationid());
        Assert.assertNotNull(successChangeStatus.getStaffid());

        Assert.assertEquals(statusRequest.getApplId(), successChangeStatus.getApplicationid());
        Assert.assertEquals(statusRequest.getStaffid(), successChangeStatus.getStaffid());
    }
}
