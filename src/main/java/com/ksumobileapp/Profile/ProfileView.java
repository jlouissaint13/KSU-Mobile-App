package com.ksumobileapp.Profile;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ProfileView {
    private Pane pane;
    private Button viewInformation,editProfile,payCourses,viewCourses,recCourses,scheduleBuilder,digitalAdvisor,backButton;
    private Text profileT;
    public void components() {
    pane = new Pane();
    backButton = new Button("Log Out");
    profileT = new Text("Profile");
    viewInformation = new Button("Personal Information");
    editProfile = new Button("Change Information");
    payCourses = new Button("Pay Online");
    viewCourses = new Button("View Academic History");
    recCourses = new Button("Course Recommendations");
    scheduleBuilder = new Button("Schedule Builder");
    digitalAdvisor = new Button("Digital Advisor");
    }

    public void properties() {



        //text
        profileT.setLayoutX(140);
        profileT.setLayoutY(40);

        //buttons
        viewInformation.setLayoutX(110);
        viewInformation.setLayoutY(120);
        editProfile.setLayoutX(110);
        editProfile.setLayoutY(120);
        payCourses.setLayoutX(110);
        payCourses.setLayoutY(180);
        viewCourses.setLayoutX(110);
        viewCourses.setLayoutY(240);
        recCourses.setLayoutX(110);
        recCourses.setLayoutY(300);
        scheduleBuilder.setLayoutX(110);
        scheduleBuilder.setLayoutY(360);
        digitalAdvisor.setLayoutX(110);
        digitalAdvisor.setLayoutY(420);

        backButton.setLayoutX(110);
        backButton.setLayoutY(480);

    }


    public void addComponents() {
        pane.getChildren().addAll(viewInformation,payCourses,
                viewCourses,recCourses,scheduleBuilder,digitalAdvisor,profileT,backButton);
    }


    public ProfileView(Stage stage) {
        components();
        properties();
        addComponents();

        stage.setTitle("Profile");
        Scene scene1 = new Scene(pane,350,600);
        scene1.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene1);
        stage.show();
    }
    //getters;
    public Button getViewInformation() {
        return viewInformation;
    }
    public Button getPayCourses() {
        return payCourses;
    }
    public Button getViewCourses() {
        return viewCourses;
    }
    public Button getRecCourses() {
        return recCourses;
    }
    public Button getScheduleBuilder() {
        return scheduleBuilder;
    }
    public Button getDigitalAdvisor() {
        return digitalAdvisor;
    }
    public Button getBackButton() {
        return backButton;
    }
}