package org.example.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


public class UserRegistrationDataVO {

    @AllArgsConstructor
    @Getter
    public static class ApplicantData {
        private String lastName;
        private String firstName;
        private String middleName;
        private String phoneNumber;
        private String passportNumber;
        private String address;
    }

    @AllArgsConstructor
    @Getter
    public static class CitizenData {
        private String citizenLastName;
        private String citizenFirstName;
        private String citizenMiddleName;
        private String citizenDoB;
        private String citizenPassportNumber;
        private String citizenSex;
    }

    @AllArgsConstructor
    @Getter
    public static class ServiceData {
        private String registrationDate;
        private String spouseLastName;
        private String newLastName;
        private String spouseFirstName;
        private String spouseMiddleName;
        private String spouseDateOfBirth;
        private String spousePassportNumber;

        private String placeOfDeath;
        private String deathDate;

        private String placeOfBirth;
        private String motherName;
        private String fatherName;

        public ServiceData(String registrationDate,
                           String spouseLastName,
                           String newLastName,
                           String spouseFirstName,
                           String spouseMiddleName,
                           String spouseDateOfBirth,
                           String spousePassportNumber) {
            this.registrationDate = registrationDate;
            this.spouseLastName = spouseLastName;
            this.newLastName = newLastName;
            this.spouseFirstName = spouseFirstName;
            this.spouseMiddleName = spouseMiddleName;
            this.spouseDateOfBirth = spouseDateOfBirth;
            this.spousePassportNumber = spousePassportNumber;
        }

        public ServiceData(String placeOfDeath,
                           String deathDate) {
            this.placeOfDeath = placeOfDeath;
            this.deathDate = deathDate;
        }

        public ServiceData(String placeOfBirth,
                           String motherName, String fatherName) {
            this.placeOfBirth = placeOfBirth;
            this.motherName = motherName;
            this.fatherName = fatherName;
        }
    }

}
