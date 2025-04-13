package com.ksumobileapp.ScheduleBuilder;

import com.ksumobileapp.Profile.ProfileMain;
import com.ksumobileapp.Schedule.ScheduleMain;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class SemesterMain extends Application {
private ComboBox semesterChoice;
private Button enter,back;
private Text semesterSelection;
private Pane pane;
private ScheduleBMain scheduleBMain;
    private PauseTransition pause;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        scheduleBMain = new ScheduleBMain();
        semesterSelection = new Text("Semester Selection");
        semesterSelection.setLayoutX(110);
        semesterSelection.setLayoutY(50);
        ProfileMain profileMain = new ProfileMain();
        back = new Button("<");
        back.setLayoutX(20);
        back.setLayoutY(20);
        enter = new Button("Continue");
        pane = new Pane();
        ObservableList<String> semester = FXCollections.observableArrayList(
                "Spring 2025",
                "Fall 2024",
                "Summer 2024",
                "Spring 2024",
                "Fall 2023",
                "Summer 2023",
                "Spring 2023",
                "Fall 2022",
                "Summer 2022",
                "Spring 2022",
                "Fall 2021",
                "Summer 2021",
                "Spring 2021",
                "Fall 2020"
        );
        ComboBox<String> semesterChoice = new ComboBox<>(semester);

        semesterChoice.setPromptText("Select a Semester");
        semesterChoice.setLayoutX(100);
        semesterChoice.setLayoutY(250);
        enter.setLayoutX(140);
        enter.setLayoutY(290);


        enter.setOnAction(e -> {
            try {
                CourseModel.setSemester(semesterChoice.getValue().toString());
                scheduleBMain.start(primaryStage);
            } catch (NullPointerException ex) {
                enterValue();
            }
        });

        back.setOnAction(e-> profileMain.start(primaryStage));






        pane.getChildren().addAll(semesterChoice,semesterSelection,enter,back);
        primaryStage.setTitle("Semester Selection");
        Scene scene1 = new Scene(pane,350,600);

        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    public void enterValue(){
        Text blank = new Text("Please select a semester");
        pane.getChildren().add(blank);
        blank.setLayoutX(40);
        blank.setLayoutY(350);
        pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> pane.getChildren().remove(blank));
        pause.play();
    }
}
