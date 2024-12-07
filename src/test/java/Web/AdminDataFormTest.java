package Web;

import io.qameta.allure.Description;
import org.example.data.RegistrationAdminDataProvider;
import org.example.pages.AdminDataFormPage;
import org.example.pages.RoleSelectPage;
import org.example.utils.AdminRegistrationDataVO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.utils.Constants.FORM_NOT_SUBMITTED_MESSAGE;

public class AdminDataFormTest extends BaseTest {
    private RoleSelectPage roleSelectPage;
    private AdminDataFormPage adminDataFormPage;

    @BeforeMethod
    public void setupTest() {
        roleSelectPage = new RoleSelectPage(driver);
        adminDataFormPage = new AdminDataFormPage(driver);
        roleSelectPage.clickAdminButton();

    }

    @Test
    @Description ("Заполнение формы регистрации для админа")
    public void testAdminFormSending() {
        Weblogger.info("Starting test: testAdminFormSending");
        try {
            AdminRegistrationDataVO registrationData = RegistrationAdminDataProvider.getAdminRegistrationData();
            adminDataFormPage.fillRegistrationAdminForm(registrationData);

            String resultOfSendingText = adminDataFormPage.resultOfSendingRequest();
            Assert.assertTrue(resultOfSendingText.contains("Aдминистратор"), FORM_NOT_SUBMITTED_MESSAGE);
        } catch (Exception e) {
            Weblogger.error("testAdminFormSending failed: " + e.getMessage());
            throw e;

        } finally {
            Weblogger.info("testAdminFormSending completed");
        }
    }

}
