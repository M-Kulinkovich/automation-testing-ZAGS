package API;

import io.qameta.allure.Description;
import org.example.models.API.ApplicationStatusResult;
import org.example.models.API.ApplicationsData;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ApplicationApiTest extends BaseTest {

    @Test
    @Description ("Получение заявки по номеру")
    public void testGetApplicationById() {
        int applicationId = 37814;

        ApplicationStatusResult applicationStatusResults = given()
                .when()
                .get("getApplStatus/{applicationId}", applicationId)
                .then().log().all()
                .extract().jsonPath().getObject("data", ApplicationStatusResult.class);

        Assert.assertNotNull(applicationStatusResults.getApplicantid());
        Assert.assertNotNull(applicationStatusResults.getStatusofapplication());
    }

    @Test
    @Description ("Получение всех заявок")
    public void testGetAllApplication() {
        List<ApplicationsData> applicationsData = given()
                .when()
                .get("getApplications")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ApplicationsData.class);

        Assert.assertNotNull(applicationsData);
        System.out.println("Получено " + applicationsData.size() + " заявок");
    }
}
