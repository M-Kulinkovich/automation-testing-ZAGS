package org.example.models.WEB;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminRegistrationDataVO {
    private String adminLastName;
    private String adminFirstName;
    private String adminMiddleName;
    private String adminPhoneNumber;
    private String adminPassportNumber;
    private String adminDoB;
}
