package com.ksumobileapp.Registration;

import com.ksumobileapp.Login.LoginMain;
import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Profile.ProfileMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RegisterController {
    private RegisterView registerView;
    private RegisterModel registerModel;
    private RegisterService registerService;
    private Button registerButton,backButton;
    private LoginMain main;
    private ProfileMain profileMain;
    private LoginModel loginModel;
    public RegisterController(Stage stage,RegisterView registerView,RegisterService registerService,RegisterModel registerModel) {
        this.registerView = registerView;
        this.registerService = registerService;
        this.registerModel = registerModel;
        this.profileMain = new ProfileMain();
        LoginMain loginMain = new LoginMain();
        registerButton = registerView.getRegisterButton();
        backButton = registerView.getBackButton();


        registerButton.setOnAction(e -> {


            try {
                register(stage,loginMain);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        backButton.setOnAction(e -> back(stage,loginMain));
    }



    public void register(Stage stage,LoginMain loginMain) throws SQLException {
                if (registerService.comboBoxCheck(registerView)) {
                    registerView.fieldsEmpty();
                    return;
                }

        this.registerModel.setAll(
                registerView.getfName().trim(),
                registerView.getlName().trim(),
                registerView.getPhone().trim(),
                registerView.getEmail().trim(),
                registerView.getPassword().trim(),
                registerView.getAddress().trim(),
                registerView.getGender().trim(),
                registerView.getRace().trim(),
                registerView.getDOB().trim(),
                registerView.getClassification().trim(),
                registerView.getMajor().trim()
        );
/*
        this.registerModel.setAll(
                "Jared",
                "Louissaint",
                "5551234567",
                "jared1@gmail.com",
                "password",
                "125 blane lane",
                "Male",
                "Black",
                "05/10/2002",
                "Senior",
                "Computer Science"
        );

*/

        this.registerModel.setData();

        switch (this.registerService.formValid(this.registerModel)) {
            case 0 -> {
                registerView.fieldsEmpty();
                return;
            }
            case 1 -> {
                registerView.invalidEmail();
                return;
            }
            case 2 -> {
                registerView.invalidPhone();
                return;
            }
            case 3 -> {
                registerView.invalidDOB();
                return;
            }
            case 4 -> {
                registerView.emailExists();
                return;
            }
            case 5 -> {
                registerView.phoneExists();
                return;
            }
        }

        registerService.databaseConnection(this.registerModel);
        profileMain.start(stage);
    }


    public void back(Stage stage,LoginMain loginMain) {
        loginMain.start(stage);
    }
}

