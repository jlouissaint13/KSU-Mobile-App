package com.ksumobileapp.Personal;

import javafx.application.Application;
import javafx.stage.Stage;

public class PersonalMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private PersonalView personalView;
    private PersonalController personalController;
    @Override
    public void start(Stage primaryStage) {
    personalView = new PersonalView(primaryStage);
    personalController = new PersonalController(primaryStage,personalView);
    }
}
