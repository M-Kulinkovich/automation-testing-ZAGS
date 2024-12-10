package org.example.dataProviders.API;

import io.qameta.allure.Step;
import org.example.models.API.ChangeStatusRequest;

public class RequestChangeStatusProvider {

    @Step ("Заполнение данных для изменения статуса")
    public static ChangeStatusRequest changeStatus() {
        return new ChangeStatusRequest(37814, 21156, "Reject");
    }
}
