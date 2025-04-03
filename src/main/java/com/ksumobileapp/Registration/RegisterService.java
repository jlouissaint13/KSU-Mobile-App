package com.ksumobileapp.Registration;


import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RegisterService {

public void databaseConnection() throws SQLException {
    Connection connection = null;
    String url = "jdbc:sqlite:accounts.db";
    connection = DriverManager.getConnection(url); {
        System.out.println("Connection was successful");

    }

}
public void registerUser(RegisterModel registerModel) {
   registerModel.getName();
}
}
