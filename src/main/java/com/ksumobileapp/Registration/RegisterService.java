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
//True means textField is empty
public boolean isEmpty(RegisterModel registerModel) {
    for (int i = 0;i<registerModel.data.length;i++) {
        if (registerModel.data[i].equals("")) return true;
    }
    return false;
}
//false is invalid email
public boolean emailValidation(RegisterModel registerModel) {

    return registerModel.getEmail().contains("@") && registerModel.getEmail().contains(".com");

}
public boolean validPhoneNumber(RegisterModel registerModel) {
    //first make sure phone length is equal to ten. Then confirm that phone number is all digits
    if (registerModel.getPhone().length() == 10 ) return registerModel.getPhone().matches("\\d+");

    return false;
}


}

