package com.ksumobileapp.Registration;


import java.sql.*;
import java.sql.Connection;
import java.util.Objects;
import java.util.Random;

public class RegisterService {
    private static String studentID;

    public void databaseConnection(RegisterModel registerModel) throws SQLException {

    String url = "jdbc:sqlite:accounts.db";
    String sql = "INSERT INTO users(studentID,firstName, lastName, phone,campusEmail,username,personalEmail,password, address, gender, race, dob, classification, major,status) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    try (Connection connection = DriverManager.getConnection(url);
         PreparedStatement pstmt = connection.prepareStatement(sql)) {
        pstmt.setString(1,idGenerator(registerModel));
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
        pstmt.setString(15,"Pending");


        pstmt.executeUpdate();

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}

//Generators
//campus email generator
public String generateEmail(RegisterModel registerModel) {
    Random rand = new Random();
    int random = rand.nextInt(6) + 1;
    int randForEmail = rand.nextInt(999) + 1;
    int randForEmails = rand.nextInt(3) + 1;
    StringBuilder sb = new StringBuilder();
    //get the first letter of the students first name
    sb.append(registerModel.getFname().charAt(0));

    //if last name of student is equal to 5 or greater than take six letters and add to email;
    //otherwise just add 3 letters
    if (registerModel.getLname().length() >= 6) {
        sb.append(registerModel.getLname().substring(0,random));
        sb.append(randForEmail);
        sb.append("@students.kennesaw.edu");
        String campusEmail = new String(sb);
        return campusEmail.toLowerCase();
    }
    sb.append(registerModel.getLname().substring(0,1));
    sb.append(randForEmail);
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


public String idGenerator(RegisterModel registerModel) {
    String studentID;
    Random rand = new Random();
    do {
        int intID = rand.nextInt(500000) + 500000;
        studentID = "000" + intID;
    }while (ifExistsID(studentID));
    RegisterModel.setStudentID(studentID);
    return studentID;
}



//Validators
    //true means textField is empty;
public boolean isEmptyCheck(RegisterModel registerModel) {
   for(String d: registerModel.data) {
       if (d.equals("") || d == null) return true;
   }
    return false;
}
//true is invalid email;
public boolean invalidlEmailCheck(RegisterModel registerModel) {

     if (registerModel.getEmail().contains("@") && registerModel.getEmail().contains(".com")) return false;

     return true;

}
//if invalid then true;
public boolean invalidPhoneCheck(RegisterModel registerModel) {
    //first make sure phone length is equal to ten. Then confirm that phone number is all digits
    if (registerModel.getPhone().length() == 10 && registerModel.getPhone().matches("\\d+")) {
        return false;
    }

    return true;
}
//if email exists then true;
public boolean ifExistsEmailCheck(RegisterModel registerModel) throws NullPointerException {
    if (registerModel.getEmail().isBlank()) return false;

    String url = "jdbc:sqlite:accounts.db";
    String sql = "Select personalEmail from users where personalEmail = ?";

    var personalEmail = registerModel.getEmail();
    try (var conn = DriverManager.getConnection(url);
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, personalEmail);
        var rs = pstmt.executeQuery();
        return rs.getString(1).equals(personalEmail);

    }catch (NullPointerException e) {
        return false;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
//if true then phone number exists;
public boolean ifExistsPhoneCheck(RegisterModel registerModel) throws NullPointerException {
    if (registerModel.getPhone().isBlank()) return false;
    String url = "jdbc:sqlite:accounts.db";
    String sql = "Select phone from users where phone= ?";
    var phoneNumber = registerModel.getPhone();
    try (var conn = DriverManager.getConnection(url);
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, phoneNumber);
        var rs = pstmt.executeQuery();
        return rs.getString(1).equals(phoneNumber);
    }catch (NullPointerException e) {
        return false;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
//true if invalid;
public boolean invalidDOBCheck(RegisterModel registerModel) {
    if ((registerModel.getDob().length() == 10)) {

        return false;
    }

    return true;

}




//if false then ID does not exist
    public boolean ifExistsID(String ID) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select studentID from users where studentID = ?";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            var rs = pstmt.executeQuery();

            return Objects.equals(rs.getString(1), ID);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int formValid(RegisterModel registerModel) {
    boolean invalidForms[] = new boolean[6];
    invalidForms[0] = isEmptyCheck(registerModel);
    invalidForms[1] = invalidlEmailCheck(registerModel);
    invalidForms[2] = invalidPhoneCheck(registerModel);
    invalidForms[3] = invalidDOBCheck(registerModel);
    invalidForms[4] = ifExistsEmailCheck(registerModel);
    invalidForms[5] = ifExistsPhoneCheck(registerModel);
    int result;
    for(int i = 0;i<invalidForms.length;i++) {
        if (invalidForms[i]) {
            result = i;
            return result;
        }
    }
    return 6;
    }
    //if true then something is null
public boolean comboBoxCheck(RegisterView registerView) throws NullPointerException {

       try {
           if ( registerView.getGender() == null || registerView.getRace() == null
                   || registerView.getDOB() == null || registerView.getClassification() == null
                   || registerView.getMajor() == null)
               return true;
       } catch (NullPointerException e) {
           return true;
       }


    return false;
}



}

