package com.ksumobileapp.Schedule;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class ScheduleController {

    private TableView<CourseModel> courseTable;
    private TableColumn<CourseModel, String> courseNameColumn;
    private TableColumn<CourseModel, String> courseCodeColumn;
    private ListView<String> scheduleList;
    private ObservableList<CourseModel> availableCourses;
    private ObservableList<String> enrolledCourses;

    public ScheduleController(TableView<CourseModel> courseTable, TableColumn<CourseModel, String> courseNameColumn,
                              TableColumn<CourseModel, String> courseCodeColumn, ListView<String> scheduleList){

        this.courseTable = courseTable;
        this.courseNameColumn = courseNameColumn;
        this.courseCodeColumn = courseCodeColumn;
        this.scheduleList = scheduleList;

        this.availableCourses = FXCollections.observableArrayList(
                new CourseModel("Data Structures", "CS 3305"),
                new CourseModel("Calculus II", "MATH 2202"),
                new CourseModel("English II", "ENGL 1101"),
                new CourseModel("Programming & Problem Solving II", "CSE 1322")
        );

        this.enrolledCourses = FXCollections.observableArrayList();
        initialize();
    }

    private void initialize(){
        //Bind the data to the columns
        courseNameColumn.setCellValueFactory(data -> new javafx.beans.property.ReadOnlyStringWrapper(data.getValue().getName()));
        courseCodeColumn.setCellValueFactory(data -> new javafx.beans.property.ReadOnlyStringWrapper(data.getValue().getCode()));

        //Fill the table
        courseTable.setItems(availableCourses);

        //Bind the schedule with enrolled classes
        scheduleList.setItems(enrolledCourses);

    }

    /*public void handleEnroll(){
        CourseModel selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if(selectedCourse != null){
            if(!enrolledCourses.contains(selectedCourse.getName() + " - " + selectedCourse.getCode())){
                enrolledCourses.add(selectedCourse.getName() + " - " + selectedCourse.getCode());
            }else{
                showAlert("Already enrolled.", "Select a different course.");
            }
        }else {
            showAlert("No class selected.", "Please select a class to enroll.");
        }
    }*/

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



}
