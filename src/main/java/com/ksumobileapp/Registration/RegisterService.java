package com.ksumobileapp.Registration;


import java.sql.*;
import java.sql.Connection;


public class RegisterService {

public void databaseConnection(RegisterModel registerModel) throws SQLException {

    String url = "jdbc:sqlite:accounts.db";
    String sql = "INSERT INTO users(firstName,lastName,personalEmail,campusEmail,password,phone,dob,classification,major) VALUES(?,?,?,?,?,?,?,?,?)";

    try (Connection connection = DriverManager.getConnection(url)) {

        PreparedStatement pstmt = connection.prepareStatement(sql);
        {
            pstmt.setString(1,registerModel.getFname());
            pstmt.setString(2,registerModel.getLname());
            pstmt.setString(3,registerModel.getEmail());
            pstmt.setString(4,generateEmail(registerModel));
            pstmt.setString(5,registerModel.getPassword());
            pstmt.setString(6,registerModel.getPhone());
            pstmt.setString(7,registerModel.getDob());
            pstmt.setString(8,registerModel.getClassification());
            pstmt.setString(9,registerModel.getMajor());
            pstmt.executeUpdate();

        }


    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}


public void registerUser(RegisterModel registerModel) {
   System.out.println(registerModel.getFname());
}
public String generateEmail(RegisterModel registerModel) {



    StringBuilder sb = new StringBuilder();
    //get the first letter of the students first name
    sb.append(registerModel.getFname().charAt(0));

    //if last name of student is equal to 5 or greater than take six letters and add to email;
    //otherwise just add 3 letters
    if (registerModel.getLname().length() >= 6) {
        sb.append(registerModel.getLname().substring(0,6));
        sb.append("@students.kennesaw.edu");
        System.out.println(sb);
        String campusEmail = new String(sb);
        return campusEmail.toLowerCase();
    }
    sb.append(registerModel.getLname().substring(0,3));
    sb.append("@students.kennesaw.edu");
    String campusEmail = new String(sb);
    return campusEmail.toLowerCase();

}
}
