package com.ksumobileapp.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginService {
    private LoginModel loginModel;

    public LoginService() {

    }


    public int login(LoginModel loginModel) {

        //System.out.println(loginModel.getPassword());
        //System.out.println(password(loginModel));


        if (loginModel.getPassword().equals(password(loginModel))) {
            return 1;
        }
        if (loginModel.getCampusEmail().isEmpty() || loginModel.getPassword().isEmpty()) {
            return 2;
        }
        
        return 4;

    }
    //code 1 returned OK
    //code 2 password invalid
    //code 3 account does not exist
    public String password(LoginModel loginModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select users.password from users where users.campusEmail = ?";
        var campusEmail = loginModel.getCampusEmail();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, campusEmail);
            var rs = pstmt.executeQuery();
          return rs.getString(1);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void setCurrentLoggedIn(LoginModel loginModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select users.studentID from users where users.campusEmail = ?";
        var campusEmail = loginModel.getCampusEmail();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, campusEmail);
            var rs = pstmt.executeQuery();
            LoginModel.setCurrentUser(rs.getString(1));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //run this everytime on when clicking login so this can prevent needing to be reset;
    /*public String getCurrentUser(LoginModel loginModel) {

    }

     */
}
