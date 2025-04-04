package com.ksumobileapp.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginService {
private LoginModel loginModel;
public LoginService() {

}



public void login(LoginModel loginModel) throws SQLException {
    String url = "jdbc:sqlite:accounts.db";
    String sql = "Select users.password from users where users.campusEmail = ?";
    var campusEmail = loginModel.getCampusEmail();
    try (var conn = DriverManager.getConnection(url);
         var pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1,campusEmail);
        var rs = pstmt.executeQuery();
        System.out.println(rs.getString(1));

    }
}
//todo take login function and make a new method just for getting the password that way login function
    //does not get to long


}
