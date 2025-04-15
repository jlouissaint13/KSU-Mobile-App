package com.ksumobileapp.ScheduleBuilder;

import com.ksumobileapp.Login.LoginModel;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public boolean courseExists() throws SQLException {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT courseID,semester FROM enrollments WHERE courseID = ? and studentID = ?";
        String courseID;
        String studentID;
        courseID = CourseModel.getCourseID();
        studentID = LoginModel.getCurrentUser();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, courseID);
            pstmt.setString(2, studentID);
            var rs = pstmt.executeQuery();
            //if semester and courseID are the same then tell the student they are already enrolled;
            if (rs.getString(1).equals(CourseModel.getCourseID()) && rs.getString(2).equals(CourseModel.getSemester()))
                return true;

            return false;

        } catch (NullPointerException e) {
            return false;
        }
    }

    //TODO needs to be tested
    public boolean scheduleError(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT schedule FROM enrollments WHERE studentID = ? and semester = ?";
        String studentID;
        String semester;
        String selectedTime = enrollmentModel.getSchedule();
        studentID = LoginModel.getCurrentUser();
        semester = CourseModel.getSemester();
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            pstmt.setString(2, semester);
            var rs = pstmt.executeQuery();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            //grabs start time of class student is trying to enroll in
            String[] split = selectedTime.split("-");
            LocalTime start = LocalTime.parse(split[0], formatter);
            //will compare the time with all classes the student is in for the semester
            while (rs.next()) {
                String compareTime = rs.getString("schedule");
                String[] compareSplit = compareTime.split("-");
                LocalTime compareStart = LocalTime.parse(compareSplit[0], formatter);

                long diffMinutes = Math.abs(Duration.between(compareStart, start).toMinutes());


                if (diffMinutes < 90) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;

    }

    //needs to run after the get and set prereq func
    //if true then student has the prerequisites
    public int prereqChecker(EnrollmentModel enrollmentModel) {

        if (enrollmentModel.getPrerequisites().getFirst().equals("N/A")) return 0;
        String url = "jdbc:sqlite:accounts.db";
        String sql = "SELECT courseID,semester FROM enrollments WHERE courseID = ? and studentID = ?";
        var studentID = LoginModel.getCurrentUser();
        for (int i = 0; i < enrollmentModel.getPrerequisites().size(); i++) {
            var courseID = enrollmentModel.getPrerequisites().get(i);
            try (var conn = DriverManager.getConnection(url)) {
                var pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, courseID);
                pstmt.setString(2, studentID);
                var rs = pstmt.executeQuery();
                if (rs.next())
                    //This means that the student is attempting to take a prerequisite that takes place during the same semester as the class that requires it;
                    //lazy fix does not check to see if semester was before or after just checks for semester due to time constraints;
                    if (enrollmentModel.getPrerequisites().get(i).equals(rs.getString(1)) && CourseModel.getSemester().equals(rs.getString(2)))
                        return 1;

                if (enrollmentModel.getPrerequisites().get(i).equals(rs.getString("courseID"))) return 0;


            } catch (NullPointerException e) {
                return 0;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        //prereq issues
        return 2;
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

    public int getCredit() {
        int totalCredits = 0;
        int credit;
        String url = "jdbc:sqlite:accounts.db";
        String sql = "select credit from enrollments where studentID = ? and semester = ?";
        String studentID = LoginModel.getCurrentUser();
        String semseter = CourseModel.getSemester();
        try (var conn = DriverManager.getConnection(url)) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            pstmt.setString(2, semseter);
            var resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                credit = Integer.parseInt(resultSet.getString(1));
                totalCredits += credit;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalCredits;

    }

    public boolean creditLimitError() {
        if (getCredit() > 18) return true;
        return false;
    }

    public int getCreditForPayment() {
        int totalCredits = 0;
        int credit;
        String url = "jdbc:sqlite:accounts.db";
        String sql = "select credit from enrollments where studentID = ? and semester = ?";
        String studentID = LoginModel.getCurrentUser();
        String semseter = "Spring 2025";
        try (var conn = DriverManager.getConnection(url)) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            pstmt.setString(2, semseter);
            var resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                credit = Integer.parseInt(resultSet.getString(1));
                totalCredits += credit;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return totalCredits;

    }


    public ArrayList<String> setPrerequisites(EnrollmentModel enrollmentModel) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select prerequisite_code from coursePrerequisites where courseID = ?";
        String courseID = CourseModel.getCourseID();
        ArrayList<String> prerequisites = new ArrayList<>();
        try (var conn = DriverManager.getConnection(url)) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, courseID);
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














