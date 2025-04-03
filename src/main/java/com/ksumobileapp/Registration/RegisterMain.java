package com.ksumobileapp.Registration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegisterMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Button button;
    private RegisterView registerView;
    private RegisterModel registerModel;
    private RegisterService registerService;
    @Override
    public void start(Stage primaryStage) {



            RegisterView registerView = new RegisterView(primaryStage);
            RegisterModel registerModel1 = new RegisterModel("","","","","","","");
            RegisterService registerService1 = new RegisterService();
            RegisterController registerController = new RegisterController(registerView,registerService1,registerModel1);

    }
}
