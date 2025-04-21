package com.ksumobileapp.Profile;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Registration.RegisterModel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ProfileService {


    public void setStatus() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select status from users where users.studentID = ?";
        String studentID = "";
        if (LoginModel.getCurrentUser() == null) {
            studentID = RegisterModel.getStudentID();
        } else {
            studentID = LoginModel.getCurrentUser();
        }
        // if registration path login will be null bc it will not have been init
        //if login path then registration will be null it is not possible for it to be both

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                ProfileModel.setStatus(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
