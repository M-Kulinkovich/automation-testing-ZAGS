package org.example.models.API;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRegistrationRequest {
    private String dateofbirth;
    private String personalFirstName;
    private String personalLastName;
    private String personalMiddleName;
    private String personalNumberOfPassport;
    private String personalPhoneNumber;
}
