package com.ksumobileapp.Registration;

import com.ksumobileapp.Login.LoginMain;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegisterMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private RegisterView registerView;
    private RegisterModel registerModel;
    private RegisterService registerService;

    @Override
    public void start(Stage primaryStage) {



            RegisterView registerView = new RegisterView(primaryStage);
        RegisterModel registerModel = new RegisterModel("", "", "", "", "", "", "", "", "", "", "");

        RegisterService registerService = new RegisterService();
            RegisterController registerController = new RegisterController(primaryStage,registerView,registerService,registerModel);

    }
}
