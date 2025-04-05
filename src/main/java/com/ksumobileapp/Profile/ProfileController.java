package com.ksumobileapp.Profile;

import com.ksumobileapp.Login.LoginMain;
import com.ksumobileapp.Personal.PersonalMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfileController {
    private ProfileView profileView;
    private Stage stage;
    private Button backButton,viewInfo;
    private LoginMain loginMain;
    private PersonalMain personalMain;
    public ProfileController(Stage stage, ProfileView profileView) {
        this.profileView = profileView;
        loginMain = new LoginMain();
        backButton = profileView.getBackButton();
        viewInfo = profileView.getViewInformation();
        personalMain = new PersonalMain();



        viewInfo.setOnAction(e -> viewInfo(stage,personalMain));

        backButton.setOnAction(e-> back(stage,loginMain));
    }


    public void back(Stage stage,LoginMain loginMain) {
        loginMain.start(stage);
    }
    public void viewInfo(Stage stage,PersonalMain personalMain) {
        personalMain.start(stage);
    }
}
