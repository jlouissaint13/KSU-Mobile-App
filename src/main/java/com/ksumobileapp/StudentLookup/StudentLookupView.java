package com.ksumobileapp.StudentLookup;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StudentLookupView {

    private Text lookup;
    private TextField studentID;
    private Pane pane;
    private Button search;
    public StudentLookupView(Stage stage) {
        lookup = new Text("Please Enter the Student ID");
        studentID = new TextField();
        search = new Button("Search");
        studentID.setLayoutX(100);
        studentID.setLayoutY(300);

        lookup.setLayoutX(100);
        lookup.setLayoutY(290);
        search.setLayoutX(100);
        search.setLayoutY(340);
        pane = new Pane();
        pane.getChildren().addAll(lookup,search,studentID);
        stage.setTitle("Student Lookup");
        Scene scene1 = new Scene(pane,350,600);

        stage.setScene(scene1);
        stage.show();
    }
    public String getStudentID() {
        return studentID.getText();
    }
    public Button getSearch() {
        return search;
    }
}
