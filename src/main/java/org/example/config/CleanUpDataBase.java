package org.example.config;

import io.qameta.allure.Step;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CleanUpDataBase {
    static Connection connection = DataBaseConnection.getDbConnection();

    @Step ("Удаление тестовых записей администратора из БД")
    public static void deleteAdminDBTestData(int staffId) throws SQLException {
        String deleteQuery = """
                DELETE FROM staff WHERE staffid = ?
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, staffId);
        preparedStatement.executeUpdate();
    }
}
