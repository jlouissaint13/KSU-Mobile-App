package com.ksumobileapp.Login;

import com.ksumobileapp.Registration.RegisterMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginController {
private RegisterMain registerMain;
private LoginView loginView;
private LoginService loginService;
private LoginModel loginModel;
   private Button loginButton,registerButton;
    public LoginController(Stage stage,LoginView loginView,LoginModel loginModel,LoginService loginService) {
        this.loginView = loginView;
        this.loginService = loginService;
        this.loginModel = loginModel;
        loginButton = loginView.getLoginButton();
        registerButton = loginView.getCreateAccountButton();
        registerMain = new RegisterMain();


        registerButton.setOnAction(e->register(stage,registerMain));


        loginButton.setOnAction(e-> {
            try {
                login(loginModel);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }





    public void login(LoginModel loginModel) throws SQLException {
       // this.loginModel.setCampusEmail(loginView.getCampusEmail());
        //this.loginModel.setPassword(loginView.getPassword());
        this.loginModel.setCampusEmail("jlouiss@students.kennesaw.edu");
        this.loginModel.setPassword("password");

        loginService.login(this.loginModel);
    }

    public void register(Stage stage,RegisterMain registerMain) {
        registerMain.start(stage);
    }
}
