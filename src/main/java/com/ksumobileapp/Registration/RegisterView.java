package com.ksumobileapp.Registration;

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
public class RegisterView {
private Stage stage;
private Pane pane;
private TextField fName,lName,email,phone,password,address;
private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT,register,raceT,addressT;
private VBox vbox;
private ScrollPane scrollPane;
private DatePicker dob;
private PauseTransition pause;
private ObservableList<String> options;
private ComboBox classification,major,race,gender;
private Button registerButton,backButton;



public void components() {
    pane = new Pane();
    fName = new TextField();
    fnameT = new Text("First Name");
    lName = new TextField();
    lnameT = new Text("Last Name");
    //personalEmail
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
    register = new Text("Registration");
    registerButton = new Button("Register");
    backButton = new Button("<");
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
                    "Computer Science",
                    "Software Engineering"
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
fnameT.setLayoutX(30);
fnameT.setLayoutY(90);

lName.setLayoutX(30);
lName.setLayoutY(160);
lnameT.setLayoutX(30);
lnameT.setLayoutY(150);

phone.setLayoutX(30);
phone.setLayoutY(220);
phoneT.setLayoutX(30);
phoneT.setLayoutY(210);

email.setLayoutX(30);
email.setLayoutY(280);
emailT.setLayoutX(30);
emailT.setLayoutY(270);

password.setLayoutX(30);
password.setLayoutY(340);
passwordT.setLayoutX(30);
passwordT.setLayoutY(330);

address.setLayoutX(30);
address.setLayoutY(400);
addressT.setLayoutX(30);
addressT.setLayoutY(390);

gender.setLayoutX(30);
gender.setLayoutY(460);
genderT.setLayoutX(30);
genderT.setLayoutY(450);

race.setLayoutX(30);
race.setLayoutY(520);
raceT.setLayoutX(30);
raceT.setLayoutY(510);

dob.setLayoutX(30);
dob.setLayoutY(580);
dobT.setLayoutX(30);
dobT.setLayoutY(570);

classification.setLayoutX(30);
classification.setLayoutY(640);
classificationT.setLayoutX(30);
classificationT.setLayoutY(630);

major.setLayoutX(30);
major.setLayoutY(700);
majorT.setLayoutX(30);
majorT.setLayoutY(690);

register.setLayoutX(145);
register.setLayoutY(40);

//buttons
registerButton.setLayoutX(145);
registerButton.setLayoutY(780);
backButton.setLayoutX(10);
backButton.setLayoutY(25);



}
public void addComponents() {

    pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
        fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT,register,registerButton,
            password,passwordT,race,raceT, gender, genderT,address,addressT,backButton);
    vbox = new VBox();
    vbox.getChildren().add(pane);
    scrollPane = new ScrollPane(vbox);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

    vbox.setPrefHeight(850);
    scrollPane.setMaxHeight(10);
}

 public void invalidPhone() {
        Text text = new Text("Invalid Phone Number!");
        pane.getChildren().add(text);
        text.setLayoutX(150);
        text.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> pane.getChildren().remove(text));
        pause.play();
    }
    public void invalidEmail() {
        Text invalidEmail = new Text("Invalid Email!");
        pane.getChildren().add(invalidEmail);
        invalidEmail.setLayoutX(150);
        invalidEmail.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> pane.getChildren().remove(invalidEmail));
        pause.play();
    }
    public void fieldsEmpty() {
        Text inputValidation = new Text("Please Complete All Fields!");
        pane.getChildren().add(inputValidation);
        inputValidation.setLayoutX(150);
        inputValidation.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(inputValidation));
        pause.play();
    }

   public void invalidDOB() {
        Text invalidDob = new Text("Invalid Birthdate!");
        pane.getChildren().add(invalidDob);
        invalidDob.setLayoutX(150);
        invalidDob.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(invalidDob));
        pause.play();
   }
   public void phoneExists() {
        Text phoneExists = new Text("Phone Number Exists!");
        pane.getChildren().add(phoneExists);
        phoneExists.setLayoutX(150);
        phoneExists.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(phoneExists));
        pause.play();
   }
   public void emailExists() {
        Text emailExists = new Text("Email Exists!");
        pane.getChildren().add(emailExists);
        emailExists.setLayoutX(150);
        emailExists.setLayoutY(760);
        pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(e -> pane.getChildren().remove(emailExists));
        pause.play();
   }


public RegisterView(Stage stage) {
    components();
    properties();
    addComponents();
    stage.setTitle("Registration");
    Scene scene1 = new Scene(scrollPane,350,600);
    scene1.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
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
