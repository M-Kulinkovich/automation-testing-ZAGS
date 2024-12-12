package org.example.utils.UserDBUtils;

import org.example.models.API.UserRegistrationRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDBSelect {

    static String queryToMarriageService = "select a.surname, a.name, a.middlename, a.passportnumber, a.phonenumber," +
            " c.surname AS c_surname, c.name AS c_name, c.middlename as c_middlename," +
            " c.passportnumber as c_passportnumber, c.dateofbirth, c.gender," +
            " m.dateofmerrige, m.surnameofspouse, m.newsurnameofspouse," +
            " m.nameofspouse, m.middlenameofspouse, m.passportnumberofspouse, m.dateofbirthofspouse" +
            " FROM merrigecertificates m join citizens c on m.citizenid=c.citizenid" +
            " join applications a2 on a2.citizenid=c.citizenid" +
            " join applicants a on a.applicantid=a2.applicantid" +
            " WHERE merrigecertificateid = ?;";
    static String queryToDeathService = "select a.surname, a.name, a.middlename, a.passportnumber, a.phonenumber," +
            " c.surname AS c_surname, c.name AS c_name, c.middlename as c_middlename," +
            " c.passportnumber as c_passportnumber, c.dateofbirth, c.gender," +
            " d.dateofdeath, d.placeofdeath" +
            " FROM deathcertificates d join citizens c on d.citizenid=c.citizenid" +
            " join applications a2 on a2.citizenid=c.citizenid" +
            " join applicants a on a.applicantid=a2.applicantid" +
            " WHERE deathcertificateid = ?;";

    static String queryToBirthService = "select a.surname, a.name, a.middlename, a.passportnumber, a.phonenumber," +
            " c.surname AS c_surname, c.name AS c_name, c.middlename as c_middlename," +
            " c.passportnumber as c_passportnumber, c.dateofbirth, c.gender," +
            " b.placeofbirth, b.mother, b.father" +
            " FROM birthcertificates b join citizens c on b.citizenid=c.citizenid" +
            " join applications a2 on a2.citizenid=c.citizenid" +
            " join applicants a on a.applicantid=a2.applicantid" +
            " WHERE birthcertificateid = ?;";

    public static UserRegistrationRequest fetchBaseUserData(ResultSet resultSet) throws SQLException {

        UserRegistrationRequest userReq = new UserRegistrationRequest();
        userReq.setPersonalFirstName(resultSet.getString("name"));
        userReq.setPersonalLastName(resultSet.getString("surname"));
        userReq.setPersonalMiddleName(resultSet.getString("middlename"));
        userReq.setPersonalNumberOfPassport(resultSet.getString("passportnumber"));
        userReq.setPersonalPhoneNumber(resultSet.getString("phonenumber"));
        userReq.setCitizenGender(resultSet.getString("gender"));
        userReq.setCitizenLastName(resultSet.getString("c_surname"));
        userReq.setCitizenFirstName(resultSet.getString("c_name"));
        userReq.setCitizenMiddleName(resultSet.getString("c_middlename"));
        userReq.setCitizenNumberOfPassport(resultSet.getString("c_passportnumber"));
        return userReq;
    }


}
