package com.ksumobileapp.Personal;

import com.ksumobileapp.Login.LoginModel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonalService {
    //TODO find a better way to do this tired rn
    private LoginModel loginModel;

    public PersonalService() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select * from users where users.campusEmail = ?";
        String email = LoginModel.getCurrentUser();
        var campusEmail = loginModel.getCampusEmail();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, campusEmail);
            var rs = pstmt.executeQuery();
            System.out.println(rs.getString(1));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
