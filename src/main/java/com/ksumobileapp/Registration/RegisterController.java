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
       /* this.registerModel.setAll(
                registerView.getfName().trim(),
                registerView.getlName().trim(),
                registerView.getEmail().trim(),
                registerView.getPassword().trim(),
                registerView.getPhone().trim(),
                registerView.getDOB().trim(),
                registerView.getClassification().trim(),
                registerView.getMajor().trim()
        );

        */
        this.registerModel.setAll(
                "Jared",
                "Louissaint",
                "jared@gmail.com",
                "password",
                "5551234567",
                "05/10/2002",
                "Senior",
                "Computer Science"
        );
        //registerService.registerUser(this.registerModel);
        this.registerModel.setData();
        //input validation don't forget to move when done testing
        if (registerService.isEmpty(registerModel) == true) {
            System.out.println("Something is empty");
            return;
        }
        if (registerService.emailValidation(this.registerModel) == false) {
            System.out.println("Email invalid");
            return;
        }

        if (registerService.validPhoneNumber(registerModel) == false) {
            System.out.println("Invalid phone number");
            return;
        }
        registerService.databaseConnection(this.registerModel);
    }
}

