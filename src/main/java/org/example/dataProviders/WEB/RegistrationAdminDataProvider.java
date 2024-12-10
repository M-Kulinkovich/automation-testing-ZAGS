package org.example.dataProviders.WEB;

import org.example.models.WEB.AdminRegistrationDataVO;

public class RegistrationAdminDataProvider {

    public static AdminRegistrationDataVO getAdminRegistrationData() {
        return new AdminRegistrationDataVO(
                "Jhony",
                "Marts",
                "Keynov",
                "375333334455",
                "MP1234567",
                "15-12-2000"
        );
    }
}
