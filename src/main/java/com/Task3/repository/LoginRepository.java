package com.Task3.repository;

import com.Task3.models.Login;
import com.Task3.models.Posting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginRepository {
    public LoginRepository () {
    }
    public static void New(Login log) throws SQLException {
        String query = "insert into logins (Application, AppAccountName, IsActive, JobTitle, Department) values (" +
                "\"" + log.Application + "\", " +
                "\"" + log.AppAccountName + "\", " +
                + log.IsActive + ", " +
                "\"" + log.JobTitle + "\", " +
                "\"" +log.Department + "\");";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/TASK3", "root", "11111111")) {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("connectoin failed\n" + e.toString());
            System.out.println(query);
        }
    }
}
