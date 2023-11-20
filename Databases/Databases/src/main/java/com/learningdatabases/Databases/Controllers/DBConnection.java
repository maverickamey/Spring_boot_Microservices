package com.learningdatabases.Databases.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // jdbc(protocolname): mysql (type of DB)://host port
    private static String connectionurl = "jdbc:mysql://localhost:3306/employee_db";

    // Driver Manager creates a socket to DB connection to connect
    public static Connection getDBConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(connectionurl,  "root",  "root");
        System.out.println("Reaching DB");
        return connection;

    }
}
