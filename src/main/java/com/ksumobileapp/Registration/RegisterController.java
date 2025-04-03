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
        registerButton = registerView.getRegisterButton();



        registerButton.setOnAction(e -> register());
    }


    public void register() {
        this.registerModel = new RegisterModel(
                registerView.getfName().trim(),
                registerView.getlName().trim(),
                registerView.getEmail().trim(),
                registerView.getPhone().trim()
                ,registerView.getDOB().trim(),
                registerView.getClassification().trim(),
                registerView.getMajor().trim());
        registerService.registerUser(this.registerModel);
    }
}

