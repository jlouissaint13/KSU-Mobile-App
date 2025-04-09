package com.ksumobileapp.Schedule;
import java.util.HashSet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScheduleModel extends Application {

    public HashSet<CourseModel> schedule;
    private Pane pane;
    private Text displaySchedule;
    public CourseModel course;

    public void components(){
        pane = new Pane();
        displaySchedule = new Text("Schedule Display");
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
