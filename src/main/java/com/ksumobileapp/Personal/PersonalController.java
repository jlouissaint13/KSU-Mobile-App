package com.ksumobileapp.Personal;

import com.ksumobileapp.Profile.ProfileMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PersonalController {
    private Stage stage;
    private PersonalView personalView;
    private Button backButton,updateButton;
    private ProfileMain profileMain;
    private PersonalModel personalModel;
    private PersonalService personalService;
    public PersonalController(Stage stage,PersonalView personalView,PersonalService personalService, PersonalModel personalModel) {
        profileMain = new ProfileMain();
        this.personalModel = personalModel;
        this.personalService = personalService;
        personalService.getData(this.personalModel);
        this.personalView = personalView;
        this.personalView.setInformation(this.personalModel);
        backButton = this.personalView.getBackButton();
        updateButton = this.personalView.getUpdateButton();


        backButton.setOnAction(e-> back(stage,profileMain));

        updateButton.setOnAction( e->update(stage));


    }

    public void back(Stage stage,ProfileMain profileMain) {
        profileMain.start(stage);
    }

    public void update(Stage stage) {
        personalService.updateData(this.personalView);
        profileMain.start(stage);
    }


}
