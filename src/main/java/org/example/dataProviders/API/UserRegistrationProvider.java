package org.example.dataProviders.API;

import io.qameta.allure.Step;
import org.example.models.API.UserRegistrationRequest;


public class UserRegistrationProvider {
    @Step ("Заполнение данных для регистрации User")
    public static UserRegistrationRequest getTestUserDataToBirthService() {
        return new UserRegistrationRequest("birth", "Jhon", "Sergov",
                "Kerry", "3752212312344",
                "MP1234567", "Kerry",
                "Jhon", "Goslingov",
                "12-12-1980", "MP1234567",
                "Male", null,
                null, null,
                null, null,
                null, null,
                "Mexico", "Oksi",
                "Oleg", null,
                null);
    }

    @Step ("Заполнение данных для регистрации User")
    public static UserRegistrationRequest getTestUserDataToDeathService() {
        return new UserRegistrationRequest("death", "Jhon", "Sergov",
                "Kerry", "3752212312344",
                "MP1234567", "Kerry",
                "Jhon", "Goslingov",
                "12-12-1980", "MP1234567",
                "Male", null,
                null, null,
                null, null,
                null, null,
                null, null,
                null, "12-12-1999",
                "Moskow");
    }

    @Step ("Заполнение данных для регистрации User")
    public static UserRegistrationRequest getTestUserDataToMarriageService() {
        return new UserRegistrationRequest("wedding", "Jhon", "Sergov",
                "Kerry", "3752212312344",
                "MP1234567", "Kerry",
                "Jhon", "Goslingov",
                "12-12-1980", "MP1234567",
                "Male", "09-12-2024",
                "Kerry", "Klark",
                "Anna", "Antova",
                "12-12-1989", "AB1122331",
                null, null,
                null, null,
                null);
    }
}
