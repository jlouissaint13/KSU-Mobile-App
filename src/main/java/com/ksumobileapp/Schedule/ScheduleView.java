package com.ksumobileapp.Schedule;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.collections.*;


public class ScheduleView  {

    private Image logo = new Image("logo.png");
    private ImageView imageView = new ImageView(logo);
    public TableView<CourseModel> courseTable;
    public TableColumn<CourseModel, String> courseNameColumn;
    public TableColumn<CourseModel, String> courseCodeColumn;
    ListView<String> scheduleList;
    private ObservableList<CourseModel> availableCourses;
    private ObservableList<String> enrolledCourses;


    public ScheduleView(Stage window){

        //Create UI
        Label availableClassesLabel = new Label("Available Classes");
        Label scheduleLabel = new Label("Your Schedule");

        courseTable = new TableView<>();
        courseNameColumn = new TableColumn<>("Course Name");
        courseCodeColumn = new TableColumn<>("Course Code");

        //Add them to the table
        courseTable.getColumns().addAll(courseNameColumn, courseCodeColumn);

        //Create available classes
        availableCourses = FXCollections.observableArrayList(
                new CourseModel("Data Structures", "CS 3305"),
                new CourseModel("Calculus II", "MATH 2202"),
                new CourseModel("English II", "ENGL 1101"),
                new CourseModel("Programming & Problem Solving II", "CSE 1322")
        );

        courseTable.setItems(availableCourses);

        scheduleList = new ListView<>();

        //Enroll button
        Button enrollButton = new Button("Enroll");
        enrollButton.setOnAction(e -> {
            CourseModel selectedCourse = courseTable.getSelectionModel().getSelectedItem();
            if(selectedCourse != null){
                scheduleList.getItems().add(selectedCourse.getName() + " - " + selectedCourse.getCode());
            } else{
                showAlert("No class selected", "Select a class to continue.");
            }
        });

        //Remove button
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {

        });

        //Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(availableClassesLabel, scheduleLabel,
                courseTable, enrollButton, scheduleList);

        Scene scene = new Scene(layout, 350, 600);
        window.getIcons().add(imageView.getImage());
        window.setScene(scene);
        window.show();
    }

    public void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
