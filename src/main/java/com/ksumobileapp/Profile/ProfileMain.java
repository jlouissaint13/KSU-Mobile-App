package com.ksumobileapp.Profile;

import javafx.application.Application;
import javafx.stage.Stage;

public class ProfileMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private ProfileController profileController;
    private ProfileView profileView;
    @Override
    public void start(Stage primaryStage) {

        profileView = new ProfileView(primaryStage);

        profileController = new ProfileController(primaryStage,profileView);
    }
}
