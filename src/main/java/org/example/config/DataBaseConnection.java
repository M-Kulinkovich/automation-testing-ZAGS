package org.example.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.AdminDataFormPage;

import java.sql.*;

public class DataBaseConnection {
    private static final Logger logger = LogManager.getLogger(AdminDataFormPage.class);
    private static Connection dbConnection;

    public static Connection getDbConnection() {
        try {
            String connectionString = "jdbc:postgresql://" + ConfProperties.getProperty("dbHost") +
                    ":" + ConfProperties.getProperty("dbPort") +
                    "/" + ConfProperties.getProperty("dbName") +
                    "?currentSchema=" + ConfProperties.getProperty("dbSchema");
            Class.forName("org.postgresql.Driver");

            dbConnection = DriverManager.getConnection(connectionString,
                    ConfProperties.getProperty("dbUser"),
                    ConfProperties.getProperty("dbPass"));

            logger.info("Successfully connected to the database");
        } catch (SQLException | ClassNotFoundException e) {
            logger.error("Failed to connect to the database", e);

            throw new RuntimeException("Failed to connect to the database", e);
        }

        return dbConnection;
    }
}