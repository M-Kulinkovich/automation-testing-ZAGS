package org.example.models.API;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {

    private String mode;
    private String personalLastName;
    private String personalMiddleName;
    private String personalPhoneNumber;
    private String personalNumberOfPassport;
    private String citizenLastName;
    private String citizenFirstName;
    private String citizenMiddleName;
    private String citizenBirthDate;
    private String citizenNumberOfPassport;
    private String citizenGender;
    private String dateOfMarriage;
    private String newLastName;
    private String anotherPersonLastName;
    private String anotherPersonFirstName;
    private String anotherPersonMiddleName;
    private String birth_of_anotoherPerson;
    private String anotherPersonPassport;
    private String birth_place;
    private String birth_mother;
    private String birth_father;
    private String death_dateOfDeath;
    private String death_placeOfDeath;
}

