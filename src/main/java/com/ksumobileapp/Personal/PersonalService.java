package com.ksumobileapp.Personal;

import com.ksumobileapp.Login.LoginModel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonalService {
    //TODO find a better way to do this tired rn
    private LoginModel loginModel;
    private String studentID,firstName,lastName,phone,campusEmail,username,personalEmail,password,address,gender,race,dob,classification,major;
    private PersonalModel personalModel;
    public PersonalService() {



        }





        public void getData(PersonalModel personalModel) {
            String url = "jdbc:sqlite:accounts.db";
            String sql = "Select * from users where users.studentID = ?";
            var studentID = LoginModel.getCurrentUser();
            try (var conn = DriverManager.getConnection(url);
                 var pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, studentID);
                var rs = pstmt.executeQuery();
                if (rs.next()) {
                    personalModel.setStudentID(rs.getString("studentID")) ;
                    personalModel.setFirstName( rs.getString("firstName"));
                    personalModel.setLastName(rs.getString("lastName"));
                    personalModel.setPhone(rs.getString("phone"));
                    personalModel.setCampusEmail(rs.getString("campusEmail"));
                    personalModel.setUsername(rs.getString("username"));
                    personalModel.setPersonalEmail(rs.getString("personalEmail"));
                    personalModel.setPassword(rs.getString("password"));
                    personalModel.setAddress(rs.getString("address"));
                    personalModel.setGender(rs.getString("gender"));
                    personalModel.setRace(rs.getString("race"));
                    personalModel.setDob(rs.getString("dob"));
                    personalModel.setClassification(rs.getString("classification"));
                    personalModel.setMajor(rs.getString("major"));
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}
