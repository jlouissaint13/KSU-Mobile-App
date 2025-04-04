package com.ksumobileapp.Login;

import javafx.application.Application;
import javafx.stage.Stage;

public class LoginMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private LoginView loginView;
    private LoginController loginController;
    private LoginModel loginModel;
    private LoginService loginService;
    @Override
    public void start(Stage primaryStage) {
       loginView = new LoginView(primaryStage);
       loginModel = new LoginModel("","");
       loginService = new LoginService();
       LoginController loginController = new LoginController(primaryStage,loginView,loginModel,loginService);

    }
}
