import org.example.pages.AdminDataFormPage;
import org.example.pages.RoleSelectPage;
import org.example.utils.RegistrationDataVO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void testAdminFormSending() {
        RegistrationDataVO registrationData = new RegistrationDataVO(
                "Jhony", "Marts", "Keynov",
                "375333334455", "MP1234567", "15-12-2000"
        );
        adminDataFormPage.fillRegistrationAdminForm(registrationData);

        String resultOfSendingText = adminDataFormPage.resultOfSendingRequest();
        Assert.assertTrue(resultOfSendingText.contains("Aдминистратор"), "Форма не отправлена");

    }

}
