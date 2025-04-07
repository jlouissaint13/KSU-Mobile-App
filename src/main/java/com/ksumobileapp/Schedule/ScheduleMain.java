package com.ksumobileapp.Schedule;

import javafx.application.Application;
import javafx.stage.Stage;

public class ScheduleMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private ScheduleView scheduleView;
    @Override
    public void start(Stage primaryStage) {

        scheduleView = new ScheduleView(primaryStage);

    }
}
