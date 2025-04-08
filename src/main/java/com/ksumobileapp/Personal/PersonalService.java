package com.ksumobileapp.Personal;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Registration.RegisterModel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonalService {
    //TODO find a better way to do this tired rn
    private LoginModel loginModel;
    private String studentID;
    private PersonalModel personalModel;
    private RegisterModel registerModel;
    public PersonalService() {

        if (LoginModel.getCurrentUser() == null) {
            this.studentID = RegisterModel.getStudentID();
        }
        else {
            this.studentID = LoginModel.getCurrentUser();
        }

        }

        public void updateData(PersonalView personalView) {
            String url = "jdbc:sqlite:accounts.db";
            String sql = "update users set " +
                    "phone = ? ," +
                    "personalEmail = ? , " +
                    "password = ? ," +
                    "address = ?" +
                    "where studentID = ? ";
            String phone = personalView.getPhone();
            String personalEmail = personalView.getEmail();
            String password = personalView.getPassword();
            String address = personalView.getAddress();
            try (var conn = DriverManager.getConnection(url);
                 var pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, phone);
                pstmt.setString(2,personalEmail);
                pstmt.setString(3,password);
                pstmt.setString(4,address);
                pstmt.setString(5,studentID);

                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }





        public void getData(PersonalModel personalModel) {
            String url = "jdbc:sqlite:accounts.db";
            String sql = "Select * from users where users.studentID = ?";

            // if registration path login will be null bc it will not have been init
            //if login path then registration will be null it is not possible for it ot be botb


            try (var conn = DriverManager.getConnection(url);
                 var pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, this.studentID);
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
                    personalModel.setStatus(rs.getString("status"));
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }
}
