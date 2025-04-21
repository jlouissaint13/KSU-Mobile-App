package com.ksumobileapp.StudentLookup;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class StudentLookupView {

    private Text lookup;
    private TextField studentID;
    private Pane pane;
    private Button search,logout;
    public StudentLookupView(Stage stage) {
        lookup = new Text("Please Enter the Student ID");
        studentID = new TextField();
        search = new Button("Search");
        logout = new Button("Log Out");
        studentID.setLayoutX(100);
        studentID.setLayoutY(300);

        lookup.setLayoutX(100);
        lookup.setLayoutY(290);
        search.setLayoutX(100);
        search.setLayoutY(340);
        logout.setLayoutX(100);
        logout.setLayoutY(370);


        pane = new Pane();
        pane.getChildren().addAll(lookup,search,studentID,logout);
        stage.setTitle("Student Lookup");
        Scene scene1 = new Scene(pane,350,600);
        scene1.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene1);
        stage.show();
    }
    public String getStudentID() {
        return studentID.getText();
    }
    public Button getSearch() {
        return search;
    }
    public Button getLogout() {
        return logout;
    }
    public void displayNullValue() {
        Text passwordInv = new Text("Please Enter A StudentID!");
        PauseTransition pause = new PauseTransition();
        pane.getChildren().add(passwordInv);
        passwordInv.setLayoutX(100);
        passwordInv.setLayoutY(420);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(passwordInv));
        pause.play();
    }
    public void displayIDDoesNotExits() {
        Text passwordInv = new Text("StudentID Not Found");
        PauseTransition pause = new PauseTransition();
        pane.getChildren().add(passwordInv);
        passwordInv.setLayoutX(100);
        passwordInv.setLayoutY(420);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(passwordInv));
        pause.play();
    }
}
