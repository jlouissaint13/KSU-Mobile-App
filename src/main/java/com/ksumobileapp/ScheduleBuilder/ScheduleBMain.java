package com.ksumobileapp.ScheduleBuilder;

import javafx.application.Application;
import javafx.stage.Stage;

public class ScheduleBMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private ScheduleBView scheduleBView;
    private ScheduleBController scheduleBController;
    @Override
    public void start(Stage primaryStage) {
       scheduleBView = new ScheduleBView(primaryStage);

       scheduleBController = new ScheduleBController(primaryStage,scheduleBView);
    }
}
