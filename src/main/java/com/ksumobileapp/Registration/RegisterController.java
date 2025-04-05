package com.ksumobileapp.Registration;

import com.ksumobileapp.Login.LoginMain;
import com.ksumobileapp.Login.LoginService;
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
        //TODO add animations for input validation
        //input validation don't forget to move when done testing
        if (registerService.isEmpty(this.registerModel)) {
            System.out.println("Something is empty");
            return;
        }
        if (!registerService.emailValidation(this.registerModel)) {
            System.out.println("Email invalid");
            return;
        }

        if (!registerService.validPhoneNumber(registerModel)) {
            System.out.println("Invalid phone number");
            return;
        }
        //TODO undo these
        /*Undo later commented out for testing reasons
        if (registerService.ifExistsPhone(this.registerModel)) {
            System.out.println("phone exists");
            return;
        }
        if (registerService.ifExistsEmail(this.registerModel)) {
            System.out.println("email exists");
            return;
        }

         */

        registerService.databaseConnection(this.registerModel);

        profileMain.start(stage);
    }


    public void back(Stage stage,LoginMain loginMain) {
        loginMain.start(stage);
    }
}

