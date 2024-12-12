package org.example.utils.UserDBUtils;

import io.qameta.allure.Step;
import org.example.config.DataBaseConnection;
import org.example.models.API.UserRegistrationRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBUtils extends BaseDBSelect {

    static Connection connection = DataBaseConnection.getDbConnection();

    @Step ("Проверка на создание в БД заявкии о регистрации брака")
    public static UserRegistrationRequest checkCreatingUserWithMarriageServiceInDB(int merrigecertificateid) throws Exception {
        Connection connection = DataBaseConnection.getDbConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(queryToMarriageService);
        preparedStatement.setInt(1, merrigecertificateid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            UserRegistrationRequest userReq = BaseDBSelect.fetchBaseUserData(resultSet);
            userReq.setAnotherPersonLastName(resultSet.getString("surnameofspouse"));
            userReq.setAnotherPersonFirstName(resultSet.getString("nameofspouse"));
            userReq.setAnotherPersonMiddleName(resultSet.getString("middlenameofspouse"));
            userReq.setNewLastName(resultSet.getString("newsurnameofspouse"));
            userReq.setAnotherPersonPassport(resultSet.getString("passportnumberofspouse"));
            return userReq;
        } else {
            throw new SQLException("Data of marriage service not found");
        }
    }

    @Step ("Проверка на создание в БД заявкии о регистрации рождения")
    public static UserRegistrationRequest checkCreatingUserWithBirthServiceInDB(int birthcertificateid) throws Exception {

        PreparedStatement preparedStatement = connection.prepareStatement(queryToBirthService);
        preparedStatement.setInt(1, birthcertificateid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            UserRegistrationRequest userReq = BaseDBSelect.fetchBaseUserData(resultSet);
            userReq.setBirth_place(resultSet.getString("placeofbirth"));
            userReq.setBirth_mother(resultSet.getString("mother"));
            userReq.setBirth_father(resultSet.getString("father"));

            return userReq;
        } else {
            throw new SQLException("Data of birth service not found");
        }
    }

    @Step ("Проверка на создание в БД заявкии о регистрации смерти")
    public static UserRegistrationRequest checkCreatingUserWithDeathServiceInDB(int deathcertificateid) throws Exception {

        PreparedStatement preparedStatement = connection.prepareStatement(queryToDeathService);
        preparedStatement.setInt(1, deathcertificateid);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            UserRegistrationRequest userReq = BaseDBSelect.fetchBaseUserData(resultSet);
            userReq.setDeath_dateOfDeath(resultSet.getString("dateofdeath"));
            userReq.setDeath_placeOfDeath(resultSet.getString("placeofdeath"));

            return userReq;
        } else {
            throw new SQLException("Data of death service not found");
        }
    }

}