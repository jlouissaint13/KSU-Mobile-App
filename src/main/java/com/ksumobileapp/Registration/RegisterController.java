package com.ksumobileapp.Registration;

import com.ksumobileapp.Login.LoginMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RegisterController {
    private RegisterView registerView;
    private RegisterModel registerModel;
    private RegisterService registerService;
    private Button registerButton;
    private LoginMain main;
    public RegisterController(Stage stage,RegisterView registerView,RegisterService registerService,RegisterModel registerModel) {
        this.registerView = registerView;
        this.registerService = registerService;
        this.registerModel = registerModel;
        LoginMain loginMain = new LoginMain();
        registerButton = registerView.getRegisterButton();



        registerButton.setOnAction(e -> {


            try {
                register(stage,loginMain);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    public void register(Stage stage,LoginMain loginMain) throws SQLException {
       /* this.registerModel.setAll(
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

        */
        this.registerModel.setAll(
                "Jared",
                "Louissaint",
                "5551234567",
                "jared@gmail.com",
                "password",
                "125 blane lane",
                "Male",
                "Black",
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
        loginMain.start(stage);
    }
}

