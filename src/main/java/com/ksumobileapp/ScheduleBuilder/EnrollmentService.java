package com.ksumobileapp.ScheduleBuilder;

import com.ksumobileapp.Login.LoginModel;

import java.sql.*;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EnrollmentService {


    public void enroll(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "INSERT INTO enrollments (studentID, courseID,courseName,credit,prefix,semester,schedule) VALUES (?, ?, ?, ?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, LoginModel.getCurrentUser());
            pstmt.setString(2, CourseModel.getCourseID());
            pstmt.setString(3, enrollmentModel.getCourseName());
            pstmt.setString(4, enrollmentModel.getCredit());
            pstmt.setString(5, enrollmentModel.getPrefix());
            pstmt.setString(6, enrollmentModel.getSemester());
            pstmt.setString(7, enrollmentModel.getSchedule());

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void unenroll() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "DELETE FROM enrollments WHERE studentID = ? and courseID = ?";

        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, LoginModel.getCurrentUser());
            pstmt.setString(2, CourseModel.getCourseID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
//TODO needs to be tested;
    public boolean courseExists() throws SQLException {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT courseID FROM enrollment WHERE courseID = ? and studentID = ?";
        String courseID;
        String studentID;
        courseID = CourseModel.getCourseID();
        studentID = LoginModel.getCurrentUser();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            var rs = pstmt.executeQuery();
            if (rs.getString(1) == null) return false;

            return true;

        }
    }
//TODO needs to be tested
    public boolean scheduleError(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT schedule FROM enrollment WHERE courseID = ? and studentID = ? and semesterID = ?";
        String courseID;
        String studentID;
        courseID = CourseModel.getCourseID();
        studentID = LoginModel.getCurrentUser();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            pstmt.setString(2, studentID);
            var rs = pstmt.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime timeOne = LocalTime.parse(rs.getString(1), formatter);
            LocalTime timeTwo = LocalTime.parse(rs.getString(2), formatter);
            Duration duration = Duration.between(timeOne, timeTwo);
            if (duration.toMinutes() < 90) return true;

            return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //needs to run after the get and set prereq func
    //if true then student has the prerequisites
    public boolean prereqChecker(EnrollmentModel enrollmentModel) {
        String enrollmentCourseID = " ";
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT courseID FROM enrollments WHERE courseID = ? and studentID = ?";
        var courseID = CourseModel.getCourseID();
        var studentID = LoginModel.getCurrentUser();
        try(var conn = DriverManager.getConnection(url)) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,courseID);
            pstmt.setString(2,studentID);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
               enrollmentCourseID = rs.getString(1);
            }
            for (int i = 0;i<enrollmentModel.getPrerequisites().size();i++) {
                if (enrollmentModel.getPrerequisites().get(i).equals(enrollmentCourseID))
                    System.out.println("Has the prerqu");
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }



    public void getData(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT * FROM courses WHERE courseID = ?";
        String courseID;
        courseID = CourseModel.getCourseID();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            var rs = pstmt.executeQuery();
            if (rs.next()) {

                enrollmentModel.setStudentID(LoginModel.getCurrentUser());
                enrollmentModel.setCourseID(rs.getString(1));
                enrollmentModel.setCourseName(rs.getString("courseName"));
                enrollmentModel.setCredit(rs.getString("credit"));
                enrollmentModel.setPrefix(rs.getString("prefix"));
                enrollmentModel.setSemester(CourseModel.getSemester());
                enrollmentModel.setSchedule(rs.getString("schedule"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public ArrayList<String> setPrerequisites(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select prerequisite_code from coursePrerequisites where courseID = ?";
        String courseID = CourseModel.getCourseID();
        ArrayList<String> prerequisites = new ArrayList<>();
        try(var conn = DriverManager.getConnection(url)) {
          var pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,courseID);
          var resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            prerequisites.add(resultSet.getString("prerequisite_code"));
        }
        enrollmentModel.setPrerequisites(prerequisites);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prerequisites;
    }
}














