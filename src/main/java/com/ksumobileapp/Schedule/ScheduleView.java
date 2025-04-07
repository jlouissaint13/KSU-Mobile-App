package com.ksumobileapp.Schedule;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ScheduleView {

    private Pane pane;
    private Text scheduleT;
    private Button enroll, remove, submit, backButton;

    public void components(){
        pane = new Pane();
        enroll = new Button("Enroll");
        remove = new Button("Remove");
        submit = new Button("Submit");
        backButton = new Button("<-");
        scheduleT = new Text("Schedule Builder");
    }

    public void properties(){

        //Text
        scheduleT.setLayoutX(175);
        scheduleT.setLayoutY(75);

        //Buttons
        enroll.setLayoutX(20);
        enroll.setLayoutY(100);

        remove.setLayoutX(40);
        remove.setLayoutY(100);

        submit.setLayoutX(175);
        submit.setLayoutY(200);

        backButton.setLayoutX(5);
        backButton.setLayoutY(5);

    }

    public void addComponents(){
        pane.getChildren().addAll(enroll, remove, submit, backButton, scheduleT);
    }

    public ScheduleView(Stage stage){
        components();
        properties();
        addComponents();

        stage.setTitle("Schedule Builder");
        Scene initial = new Scene(pane, 350, 600);
        stage.setScene(initial);
        stage.show();

    }

    public Button getBackButton() {return backButton;}
    public Button getEnroll(){return enroll;}
    public Button getRemove(){return remove;}
    public Button getSubmit(){return submit;}

}
