import org.example.pages.AdminDataFormPage;
import org.example.pages.AdminTablePage;
import org.example.pages.RoleSelectPage;
import org.example.utils.RegistrationDataVO;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        RegistrationDataVO registrationData = new RegistrationDataVO(
                "Jhony", "Marts", "Keynov",
                "375333334455", "MP1234567", "15-12-2000 "
        );
        adminDataFormPage.fillRegistrationAdminForm(registrationData);
    }


    @Test
    void testAdminTableChangeStatusToApprove() {
        int rowIndex = 3;
        String currentStatus = adminTablePage.getStatus(3);

        adminTablePage.clickApproveButton(rowIndex);
        String newStatus = adminTablePage.getStatus(3);
        Assert.assertEquals(newStatus, "Одобрена", "Статус должен быть 'Одобрена'.");
    }
    @Test
    void testAdminTableChangeStatusToReject() {
        int rowIndex = 1;
        String currentStatus = adminTablePage.getStatus(1);

        adminTablePage.clickRejectButton(rowIndex);
        String newStatus = adminTablePage.getStatus(1);
        Assert.assertEquals(newStatus, "Отклонена", "Статус должен быть 'Одобрена'.");
    }
}
