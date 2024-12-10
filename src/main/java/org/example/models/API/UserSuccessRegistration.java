package org.example.models.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSuccessRegistration {
    private Integer applicantid;
    private Integer applicationid;
    private Integer citizenid;
    private Integer merrigecertificateid;
}
