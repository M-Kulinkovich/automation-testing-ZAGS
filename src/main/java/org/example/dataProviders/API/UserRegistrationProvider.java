package org.example.dataProviders.API;

import io.qameta.allure.Step;
import org.example.models.API.UserRegistrationRequest;


public class UserRegistrationProvider {
    @Step ("Заполнение данных для регистрации User")
    public static UserRegistrationRequest getTestUserData() {
        return new UserRegistrationRequest("web", "Jhon",
                "Kerry", "3752212312344",
                "MP1234567", "Kerry",
                "Jhon", "Goslingov",
                "12-12-1980", "MP1234567",
                "Male", "09-12-2024",
                "Kerry", "Klark",
                "Anna", "Antova",
                "12-12-1989", "AB1122331",
                "Mexico", "Oksi",
                "Oleg", "12-12-1999",
                "Krakow");
    }
}
