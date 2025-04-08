package com.ksumobileapp.Admin;

import javafx.application.Application;
import javafx.stage.Stage;

public class AdminMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
        private AdminView adminView;
        private AdminController adminController;
    @Override
    public void start(Stage primaryStage) {
        this.adminView = new AdminView(primaryStage);

        adminController = new AdminController(primaryStage,this.adminView);
    }

}
