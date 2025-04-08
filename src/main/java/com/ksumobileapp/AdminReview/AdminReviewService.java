package com.ksumobileapp.AdminReview;

import com.ksumobileapp.Admin.AdminModel;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminReviewService {
private String studentID;
public AdminReviewService() {
    AdminModel adminModel = new AdminModel();
    this.studentID = adminModel.getStudentID();
}


    public void updateData(AdminReviewView adminReviewView) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "UPDATE users SET " +
                "studentID = ?, " +
                "firstName = ?, " +
                "lastName = ?, " +
                "phone = ?, " +
                "campusEmail = ?, " +
                "username = ?, " +
                "personalEmail = ?, " +
                "password = ?, " +
                "address = ?, " +
                "gender = ?, " +
                "race = ?, " +
                "dob = ?, " +
                "classification = ?, " +
                "major = ?, " +
                "status = ? " +
                "WHERE studentID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.studentID);
            pstmt.setString(2, adminReviewView.getfName());
            pstmt.setString(3, adminReviewView.getlName());
            pstmt.setString(4, adminReviewView.getPhone());
            pstmt.setString(5, adminReviewView.getCampusEmail());
            pstmt.setString(6, adminReviewView.getUsername());
            pstmt.setString(7, adminReviewView.getPersonalEmail());
            pstmt.setString(8, adminReviewView.getPassword());
            pstmt.setString(9, adminReviewView.getAddress());
            pstmt.setString(10, adminReviewView.getGender());
            pstmt.setString(11, adminReviewView.getRace());
            pstmt.setString(12, adminReviewView.getDob());
            pstmt.setString(13, adminReviewView.getClassification());
            pstmt.setString(14, adminReviewView.getMajor());
            pstmt.setString(15, adminReviewView.getStatus());
            pstmt.setString(16, this.studentID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void updateData(AdminUpdateView adminUpdateView) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "UPDATE users SET " +
                "studentID = ?, " +
                "firstName = ?, " +
                "lastName = ?, " +
                "phone = ?, " +
                "campusEmail = ?, " +
                "username = ?, " +
                "personalEmail = ?, " +
                "password = ?, " +
                "address = ?, " +
                "gender = ?, " +
                "race = ?, " +
                "dob = ?, " +
                "classification = ?, " +
                "major = ?, " +
                "status = ? " +
                "WHERE studentID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, this.studentID);
            pstmt.setString(2, adminUpdateView.getfName());
            pstmt.setString(3, adminUpdateView.getlName());
            pstmt.setString(4, adminUpdateView.getPhone());
            pstmt.setString(5, adminUpdateView.getCampusEmail());
            pstmt.setString(6, adminUpdateView.getUsername());
            pstmt.setString(7, adminUpdateView.getPersonalEmail());
            pstmt.setString(8, adminUpdateView.getPassword());
            pstmt.setString(9, adminUpdateView.getAddress());
            pstmt.setString(10, adminUpdateView.getGender());
            pstmt.setString(11, adminUpdateView.getRace());
            pstmt.setString(12, adminUpdateView.getDob());
            pstmt.setString(13, adminUpdateView.getClassification());
            pstmt.setString(14, adminUpdateView.getMajor());
            pstmt.setString(15, adminUpdateView.getStatus());
            pstmt.setString(16, this.studentID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getData(AdminReviewModel adminReviewModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT * FROM users WHERE users.studentID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, this.studentID);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                adminReviewModel.setStudentID(rs.getString("studentID"));
                adminReviewModel.setFirstName(rs.getString("firstName"));
                adminReviewModel.setLastName(rs.getString("lastName"));
                adminReviewModel.setPhone(rs.getString("phone"));
                adminReviewModel.setCampusEmail(rs.getString("campusEmail"));
                adminReviewModel.setUsername(rs.getString("username"));
                adminReviewModel.setPersonalEmail(rs.getString("personalEmail"));
                adminReviewModel.setPassword(rs.getString("password"));
                adminReviewModel.setAddress(rs.getString("address"));
                adminReviewModel.setGender(rs.getString("gender"));
                adminReviewModel.setRace(rs.getString("race"));
                adminReviewModel.setDob(rs.getString("dob"));
                adminReviewModel.setClassification(rs.getString("classification"));
                adminReviewModel.setMajor(rs.getString("major"));
                adminReviewModel.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateStatusAccept(AdminReviewView adminReviewView) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "UPDATE users SET " +
                "status = ? " +
                "WHERE studentID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,"Accepted");
            pstmt.setString(2, this.studentID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public void updateStatusDenied(AdminReviewView adminReviewView) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "UPDATE users SET " +
                "status = ? " +
                "WHERE studentID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,"Rejected");
            pstmt.setString(2, this.studentID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
