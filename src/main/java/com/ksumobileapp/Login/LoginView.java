package com.ksumobileapp.Login;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class LoginView {
    private Pane pane;
    private TextField campusEmail;
    private Text login,campusEmailT,passwordT;
    private Button loginButton,createAccountButton;
    private PasswordField password;
    public void components() {
    pane = new Pane();
    login = new Text("Login");
    campusEmailT = new Text("Email");
    passwordT = new Text("Password");
    campusEmail = new TextField();
    password = new PasswordField();
    loginButton = new Button("Login");
    createAccountButton = new Button("Create Account");
    }


    public void properties(){
    login.setLayoutX(160);
    login.setLayoutY(80);

    campusEmail.setLayoutX(90);
    campusEmail.setLayoutY(270);
    campusEmail.setMinHeight(25);
    campusEmail.setMinWidth(160);
    campusEmailT.setLayoutX(45);
    campusEmailT.setLayoutY(285);
    password.setLayoutX(90);
    password.setLayoutY(300);
    password.setFont(Font.font(10));
    password.setMinHeight(25);
    password.setMinWidth(160);
    passwordT.setLayoutX(25);
    passwordT.setLayoutY(320);

    loginButton.setLayoutX(200);
    loginButton.setLayoutY(335);
    createAccountButton.setLayoutX(120);
    createAccountButton.setLayoutY(400);
    }


    public void addComponents() {
        pane.getChildren().addAll(login,campusEmail,password,campusEmailT,passwordT,loginButton,createAccountButton);
    }




public LoginView(Stage stage) {
    components();
    properties();
    addComponents();

    stage.setTitle("Homepage");
    Scene scene1 = new Scene(pane,350,600);

    stage.setScene(scene1);
    stage.show();
}
//all getters will be under constructor
    public String getCampusEmail() {
        return campusEmail.getText();
    }
    public String getPassword () {
        return password.getText();
    }

    public Button getLoginButton() {
        return loginButton;
    }
    public Button getCreateAccountButton() {
        return createAccountButton;
    }

}
