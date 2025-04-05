package com.ksumobileapp.Personal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

public class PersonalView {
    private Stage stage;
    private Pane pane;
    private TextField fName,lName,email,phone,password,address,username,campusEmail;
    private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT, personalInfoText,raceT,addressT,campusEmailT,usernameT;
    private VBox vbox;
    private ScrollPane scrollPane;
    private DatePicker dob;

    private ObservableList<String> options;
    private ComboBox classification,major,race,gender;
    ;
    private Button registerButton,backButton;



    public void components() {
        pane = new Pane();
        fName = new TextField();
        fnameT = new Text("First Name");
        lName = new TextField();
        lnameT = new Text("Last Name");

        username = new TextField();
        campusEmail = new TextField();
        usernameT = new Text("Username");
        campusEmailT = new Text("Student Email");
        email = new TextField();
        emailT = new Text("Personal Email");
        password = new TextField();
        passwordT = new Text();
        passwordT.setText("Password");
        phone = new TextField();
        phoneT = new Text("Phone Number");
        dobT = new Text("Date of Birth");
        address = new TextField();
        addressT = new Text("Address");
        classificationT = new Text("Classification");
        gender = new ComboBox();
        genderT = new Text("Gender");
        raceT = new Text("Race");
        vbox = new VBox();
        majorT = new Text("Major");
        personalInfoText = new Text("Personal Information");
        registerButton = new Button("Save Changes");
        backButton = new Button("<-");
        options =
                FXCollections.observableArrayList(
                        "Freshman",
                        "Sophomore",
                        "Junior",
                        "Senior"
                );
        classification = new ComboBox(options);
        options =
                FXCollections.observableArrayList(
                        "Computer Science"
                );
        major = new ComboBox(options);
        options = FXCollections.observableArrayList(
                "American Indian or Alaska Native",
                "Asian",
                "Black or African American",
                "Native Hawaiian or Other Pacific Islander",
                "White",
                "Other"
        );
        race = new ComboBox<>(options);
        options = FXCollections.observableArrayList(
                "Male",
                "Female",
                "Non-binary",
                "Transgender",
                "Other"
        );
        gender = new ComboBox(options);
        dob = new DatePicker();
    }
//everything aligned with t stands for text

    public void properties() {
        fName.setLayoutX(30);
        fName.setLayoutY(100);
        fName.setText("Jared");
        fName.setEditable(false);
        fnameT.setLayoutX(30);
        fnameT.setLayoutY(90);

        lName.setLayoutX(30);
        lName.setLayoutY(160);
        lName.setEditable(false);
        lnameT.setLayoutX(30);
        lnameT.setLayoutY(150);

        campusEmail.setLayoutX(30);
        campusEmail.setLayoutY(220);
        campusEmail.setEditable(false);
        campusEmailT.setLayoutX(30);
        campusEmailT.setLayoutY(210);

        username.setLayoutX(30);
        username.setLayoutY(280);
        username.setEditable(false);
        usernameT.setLayoutX(30);
        usernameT.setLayoutY(270);

        phone.setLayoutX(30);
        phone.setLayoutY(340);
        phoneT.setLayoutX(30);
        phoneT.setLayoutY(330);

        email.setLayoutX(30);
        email.setLayoutY(400);

        emailT.setLayoutX(30);
        emailT.setLayoutY(390);

        password.setLayoutX(30);
        password.setLayoutY(460);
        password.setEditable(true);
        passwordT.setLayoutX(30);
        passwordT.setLayoutY(450);

        address.setLayoutX(30);
        address.setLayoutY(520);
        address.setEditable(true);
        addressT.setLayoutX(30);
        addressT.setLayoutY(510);

        gender.setLayoutX(30);
        gender.setLayoutY(580);
        gender.setValue("Male");
        gender.setEditable(false);
        genderT.setLayoutX(30);
        genderT.setLayoutY(570);

        race.setLayoutX(30);
        race.setLayoutY(640);
        race.setEditable(false);
        raceT.setLayoutX(30);
        raceT.setLayoutY(630);

        dob.setLayoutX(30);
        dob.setLayoutY(700);
        dob.setEditable(false);;
        dobT.setLayoutX(30);
        dobT.setLayoutY(690);

        classification.setLayoutX(30);
        classification.setLayoutY(760);
        classification.setEditable(false);
        classificationT.setLayoutX(30);
        classificationT.setLayoutY(750);

        major.setLayoutX(30);
        major.setLayoutY(820);
        major.setEditable(false);
        majorT.setLayoutX(30);
        majorT.setLayoutY(810);

        personalInfoText.setLayoutX(145);
        personalInfoText.setLayoutY(20);

        registerButton.setLayoutX(145);
        registerButton.setLayoutY(900);
        backButton.setLayoutX(10);
        backButton.setLayoutY(25);

    }
    public void addComponents() {

        pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
                fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT, personalInfoText,registerButton,
                password,passwordT,race,raceT, gender, genderT,address,addressT,backButton,campusEmail,campusEmailT,username,usernameT);
        vbox = new VBox();
        vbox.getChildren().add(pane);
        scrollPane = new ScrollPane(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        vbox.setPrefHeight(1000);
        scrollPane.setMaxHeight(10);
    }


    public PersonalView(Stage stage) {
        components();
        properties();
        addComponents();
        stage.setTitle("Personal Information");
        Scene scene1 = new Scene(scrollPane,350,600);

        stage.setScene(scene1);
        stage.show();

    }
    //getters
    public String getfName() {
        return fName.getText();
    }
    public String getlName() {
        return lName.getText();
    }
    public String getEmail() {
        return email.getText();
    }
    public String getPassword() {
        return password.getText();
    }
    public String getPhone() {
        return phone.getText();
    }
    //TODO
    public String getDOB() {
        return dob.getValue().toString();
    }
    public String getAddress() {
        return address.getText();
    }
    public String getGender() {
        return gender.getValue().toString();
    }
    public String getRace() {
        return race.getValue().toString();
    }
    public String getClassification() {
        return classification.getValue().toString();
    }
    public String getMajor() {
        return major.getValue().toString();
    }
    public Button getRegisterButton() {
        return registerButton;
    }
    public Button getBackButton() {
        return backButton;
    }
}
