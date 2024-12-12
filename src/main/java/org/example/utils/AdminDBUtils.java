package org.example.utils;

import io.qameta.allure.Step;
import org.example.config.DataBaseConnection;
import org.example.models.API.AdminRegistrationRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDBUtils {

    @Step ("Проверка на создание админа в БД")
    public static AdminRegistrationRequest checkCreatingAdminInDB(int staffId) throws Exception {
        Connection connection = DataBaseConnection.getDbConnection();

        String query = "SELECT dateofbirth, name, surname, middlename, passportnumber, phonenumber FROM staff WHERE staffid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, staffId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            AdminRegistrationRequest adminReq = new AdminRegistrationRequest();
            adminReq.setPersonalFirstName(resultSet.getString("name"));
            adminReq.setPersonalLastName(resultSet.getString("surname"));
            adminReq.setPersonalMiddleName(resultSet.getString("middlename"));
            adminReq.setPersonalNumberOfPassport(resultSet.getString("passportnumber"));
            adminReq.setPersonalPhoneNumber(resultSet.getString("phonenumber"));
            return adminReq;
        } else {
            throw new SQLException("No admin found with staffId: " + staffId);
        }
    }
}
