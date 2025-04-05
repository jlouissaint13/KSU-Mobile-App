package com.ksumobileapp.Login;

import com.ksumobileapp.Profile.ProfileMain;
import com.ksumobileapp.Registration.RegisterMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginController {
private RegisterMain registerMain;
private LoginView loginView;
private LoginService loginService;
private LoginModel loginModel;
private ProfileMain profileMain;
   private Button loginButton,registerButton;
    public LoginController(Stage stage,LoginView loginView,LoginModel loginModel,LoginService loginService) {
        this.loginView = loginView;
        this.loginService = loginService;
        this.loginModel = loginModel;
        loginButton = loginView.getLoginButton();
        registerButton = loginView.getCreateAccountButton();
        registerMain = new RegisterMain();
        profileMain = new ProfileMain();

        registerButton.setOnAction(e->register(stage,registerMain));


        loginButton.setOnAction(e-> {
            try {
                login(stage,this.loginModel);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }





    public void login(Stage stage,LoginModel loginModel) throws SQLException {
       // this.loginModel.setCampusEmail(loginView.getCampusEmail());
        //this.loginModel.setPassword(loginView.getPassword());
        this.loginModel.setCampusEmail("jlouiss@students.kennesaw.edu");
        this.loginModel.setPassword("password");

        //TODO special admin permissions email
        //if(admin take to a page of profiles which allows the admin to edit any profile for any user)


        if (loginService.login(this.loginModel)) {
                profileMain.start(stage);
        }



    }

    public void register(Stage stage,RegisterMain registerMain) {
        registerMain.start(stage);
    }
}
