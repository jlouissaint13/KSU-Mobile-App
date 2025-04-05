package com.ksumobileapp.Personal;

import com.ksumobileapp.Profile.ProfileMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonalController {
    private Stage stage;
    private PersonalView personalView;
    private Button backButton;
    private ProfileMain profileMain;
    public PersonalController(Stage stage,PersonalView personalView) {
        this.personalView = personalView;
        profileMain = new ProfileMain();
        backButton = this.personalView.getBackButton();

        backButton.setOnAction(e-> back(stage,profileMain));
    }

    public void back(Stage stage,ProfileMain profileMain) {
        profileMain.start(stage);
    }


}
