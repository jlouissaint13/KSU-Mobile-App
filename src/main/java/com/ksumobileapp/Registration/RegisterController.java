package com.ksumobileapp.Registration;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RegisterController {
    private RegisterView registerView;
    private RegisterModel registerModel;
    private RegisterService registerService;
    private Button registerButton;

    public RegisterController(RegisterView registerView,RegisterService registerService,RegisterModel registerModel) {
        this.registerView = registerView;
        this.registerService = registerService;
        this.registerModel = registerModel;
        registerButton = registerView.getRegisterButton();



        registerButton.setOnAction(e -> {
            try {
                register();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    public void register() throws SQLException {
        this.registerModel.setAll(
                registerView.getfName(),
                registerView.getlName(),
                registerView.getEmail(),
                registerView.getPhone(),
                registerView.getDOB(),
                registerView.getClassification(),
                registerView.getMajor()
        );
        //registerService.registerUser(this.registerModel);
        registerService.databaseConnection(this.registerModel);
    }
}

