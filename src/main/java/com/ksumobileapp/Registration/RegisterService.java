package com.ksumobileapp.Registration;


import java.sql.*;
import java.sql.Connection;


public class RegisterService {

public void databaseConnection(RegisterModel registerModel) throws SQLException {

    String url = "jdbc:sqlite:accounts.db";
    String sql = "INSERT INTO users(firstName, lastName, phone,campusEmail,username,personalEmail,password, address, gender, race, dob, classification, major) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try (Connection connection = DriverManager.getConnection(url);
         PreparedStatement pstmt = connection.prepareStatement(sql)) {

        pstmt.setString(1, registerModel.getFname());
        pstmt.setString(2, registerModel.getLname());
        pstmt.setString(3, registerModel.getPhone());
        pstmt.setString(4, generateEmail(registerModel));
        pstmt.setString(5, generateUsername(registerModel));
        pstmt.setString(6, registerModel.getEmail());
        pstmt.setString(7, registerModel.getPassword());
        pstmt.setString(8, registerModel.getAddress());
        pstmt.setString(9, registerModel.getGender());
        pstmt.setString(10, registerModel.getRace());
        pstmt.setString(11, registerModel.getDob());
        pstmt.setString(12, registerModel.getClassification());
        pstmt.setString(13, registerModel.getMajor());


        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}


//campus email generator
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
public String generateUsername(RegisterModel registerModel) {
    StringBuilder sb = new StringBuilder();
    String userName = generateEmail(registerModel);
    for(int i = 0;i<registerModel.getEmail().length();i++) {
        if (userName.charAt(i) == '@') return sb.toString().toLowerCase();
        sb.append(userName.charAt(i));


    }
    return "none";
}
    //True means textField is empty
public boolean isEmpty(RegisterModel registerModel) {
   for(String d: registerModel.data) {
       if (d.equals("") || d == null) return true;
   }
    return false;
}
//false is invalid email
public boolean emailValidation(RegisterModel registerModel) {

    return registerModel.getEmail().contains("@") && registerModel.getEmail().contains(".com");

}
public boolean validPhoneNumber(RegisterModel registerModel) {
    //first make sure phone length is equal to ten. Then confirm that phone number is all digits
    if (registerModel.getPhone().length() == 10) return registerModel.getPhone().matches("\\d+");

    return false;
}



}

