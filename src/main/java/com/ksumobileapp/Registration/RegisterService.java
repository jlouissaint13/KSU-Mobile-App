package com.ksumobileapp.Registration;


import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class RegisterService {

public void databaseConnection() throws SQLException {
    Connection connection = null;
    String url = "jdbc:sqlite:accounts.db";
    String sql = "Create Table if  not exists users (" +
            "firstName" +
            "lastName" +
            "email" +
            "phone" +
            "dob" +
            "classification" +
            "major);";

    connection = DriverManager.getConnection(url); {

    }


}
public void registerUser(RegisterModel registerModel) {
   System.out.println(registerModel.getFname());
}
}
