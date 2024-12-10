package Web;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.example.dataProviders.WEB.RegistrationAdminDataProvider;
import org.example.pages.AdminDataFormPage;
import org.example.pages.RoleSelectPage;
import org.example.models.WEB.AdminRegistrationDataVO;
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

        AdminRegistrationDataVO registrationData = RegistrationAdminDataProvider.getAdminRegistrationData();
        adminDataFormPage.fillRegistrationAdminForm(registrationData);

        String resultOfSendingText = adminDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultOfSendingText.contains("Aдминистратор"), FORM_NOT_SUBMITTED_MESSAGE);

    }

}
