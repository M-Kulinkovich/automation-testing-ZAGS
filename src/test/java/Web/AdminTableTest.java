package Web;

import io.qameta.allure.Description;
import org.example.data.RegistrationAdminDataProvider;
import org.example.pages.AdminDataFormPage;
import org.example.pages.AdminTablePage;
import org.example.pages.RoleSelectPage;
import org.example.utils.AdminRegistrationDataVO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.utils.Constants.*;


public class AdminTableTest extends BaseTest {
    private AdminTablePage adminTablePage;
    private RoleSelectPage roleSelectPage;
    private AdminDataFormPage adminDataFormPage;

    @BeforeMethod
    public void setupTest() {
        roleSelectPage = new RoleSelectPage(driver);
        adminDataFormPage = new AdminDataFormPage(driver);
        adminTablePage = new AdminTablePage(driver);

        roleSelectPage.clickAdminButton();
        AdminRegistrationDataVO registrationData = RegistrationAdminDataProvider.getAdminRegistrationData();
        adminDataFormPage.fillRegistrationAdminForm(registrationData);
    }


    @Test
    @Description ("Проверка изменения статуса на 'Одобрена'")
    void testAdminTableChangeStatusToApprove() {
        Weblogger.info("Starting test: testAdminTableChangeStatusToApprove");

        try {
            int rowIndex = 3;
            String currentStatus = adminTablePage.getStatus(3);

            adminTablePage.clickApproveButton(rowIndex);
            String newStatus = adminTablePage.getStatus(3);
            Assert.assertEquals(newStatus, APPROVE_REQUEST_TEXT, APPROVE_STATUS_MESSAGE);
        } catch (Exception e) {
            Weblogger.error("testAdminTableChangeStatusToApprove failed: " + e.getMessage());
            throw e;

        } finally {
            Weblogger.info("testAdminTableChangeStatusToApprove completed");
        }
    }

    @Test
    @Description ("Проверка изменения статуса на 'Отклонена'")
    void testAdminTableChangeStatusToReject() {
        Weblogger.info("Starting test: testAdminTableChangeStatusToReject");

        try {
            int rowIndex = 1;
            String currentStatus = adminTablePage.getStatus(1);

            adminTablePage.clickRejectButton(rowIndex);
            String newStatus = adminTablePage.getStatus(1);
            Assert.assertEquals(newStatus, REJECT_REQUEST_TEXT, REJECT_STATUS_MESSAGE);
        } catch (Exception e) {
            Weblogger.error("testAdminTableChangeStatusToReject failed: " + e.getMessage());
            throw e;

        } finally {
            Weblogger.info("testAdminTableChangeStatusToReject completed");
        }
    }
}
