package com.ksumobileapp.Login;

import com.ksumobileapp.Registration.RegisterMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
private RegisterMain registerMain;
private LoginView loginView;
   private Button loginButton,registerButton;
    public LoginController(Stage stage,LoginView loginView,LoginModel loginModel,LoginService loginService) {
        this.loginView = loginView;
        loginButton = loginView.getLoginButton();
        registerButton = loginView.getCreateAccountButton();
        registerMain = new RegisterMain();
        registerButton.setOnAction(e->login(stage,registerMain));

    }

    public void login(Stage stage,RegisterMain registerMain) {
        registerMain.start(stage);
    }
}
