package com.ksumobileapp.AdminReview;


import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Personal.PersonalModel;
import com.ksumobileapp.Registration.RegisterModel;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminUpdateView {
    private Stage stage;
    private Pane pane;
    private TextField fName,lName,email,phone,password,address,username,campusEmail,studentID,status;
    private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT, personalInfoText,raceT,
            addressT,campusEmailT,usernameT,studentIDT,statusT;
    private PauseTransition pause;
    private VBox vbox;
    private ScrollPane scrollPane;
    private DatePicker dob;
    private LoginModel loginModel;
    private RegisterModel registerModel;
    private PersonalModel personalModel;
    private ObservableList<String> options;
    private ComboBox classification,major,race,gender;
    private Button updateProfile;
    private Button backButton;


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
        personalInfoText = new Text("Student Information");
        updateProfile = new Button("Update Profile");
        backButton = new Button("<");
        studentID = new TextField();
        studentIDT = new Text("Student ID");
        status = new TextField();
        statusT = new Text("Application Status");
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

    public void properties() {
        fName.setLayoutX(30);
        fName.setLayoutY(100);

        fnameT.setLayoutX(30);
        fnameT.setLayoutY(90);

        lName.setLayoutX(30);
        lName.setLayoutY(160);

        lnameT.setLayoutX(30);
        lnameT.setLayoutY(150);


        studentID.setLayoutX(30);
        studentID.setLayoutY(220);

        studentIDT.setLayoutX(30);
        studentIDT.setLayoutY(210);

        campusEmail.setLayoutX(30);
        campusEmail.setLayoutY(280);
        campusEmailT.setLayoutX(30);
        campusEmailT.setLayoutY(270);

        username.setLayoutX(30);
        username.setLayoutY(340);

        usernameT.setLayoutX(30);
        usernameT.setLayoutY(330);

        phone.setLayoutX(30);
        phone.setLayoutY(400);
        phoneT.setLayoutX(30);
        phoneT.setLayoutY(390);

        email.setLayoutX(30);
        email.setLayoutY(460);

        emailT.setLayoutX(30);
        emailT.setLayoutY(450);

        password.setLayoutX(30);
        password.setLayoutY(520);
        password.setEditable(true);
        passwordT.setLayoutX(30);
        passwordT.setLayoutY(510);

        address.setLayoutX(30);
        address.setLayoutY(580);
        address.setEditable(true);
        addressT.setLayoutX(30);
        addressT.setLayoutY(570);

        gender.setLayoutX(30);
        gender.setLayoutY(640);

        genderT.setLayoutX(30);
        genderT.setLayoutY(630);

        race.setLayoutX(30);
        race.setLayoutY(700);
        raceT.setLayoutX(30);
        raceT.setLayoutY(690);

        dob.setLayoutX(30);
        dob.setLayoutY(760);
        dobT.setLayoutX(30);
        dobT.setLayoutY(750);


        classification.setLayoutX(30);
        classification.setLayoutY(820);
        classificationT.setLayoutX(30);
        classificationT.setLayoutY(810);


        major.setLayoutX(30);
        major.setLayoutY(880);
        majorT.setLayoutX(30);
        majorT.setLayoutY(870);

        status.setLayoutX(30);
        status.setLayoutY(940);
        statusT.setLayoutX(30);
        statusT.setLayoutY(930);
        status.setEditable(false);

        personalInfoText.setLayoutX(145);
        personalInfoText.setLayoutY(20);

        updateProfile.setLayoutX(145);
        updateProfile.setLayoutY(1000);
        backButton.setLayoutX(20);
        backButton.setLayoutY(20);

    }

    public void addComponents() {

        pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
                fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT, personalInfoText, updateProfile,
                password,passwordT,race,raceT, gender, genderT,address,addressT,backButton,campusEmail,campusEmailT,username,usernameT,studentID,studentIDT,status,statusT);
        vbox = new VBox();
        vbox.getChildren().add(pane);
        scrollPane = new ScrollPane(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        vbox.setPrefHeight(1100);
        scrollPane.setMaxHeight(10);
    }


    public AdminUpdateView(Stage stage) {
        components();
        properties();
        addComponents();
        stage.setTitle("Change Information");
        Scene scene1 = new Scene(scrollPane,350,600);
        scene1.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene1);
        stage.show();

    }
    public void setInformation(AdminReviewModel adminReviewModel) {
        studentID.setText(adminReviewModel.getStudentID());
        fName.setText(adminReviewModel.getFirstName());
        lName.setText(adminReviewModel.getLastName());
        phone.setText(adminReviewModel.getPhone());
        campusEmail.setText(adminReviewModel.getCampusEmail());
        username.setText(adminReviewModel.getUsername());
        email.setText(adminReviewModel.getPersonalEmail());
        password.setText(adminReviewModel.getPassword());
        address.setText(adminReviewModel.getAddress());
        gender.setValue(adminReviewModel.getGender());
        race.setValue(adminReviewModel.getRace());
        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(adminReviewModel.getDob(), customDateTimeFormatter);
        dob.setValue(dateOfBirth);
        classification.setValue(adminReviewModel.getClassification());
        major.setValue(adminReviewModel.getMajor());
        status.setText(adminReviewModel.getStatus());
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
    public String getStatus() {
        return status.getText();
    }
    public String getDob() {
        return dob.getValue().toString();
    }
    public String getCampusEmail() {
        return campusEmail.getText();
    }
    public String getUsername() {
        return username.getText();

    }
    public String getPersonalEmail() {
        return email.getText();
    }
    public Button getUpdateProfile() {
        return updateProfile;
    }
    public Button getBackButton() {
        return backButton;
    }

    public boolean isEmptyCheck() {
        String data[] = new String[14];
    data[0] = fName.getText();
    data[1] = lName.getText();
    data[2] = studentID.getText();
    data[3] = campusEmail.getText();
    data[4] = username.getText();
    data[5] = phone.getText();
    data[6] = email.getText();
    data[7] = password.getText();
    data[8] = address.getText();
    data[9] = gender.getValue().toString();
    data[10] = race.getValue().toString();
    data[11] = dob.getValue().toString();
    data[12] = classification.getValue().toString();
    data[13] = major.getValue().toString();
    for (int i = 0;i<data.length;i++) {
        if (data[i].isBlank() || data[i] == null) {
            return true;
        }
    }
    return false;
    }
    public void fieldsEmpty () {
        Text inputValidation = new Text("Please Complete All Fields!");
        pane.getChildren().add(inputValidation);
        inputValidation.setLayoutX(150);
        inputValidation.setLayoutY(1040);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(inputValidation));
        pause.play();
    }

}

