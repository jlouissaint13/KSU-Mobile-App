package com.ksumobileapp.Registration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ScrollBar;
import java.awt.*;

public class RegisterView {
private Stage stage;
private Pane pane;
private TextField fName,lName,email,phone,password,gender,dob;
private Text fnameT,lnameT,emailT,phoneT,passwordT,genderT,dobT,classificationT,majorT,register;
private VBox vbox;
private ScrollPane scrollPane;
 private ObservableList<String> options;
 private ComboBox classification,major;
 ;
private Button registerButton;



public void components() {
    pane = new Pane();
    fName = new TextField();
    fnameT = new Text("First Name");
    lName = new TextField();
    lnameT = new Text("Last Name");
    //personalEmail
    email = new TextField();
    emailT = new Text("Email");
    password = new TextField();
    passwordT = new Text();
    passwordT.setText("Password");
    phone = new TextField();
    phoneT = new Text("Phone");
    dob = new TextField();
    dobT = new Text("Date of Birth");
    classificationT = new Text("Classification");
    vbox = new VBox();
    majorT = new Text("Major");
    register = new Text("Registration");
    registerButton = new Button("Register");
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

email.setLayoutX(30);
email.setLayoutY(220);
emailT.setLayoutX(30);
emailT.setLayoutY(210);

password.setLayoutX(30);
password.setLayoutY(280);
passwordT.setLayoutX(30);
passwordT.setLayoutY(270);

phone.setLayoutX(30);
phone.setLayoutY(340);
phoneT.setLayoutX(30);
phoneT.setLayoutY(330);

dob.setLayoutX(30);
dob.setLayoutY(400);
dobT.setLayoutX(30);
dobT.setLayoutY(390);

classification.setLayoutX(30);
classification.setLayoutY(460);
classificationT.setLayoutX(30);
classificationT.setLayoutY(450);

major.setLayoutX(30);
major.setLayoutY(520);
majorT.setLayoutX(30);
majorT.setLayoutY(510);

register.setLayoutX(145);
register.setLayoutY(40);

registerButton.setLayoutX(145);
registerButton.setLayoutY(600);



}
public void addComponents() {

    pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,
        fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT,register,registerButton,password,passwordT);
    vbox = new VBox();
    vbox.getChildren().add(pane);
    scrollPane = new ScrollPane(vbox);
    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

    vbox.setPrefHeight(650);
    scrollPane.setMaxHeight(10);
}


public RegisterView(Stage stage) {
    components();
    properties();
    addComponents();
    stage.setTitle("Registration");
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
        return dob.getText();
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
}
