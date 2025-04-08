package com.ksumobileapp.AdminReview;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Personal.PersonalModel;
import com.ksumobileapp.Registration.RegisterModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdminReviewView {
    private Stage stage;
    private Pane pane;
    private TextField fName,lName,email,phone,password,address,username,campusEmail,studentID,status;
    private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT, personalInfoText,raceT,
            addressT,campusEmailT,usernameT,studentIDT,statusT;
    private VBox vbox;
    private ScrollPane scrollPane;
    private DatePicker dob;
    private LoginModel loginModel;
    private RegisterModel registerModel;
    private PersonalModel personalModel;

    private ObservableList<String> options;
    private ComboBox classification,major,race,gender;
    private Button acceptButton,backButton,denyButton;



    public void components() {
        pane = new Pane();
        fName = new TextField();
        fnameT = new Text("First Name");
        lName = new TextField();
        lnameT = new Text("Last Name");

        username = new TextField();
        username.setEditable(false);
        campusEmail = new TextField();
        campusEmail.setEditable(false);
        usernameT = new Text("Username");
        campusEmailT = new Text("Student Email");
        email = new TextField();
        email.setEditable(false);
        emailT = new Text("Personal Email");
        password = new TextField();
        password.setEditable(false);
        passwordT = new Text();
        passwordT.setText("Password");
        phone = new TextField();
        phone.setEditable(false);
        phoneT = new Text("Phone Number");
        dobT = new Text("Date of Birth");
        address = new TextField();
        address.setEditable(false);
        addressT = new Text("Address");
        classificationT = new Text("Classification");
        gender = new ComboBox();
        genderT = new Text("Gender");
        raceT = new Text("Race");
        vbox = new VBox();
        majorT = new Text("Major");
        personalInfoText = new Text("Student Application");
        acceptButton = new Button("Accept");
        denyButton = new Button("Reject");
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
//everything aligned with t stands for text

    public void properties() {
        fName.setLayoutX(30);
        fName.setLayoutY(100);
        fName.setEditable(false);
        fnameT.setLayoutX(30);
        fnameT.setLayoutY(90);

        lName.setLayoutX(30);
        lName.setLayoutY(160);
        lName.setEditable(false);
        lnameT.setLayoutX(30);
        lnameT.setLayoutY(150);


        studentID.setLayoutX(30);
        studentID.setLayoutY(220);
        studentID.setEditable(false);
        studentIDT.setLayoutX(30);
        studentIDT.setLayoutY(210);

        campusEmail.setLayoutX(30);
        campusEmail.setLayoutY(280);
        campusEmailT.setLayoutX(30);
        campusEmailT.setLayoutY(270);
        campusEmail.setEditable(false);
        username.setLayoutX(30);
        username.setLayoutY(340);
        username.setEditable(false);
        usernameT.setLayoutX(30);
        usernameT.setLayoutY(330);

        phone.setLayoutX(30);
        phone.setLayoutY(400);
        phoneT.setLayoutX(30);
        phoneT.setLayoutY(390);
        phone.setEditable(false);
        email.setLayoutX(30);
        email.setLayoutY(460);
        email.setEditable(false);
        emailT.setLayoutX(30);
        emailT.setLayoutY(450);

        password.setLayoutX(30);
        password.setLayoutY(520);
        password.setEditable(false);
        passwordT.setLayoutX(30);
        passwordT.setLayoutY(510);

        address.setLayoutX(30);
        address.setLayoutY(580);
        address.setEditable(false);
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

        acceptButton.setLayoutX(145);
        acceptButton.setLayoutY(1000);
        denyButton.setLayoutX(145);
        denyButton.setLayoutY(1035);
        backButton.setLayoutX(20);
        backButton.setLayoutY(20);

    }

    public void addComponents() {

        pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
                fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT, personalInfoText, acceptButton,denyButton,
                password,passwordT,race,raceT, gender, genderT,address,addressT,backButton,campusEmail,campusEmailT,username,usernameT,studentID,studentIDT,status,statusT);
        vbox = new VBox();
        vbox.getChildren().add(pane);
        scrollPane = new ScrollPane(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        vbox.setPrefHeight(1100);
        scrollPane.setMaxHeight(10);
    }


    public AdminReviewView(Stage stage) {
        components();
        properties();
        addComponents();
        stage.setTitle("Admin Review Page");
        Scene scene1 = new Scene(scrollPane,350,600);

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
        gender.setDisable(true);
        race.setValue(adminReviewModel.getRace());
        race.setDisable(true);
        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(adminReviewModel.getDob(), customDateTimeFormatter);
        dob.setValue(dateOfBirth);
        dob.setDisable(true);
        classification.setValue(adminReviewModel.getClassification());
        classification.setDisable(true);
        major.setValue(adminReviewModel.getMajor());
        major.setDisable(true);
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
    public Button getAcceptButton() {
        return acceptButton;
    }
    public Button getBackButton() {
        return backButton;
    }
    public Button getDenyButton() {return denyButton;}
}
