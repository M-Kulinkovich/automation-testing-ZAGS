package API;

import io.qameta.allure.Description;
import io.restassured.response.ValidatableResponse;
import org.example.models.API.ApplicationStatusResult;
import org.example.models.API.ApplicationsData;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;

public class ApplicationApiTest extends BaseTest {
    private ApplicationStatusResult applicationStatusResults;

    @Test
    @Description ("Получение заявки по номеру")
    public void testGetApplicationById() {
        APIlogger.info("Sending GET request to get application by ID");

        int applicationId = 37814;

        ValidatableResponse response = given()
                .when()
                .get("getApplStatus/{applicationId}", applicationId)
                .then().log().all();
        applicationStatusResults = response.extract().jsonPath().getObject("data", ApplicationStatusResult.class);

        String ApiResponse = response.extract().asPrettyString();
        APIlogger.info("Response: " + ApiResponse);

        Assert.assertNotNull(applicationStatusResults.getApplicantid());
        Assert.assertNotNull(applicationStatusResults.getStatusofapplication());
    }

    @Test
    @Description ("Получение всех заявок")
    public void testGetAllApplication() {
        APIlogger.info("Sending GET request to get All applications");

        List<ApplicationsData> applicationsData = given()
                .when()
                .get("getApplications")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ApplicationsData.class);

        Assert.assertNotNull(applicationsData);
        APIlogger.info("Applications received: " + applicationsData.size());
    }
}
