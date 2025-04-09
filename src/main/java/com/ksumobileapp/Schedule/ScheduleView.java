package com.ksumobileapp.Schedule;

import com.ksumobileapp.Profile.ProfileMain;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ScheduleView {

    private Pane pane;
    private Text scheduleT;
    private Button startButton, backButton;


    public void components(){
        pane = new Pane();
        startButton = new Button("Start");
        backButton = new Button("<-");
        scheduleT = new Text("Schedule Builder");

    }

    public void properties(){

        //Text
        scheduleT.setLayoutX(125);
        scheduleT.setLayoutY(50);

        //Buttons
        startButton.setLayoutX(150);
        startButton.setLayoutY(100);

        backButton.setLayoutX(5);
        backButton.setLayoutY(5);

    }

    public void addComponents(){
        pane.getChildren().addAll( startButton,backButton, scheduleT);
    }

    public ScheduleView(Stage stage){
        components();
        properties();
        addComponents();

        stage.setTitle("Schedule Builder");
        Scene initial = new Scene(pane, 350, 600);
        stage.setScene(initial);
        stage.show();

        startButton.setOnAction(e -> {
            try{
                ScheduleModel schedule = new ScheduleModel();
                Stage newStage = new Stage();
                schedule.start(newStage);

                stage.close();

            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        backButton.setOnAction(e -> {
            try{
                ProfileMain profile = new ProfileMain();
                Stage newStage = new Stage();
                profile.start(newStage);

                stage.close();

            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

    }

    public Button getBackButton() {return backButton;}


}
