package com.ksumobileapp.Profile;

import com.ksumobileapp.Login.LoginMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfileController {
    private ProfileView profileView;
    private Stage stage;
    private Button backButton;
    private LoginMain loginMain;
    public ProfileController(Stage stage, ProfileView profileView) {
        this.profileView = profileView;
        loginMain = new LoginMain();
        backButton = profileView.getBackButton();

        backButton.setOnAction(e-> back(stage,loginMain));
    }


    public void back(Stage stage,LoginMain loginMain) {
        loginMain.start(stage);
    }
}
