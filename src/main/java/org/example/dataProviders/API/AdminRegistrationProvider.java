package org.example.dataProviders.API;

import io.qameta.allure.Step;
import org.example.models.API.AdminRegistrationRequest;

public class AdminRegistrationProvider {

    @Step("Заполнение данных для регистрации Admin")
    public static AdminRegistrationRequest getTestAdminData() {
        return new AdminRegistrationRequest("10-10-2000", "Evgeniy",
                "Stroggo", "Sergeev",
                "AB1234567", "3752212312344");
    }
}
