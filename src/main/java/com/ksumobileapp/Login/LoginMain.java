package com.ksumobileapp.Login;

import javafx.application.Application;
import javafx.stage.Stage;

public class LoginMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private LoginView loginView;
    @Override
    public void start(Stage primaryStage) {
       loginView = new LoginView(primaryStage);
    }
}
