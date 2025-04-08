package com.ksumobileapp.Personal;

import com.ksumobileapp.Login.LoginModel;
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

public class PersonalView {
    private Stage stage;
    private Pane pane;
    private TextField fName,lName,email,phone,password,address,username,campusEmail,studentID,status;
    private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT, personalInfoText,raceT,addressT,campusEmailT,usernameT,studentIDT,statusT;
    private VBox vbox;
    private ScrollPane scrollPane;
    private DatePicker dob;
    private LoginModel loginModel;
    private RegisterModel registerModel;
    private PersonalModel personalModel;

    private ObservableList<String> options;
    private ComboBox classification,major,race,gender;
    ;
    private Button updateButton,backButton;



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
        updateButton = new Button("Save Changes");
        backButton = new Button("<");
        studentID = new TextField();
        studentIDT = new Text("Student ID");
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
        status = new TextField();
        statusT = new Text("Application Status");
    }
//everything aligned with t stands for text

    public void properties() {
        fName.setLayoutX(30);
        fName.setLayoutY(100);
        fName.setEditable(false);
        fName.setDisable(true);
        fnameT.setLayoutX(30);
        fnameT.setLayoutY(90);

        lName.setLayoutX(30);
        lName.setLayoutY(160);
        lName.setEditable(false);
        lName.setDisable(true);
        lnameT.setLayoutX(30);
        lnameT.setLayoutY(150);


        studentID.setLayoutX(30);
        studentID.setLayoutY(220);
        studentID.setEditable(false);
        studentID.setDisable(true);
        studentIDT.setLayoutX(30);
        studentIDT.setLayoutY(210);

        campusEmail.setLayoutX(30);
        campusEmail.setLayoutY(280);
        campusEmail.setEditable(false);
        campusEmailT.setLayoutX(30);
        campusEmailT.setLayoutY(270);

        username.setLayoutX(30);
        username.setLayoutY(340);
        username.setEditable(false);
        username.setDisable(true);
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
        gender.setEditable(false);
        gender.setDisable(true);
        genderT.setLayoutX(30);
        genderT.setLayoutY(630);

        race.setLayoutX(30);
        race.setLayoutY(700);
        race.setEditable(false);
        race.setDisable(true);
        raceT.setLayoutX(30);
        raceT.setLayoutY(690);

        dob.setLayoutX(30);
        dob.setLayoutY(760);
        dob.setEditable(false);
        dob.setDisable(true);
        dobT.setLayoutX(30);
        dobT.setLayoutY(750);


        classification.setLayoutX(30);
        classification.setLayoutY(820);
        classification.setEditable(false);
        classification.setDisable(true);
        classificationT.setLayoutX(30);
        classificationT.setLayoutY(810);


        major.setLayoutX(30);
        major.setLayoutY(880);
        major.setEditable(false);
        major.setDisable(true);
        majorT.setLayoutX(30);
        majorT.setLayoutY(870);

        personalInfoText.setLayoutX(145);
        personalInfoText.setLayoutY(20);

        updateButton.setLayoutX(145);
        updateButton.setLayoutY(990);
        backButton.setLayoutX(20);
        backButton.setLayoutY(20);

        status.setLayoutX(30);
        status.setLayoutY(940);
        statusT.setLayoutX(30);
        statusT.setLayoutY(930);
        status.setEditable(false);

    }
    public void setInformation(PersonalModel personalModel) {
        studentID.setText(personalModel.getStudentID());
        fName.setText(personalModel.getFirstName());
        lName.setText(personalModel.getLastName());
        phone.setText(personalModel.getPhone());
        campusEmail.setText(personalModel.getCampusEmail());
        username.setText(personalModel.getUsername());
        email.setText(personalModel.getPersonalEmail());
        password.setText(personalModel.getPassword());
        address.setText(personalModel.getAddress());
        gender.setValue(personalModel.getGender());
        race.setValue(personalModel.getRace());
        DateTimeFormatter customDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(personalModel.getDob(), customDateTimeFormatter);
        dob.setValue(dateOfBirth);
        classification.setValue(personalModel.getClassification());
        major.setValue(personalModel.getMajor());
        status.setText(personalModel.getStatus());







    }
    public void addComponents() {

        pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
                fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT, personalInfoText, updateButton,
                password,passwordT,race,raceT, gender, genderT,address,addressT,backButton,campusEmail,campusEmailT,username,usernameT,studentID,studentIDT,status,statusT);
        vbox = new VBox();
        vbox.getChildren().add(pane);
        scrollPane = new ScrollPane(vbox);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        vbox.setPrefHeight(1050);
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
    public Button getUpdateButton() {
        return updateButton;
    }
    public Button getBackButton() {
        return backButton;
    }
}
