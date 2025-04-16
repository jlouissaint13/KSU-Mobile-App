package com.ksumobileapp.Schedule;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ScheduleMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ScheduleView scheduleView;
    private ScheduleController scheduleController;
    private Image logo = new Image("logo.png");
    private ImageView imageView = new ImageView(logo);

    @Override
    public void start(Stage primaryStage) {

        primaryStage.getIcons().add(imageView.getImage());
        scheduleView = new ScheduleView(primaryStage);
        scheduleController = new ScheduleController(scheduleView.courseTable, scheduleView.courseNameColumn, scheduleView.courseCodeColumn, scheduleView.scheduleList);
    }
}
