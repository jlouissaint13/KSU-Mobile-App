package com.ksumobileapp.Schedule;
import java.util.HashSet;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScheduleModel extends Application {

    private Pane pane;
    private Text displaySchedule;
    private ListView<CourseModel> enrolledCoursesList, availableCoursesList;
    private ObservableList<CourseModel> enrolledCourses, availableCourses;
    private HashSet<CourseModel> selectedCourses;
    private Button enroll, remove;

    public void components(){
        pane = new Pane();

        //Text
        displaySchedule = new Text("Schedule Display");

        //ListViews for the courses
        enrolledCoursesList = new ListView<>();
        availableCoursesList = new ListView<>();

        //Buttons
        enroll = new Button("Enroll");
        remove = new Button("Remove");
    }

    public void properties(){

        //position text
        displaySchedule.setLayoutX(125);
        displaySchedule.setLayoutY(50);

        //position the ListViews
        availableCoursesList.setLayoutX(50);
        availableCoursesList.setLayoutY(80);
        availableCoursesList.setPrefSize(250, 100);
        enrolledCoursesList.setLayoutX(50);
        enrolledCoursesList.setLayoutY(300);
        enrolledCoursesList.setPrefSize(250, 100);

        //position the Buttons
        enroll.setLayoutX(150);
        enroll.setLayoutY(200);
        remove.setLayoutX(150);
        remove.setLayoutY(250);
    }

    public void addComponents(){
        pane.getChildren().addAll(displaySchedule, availableCoursesList, enrolledCoursesList,
                enroll, remove);
    }

    public ScheduleModel(Stage stage){
        components();
        properties();
        addComponents();

        stage.setTitle("Schedule Builder");
        Scene scene = new Scene(pane, 350, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
