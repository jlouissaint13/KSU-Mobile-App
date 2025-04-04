package com.ksumobileapp.Registration;


import java.sql.*;
import java.sql.Connection;


public class RegisterService {

public void databaseConnection(RegisterModel registerModel) throws SQLException {

    String url = "jdbc:sqlite:accounts.db";
    String sql = "INSERT INTO users(firstName,lastName,email,phone,dob,classification,major) VALUES(?,?,?,?,?,?,?)";

    try (Connection connection = DriverManager.getConnection(url)) {

        PreparedStatement pstmt = connection.prepareStatement(sql);
        {
            pstmt.setString(1,registerModel.getFname());
            pstmt.setString(2,registerModel.getLname());
            pstmt.setString(3,registerModel.getEmail());
            pstmt.setString(4,registerModel.getPhone());
            pstmt.setString(5,registerModel.getDob());
            pstmt.setString(6,registerModel.getClassification());
            pstmt.setString(7,registerModel.getMajor());
            pstmt.executeUpdate();

        }


    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


public void registerUser(RegisterModel registerModel) {
   System.out.println(registerModel.getFname());
}
}
