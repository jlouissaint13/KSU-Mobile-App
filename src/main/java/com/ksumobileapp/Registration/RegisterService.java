package com.ksumobileapp.Registration;


import java.sql.*;
import java.sql.Connection;
import java.util.Random;

public class RegisterService {
    String url = "jdbc:sqlite:accounts.db";
public void databaseConnection(RegisterModel registerModel) throws SQLException {

    String url = "jdbc:sqlite:accounts.db";
    String sql = "INSERT INTO users(studentID,firstName, lastName, phone,campusEmail,username,personalEmail,password, address, gender, race, dob, classification, major) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try (Connection connection = DriverManager.getConnection(url);
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1,idGenerator());
        pstmt.setString(2, registerModel.getFname());
        pstmt.setString(3, registerModel.getLname());
        pstmt.setString(4, registerModel.getPhone());
        pstmt.setString(5, generateEmail(registerModel));
        pstmt.setString(6, generateUsername(registerModel));
        pstmt.setString(7, registerModel.getEmail());
        pstmt.setString(8, registerModel.getPassword());
        pstmt.setString(9, registerModel.getAddress());
        pstmt.setString(10, registerModel.getGender());
        pstmt.setString(11, registerModel.getRace());
        pstmt.setString(12, registerModel.getDob());
        pstmt.setString(13, registerModel.getClassification());
        pstmt.setString(14, registerModel.getMajor());


        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}

//Generators
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
        String campusEmail = new String(sb);
        return campusEmail.toLowerCase();
    }
    sb.append(registerModel.getLname().substring(0,3));
    sb.append("@students.kennesaw.edu");
    String campusEmail = new String(sb);
    return campusEmail.toLowerCase();
}
//generates a username
public String generateUsername(RegisterModel registerModel) {
    StringBuilder sb = new StringBuilder();
    String userName = generateEmail(registerModel);
    for(int i = 0;i<registerModel.getEmail().length();i++) {
        if (userName.charAt(i) == '@') return sb.toString().toLowerCase();
        sb.append(userName.charAt(i));

    }
    return "none";
}


public String idGenerator() {
    String studentID;
    Random rand = new Random();
    do {
        int intID = rand.nextInt(500000) + 500000;
        studentID = "000" + intID;
    }while (ifExistsID(studentID));

    return studentID;
}


//Validators
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
//if email exists then true
public boolean ifExistsEmail(RegisterModel registerModel) {
    String url = "jdbc:sqlite:accounts.db";
    String sql = "Select personalEmail from users where personalEmail = ?";
    var personalEmail = registerModel.getEmail();
    try (var conn = DriverManager.getConnection(url);
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, personalEmail);
        var rs = pstmt.executeQuery();
        return rs.getString(1).equals(personalEmail);


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
//if true then phone number exists
public boolean ifExistsPhone(RegisterModel registerModel) {
    String url = "jdbc:sqlite:accounts.db";
    String sql = "Select phone from users where phone= ?";
    var phoneNumber = registerModel.getPhone();
    try (var conn = DriverManager.getConnection(url);
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, phoneNumber);
        var rs = pstmt.executeQuery();
        return rs.getString(1).equals(phoneNumber);


    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
//if false then ID does not exist
    public boolean ifExistsID(String ID) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select studentID from users where studentID = ?";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            var rs = pstmt.executeQuery();

            return rs.getString(1) == ID;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

