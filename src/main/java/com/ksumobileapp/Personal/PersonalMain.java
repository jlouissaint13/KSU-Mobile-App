package com.ksumobileapp.Personal;

import javafx.application.Application;
import javafx.stage.Stage;

public class PersonalMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private PersonalView personalView;
    private PersonalController personalController;
    private PersonalModel personalModel;
    private PersonalService personalService;
    @Override
    public void start(Stage primaryStage) {
    personalView = new PersonalView(primaryStage);
    personalService = new PersonalService();
    personalModel = new PersonalModel();
    personalController = new PersonalController(primaryStage,personalView,personalService,personalModel);

    }
}
