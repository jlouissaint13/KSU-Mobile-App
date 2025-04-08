package com.ksumobileapp.Admin;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class AdminView {
    private Pane pane;
    private Button reviewApplications,logout,updateProfile,deleteAccount;
    private AdminModel adminModel;
    private Text adminPage,currentStudentID;
    public void components() {
    pane = new Pane();
    adminModel = new AdminModel();
    reviewApplications = new Button("Review Application");
    logout = new Button("<");
    adminPage = new Text("Admin");
    updateProfile = new Button("Update Profile");
    deleteAccount = new Button("Delete Account");
    currentStudentID = new Text("Current StudentID: " + adminModel.getStudentID());
    }

    public void properties() {
    reviewApplications.setLayoutX(100);
    reviewApplications.setLayoutY(300);
    updateProfile.setLayoutX(100);
    updateProfile.setLayoutY(340);
    deleteAccount.setLayoutX(100);
    deleteAccount.setLayoutY(380);
    logout.setLayoutX(20);
    logout.setLayoutY(20);
    adminPage.setLayoutX(160);
    adminPage.setLayoutY(50);
    currentStudentID.setLayoutX(100);
    currentStudentID.setLayoutY(200);
    adminPage.setLayoutY(100);



    }
    public void addComponents() {
        pane.getChildren().addAll(reviewApplications,logout,adminPage,updateProfile,deleteAccount,currentStudentID);
    }







    public AdminView(Stage stage) {
        components();
        properties();
        addComponents();

        stage.setTitle("Admin Homepage");
        Scene scene1 = new Scene(pane,350,600);

        stage.setScene(scene1);
        stage.show();
    }




    public Button getReviewButton() {
        return reviewApplications;
    }
    public Button getUpdateProfileButton() {
        return updateProfile;
    }
    public Button getDeleteAccount() {return deleteAccount;}
    public Button getLogout() {
        return logout;
    }
}
