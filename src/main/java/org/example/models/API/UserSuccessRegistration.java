package org.example.models.API;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSuccessRegistration {
    private Integer applicationid;
    private Integer applicantid;
    private Integer citizenid;
    private Integer birthcertificateid;
    private Integer merrigecertificateid;
    private Integer deathcertificateid;
}
