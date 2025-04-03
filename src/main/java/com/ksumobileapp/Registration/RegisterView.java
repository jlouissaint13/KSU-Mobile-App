package com.ksumobileapp.Registration;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterView {
private Stage stage;
private Pane pane;
private TextField fName,lName,email,phone,dob,classification,major;
private Text fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT,register;
public void components() {
    pane = new Pane();
    fName = new TextField();
    fnameT = new Text("First Name");
    lName = new TextField();
    lnameT = new Text("Last Name");
    //personalEmail
    email = new TextField();
    emailT = new Text("Email");
    phone = new TextField();
    phoneT = new Text("Phone");
    dob = new TextField();
    dobT = new Text("Date of Birth");
    classification = new TextField();
    classificationT = new Text("Classification");
    major = new TextField();
    majorT = new Text("Major");
    register = new Text("Registration");

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
email.setLayoutX(30);
email.setLayoutY(220);
emailT.setLayoutX(30);
emailT.setLayoutY(210);
phone.setLayoutX(30);
phone.setLayoutY(280);
phoneT.setLayoutX(30);
phoneT.setLayoutY(270);
dob.setLayoutX(30);
dob.setLayoutY(340);
dobT.setLayoutX(30);
dobT.setLayoutY(330);
classification.setLayoutX(30);
classification.setLayoutY(400);
classificationT.setLayoutX(30);
classificationT.setLayoutY(390);
major.setLayoutX(30);
major.setLayoutY(460);
majorT.setLayoutX(30);
majorT.setLayoutY(450);
register.setLayoutX(145);
register.setLayoutY(40);
}
public void addComponents() {
pane.getChildren().addAll(fName,lName,email,phone,dob,classification,major,fnameT,lnameT,emailT,phoneT,dobT,classificationT,majorT,register);

}
//
public RegisterView(Stage stage) {
    components();
    properties();
    addComponents();
    stage.setTitle("Registration");
    Scene scene1 = new Scene(pane,350,600);

    stage.setScene(scene1);
    stage.show();

}
}
