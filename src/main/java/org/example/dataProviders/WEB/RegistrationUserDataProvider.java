package org.example.dataProviders.WEB;

import org.example.models.WEB.UserRegistrationDataVO;

public class RegistrationUserDataProvider {
    public static UserRegistrationDataVO.ApplicantData getApplicantData() {
        return new UserRegistrationDataVO.ApplicantData("Doe", "John",
                "Michael", "1234567890",
                "AB1234567", "Street 4");
    }

    public static UserRegistrationDataVO.CitizenData getCitizenData() {
        return new UserRegistrationDataVO.CitizenData("Ivanov", "Ivan",
                "Ivanovich", "1990-01-01",
                "AB3456789", "Male");
    }

    public static UserRegistrationDataVO.ServiceData getMarriageServiceData() {
        return new UserRegistrationDataVO.ServiceData("2024-11-25", "Petrova",
                "Ivanova", "Anna",
                "Petrovna", "1992-08-05",
                "AB1234567");
    }

    public static UserRegistrationDataVO.ServiceData getBirthdayServiceData() {
        return new UserRegistrationDataVO.ServiceData("Warshaw", "Barbara", "Oleg");
    }

    public static UserRegistrationDataVO.ServiceData getDeathServiceData() {
        return new UserRegistrationDataVO.ServiceData("Moskow", "2024-11-15");
    }
}
