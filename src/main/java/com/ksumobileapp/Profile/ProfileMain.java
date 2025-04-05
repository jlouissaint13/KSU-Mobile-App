package com.ksumobileapp.Profile;

import javafx.application.Application;
import javafx.stage.Stage;

public class ProfileMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    ProfileView profileView;
    @Override
    public void start(Stage primaryStage) {

        profileView = new ProfileView(primaryStage);


    }
}
