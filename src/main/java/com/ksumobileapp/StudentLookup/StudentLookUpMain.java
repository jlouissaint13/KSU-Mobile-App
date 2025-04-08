package com.ksumobileapp.StudentLookup;

import javafx.application.Application;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class StudentLookUpMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private StudentLookupView studentLookupView;
    private StudentLookupController studentLookupController;
    @Override
    public void start(Stage primaryStage) {
        this.studentLookupView = new StudentLookupView(primaryStage);
        this.studentLookupController = new StudentLookupController(primaryStage,studentLookupView);
    }

}
