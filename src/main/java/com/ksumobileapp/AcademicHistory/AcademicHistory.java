package com.ksumobileapp.AcademicHistory;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Profile.ProfileMain;
import com.ksumobileapp.ScheduleBuilder.CourseModel;
import com.ksumobileapp.ScheduleBuilder.EnrollmentModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AcademicHistory extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Pane pane;
    private Scene scene;
    private TableView enrollmentTable;
    @Override
    public void start(Stage primaryStage) {
        Text academicText = new Text("Academic History");
        Button back = new Button("<");
        ProfileMain profileMain = new ProfileMain();
        enrollmentTable = new TableView<>();
        TableColumn<EnrollmentModel,String> courseID = new TableColumn<>("Course Prefix");
        TableColumn<EnrollmentModel,String> courseName = new TableColumn<>("Course Name");
        TableColumn<EnrollmentModel,String> credit = new TableColumn<>("Credit");
        TableColumn<EnrollmentModel,String> semester = new TableColumn<>("Semester");
        TableColumn<EnrollmentModel,String> schedule = new TableColumn<>("Schedule");

        courseID.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        semester.setCellValueFactory(new PropertyValueFactory<>("semester"));
        schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));


        enrollmentTable.getColumns().addAll(courseID,courseName,credit,semester,schedule);
        academicText.setLayoutX(120);
        academicText.setLayoutY(30);
        back.setLayoutX(20);
        back.setLayoutY(30);
        back.setOnAction(e-> profileMain.start(primaryStage));
        enrollmentTable.setLayoutX(50);
        enrollmentTable.setLayoutY(100);
        enrollmentTable.setMaxSize(250,550);

        Pane pane = new Pane();
        pane.getChildren().addAll(academicText,back,enrollmentTable);
        fillTable();
        primaryStage.setTitle("Academic History");
        Scene scene1 = new Scene(pane,350,600);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public void fillTable() {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select courseID,courseName,credit,semester,schedule from enrollments  where studentID = ? order by semester desc";
        String studentID = LoginModel.getCurrentUser();
        ObservableList<EnrollmentModel> list = FXCollections.observableArrayList();
        try (var conn = DriverManager.getConnection(url)) {
            var pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentID);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new EnrollmentModel(
                        rs.getString("courseID"),
                        rs.getString("courseName"),
                        rs.getString("credit"),
                        rs.getString("semester"),
                        rs.getString("schedule")
                ));
            }
            enrollmentTable.setItems(list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
