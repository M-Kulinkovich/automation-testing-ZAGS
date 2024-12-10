package API;

import io.qameta.allure.Description;
import org.example.dataProviders.API.UserRegistrationProvider;
import org.example.models.API.UserRegistrationRequest;
import org.example.models.API.UserSuccessRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseTest {

    @Test
    @Description ("Отправка валидных данных для регистрации User")
    public void testRegisterUser() {
        UserRegistrationRequest testUser = UserRegistrationProvider.getTestUserData();
        UserSuccessRegistration userSuccessRegistration = given()
                .body(testUser)
                .when()
                .post("sendUserRequest")
                .then().log().all()
                .extract().as(UserSuccessRegistration.class);

        Assert.assertNotNull(userSuccessRegistration.getApplicantid());
    }
}
