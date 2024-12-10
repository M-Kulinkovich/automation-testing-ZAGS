package API;

import io.qameta.allure.Description;
import org.example.dataProviders.API.AdminRegistrationProvider;
import org.example.dataProviders.API.RequestChangeStatusProvider;
import org.example.models.API.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AdminApiTest extends BaseTest {

    @Test
    @Description ("Отправка валидных данных для регистрации Admin")
    public void testRegisterAdmin() {
        AdminRegistrationRequest testAdmin = AdminRegistrationProvider.getTestAdminData();
        AdminSuccessRegistration adminSuccessRegistration = given()
                .body(testAdmin)
                .when()
                .post("sendAdminRequest")
                .then().log().all()
                .extract().jsonPath().getObject("data", AdminSuccessRegistration.class);

        Assert.assertNotNull(adminSuccessRegistration.getStaffid());
    }

    @Test
    @Description ("Отправка данных для изменения статуса заявки")
    public void testRequestToChangeStatus() {
        ChangeStatusRequest statusRequest = RequestChangeStatusProvider.changeStatus();
        SuccessChangeStatus successChangeStatus = given()
                .body(statusRequest)
                .when()
                .post("requestProcess")
                .then().log().all()
                .extract().jsonPath().getObject("data", SuccessChangeStatus.class);

        Assert.assertNotNull(successChangeStatus.getApplicationid());
        Assert.assertNotNull(successChangeStatus.getStaffid());

        Assert.assertEquals(statusRequest.getApplId(), successChangeStatus.getApplicationid());
        Assert.assertEquals(statusRequest.getStaffid(), successChangeStatus.getStaffid());
    }
}
