package com.ksumobileapp.ScheduleBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class ScheduleBView {
    private Pane pane;
    private ObservableList<String> cseOptions,csOptions,itOptions;
    private ComboBox cse,cs,stat,math,it;
    private ObservableList<String> statOptions;
    private ComboBox<String> mathComboBox;
    private ComboBox<String> subjectComboBox;
    private ComboBox<String> tcomComboBox;
    private Text scheduleBuilder;
    private ComboBox<String> selectCourse;

    public void components() {
        pane = new Pane();
        scheduleBuilder = new Text("Schedule Builder");
    }


    public void properties() {
        scheduleBuilder.setLayoutX(120);
        scheduleBuilder.setLayoutY(80);

        subjectComboBox.setPromptText("Select Subject");
        subjectComboBox.setMaxWidth(200);
        subjectComboBox.setLayoutX(65);
        subjectComboBox.setLayoutY(100);

        selectCourse.setPromptText("Select Course");
        selectCourse.setDisable(true);
        selectCourse.setLayoutX(65);
        selectCourse.setLayoutY(140);
        selectCourse.setMinWidth(200);


        cse.setLayoutX(30);
        cse.setLayoutY(100);
        cse.setMaxWidth(200);


    }


    public void addComponents() {
    pane.getChildren().addAll(scheduleBuilder,subjectComboBox,selectCourse);
    }

    public ScheduleBView(Stage stage) {

        comboBoxes();
        components();
        properties();
        addComponents();

        stage.setTitle("Schedule Builder");
        Scene scene1 = new Scene(pane,350,600);

        stage.setScene(scene1);
        stage.show();
    }


    public void comboBoxes() {
        ObservableList<String> filler = FXCollections.observableArrayList(
                " "
        );
        selectCourse = new ComboBox<>(filler);
        ObservableList<String> subjectOptions = FXCollections.observableArrayList(
                "CSE-Computer Science and Engineering",
                "CS-Computer Science",
                "SWE-Software Engineering",
                "MATH-Mathematics",
                "STAT-Statistics",
                "IT-Information Technology",
                "TCOM-Technical Communication"
        );
        subjectComboBox = new ComboBox<>(subjectOptions);
        ObservableList<String> cseOptions = FXCollections.observableArrayList(
                "CSE 1321 Programming and Problem Solving I",
                "CSE 1321L Programming and Problem Solving I Laboratory",
                "CSE 1322 Programming and Problem Solving II",
                "CSE 1322L Programming and Problem Solving II Laboratory",
                "CSE 2300 Discrete Structures for Computing",
                "CSE 3153 Database Systems",
                "CSE 3801 Professional Practices and Ethics",
                "CSE 4983 CSE Computing Internship"
        );
         cse = new ComboBox<>(cseOptions);
         csOptions = FXCollections.observableArrayList(
                "CS 3305 Data Structures",
                "CS 3502 Operating Systems",
                "CS 3503 Computer Organization and Architecture",
                "CS 4308 Concepts of Programming Languages",
                "CS 4504 Parallel and Distributed Computing",
                "CS 4514 Real-Time Systems",
                "CS 4523 Programming Massively Parallel Processors",
                "CS 4524 Cloud Computing",
                "CS 4612 Software Security",
                "CS 4622 Computer Networks",
                "CS 4632 Modeling and Simulation",
                "CS 4712 User Interface Engineering",
                "CS 4720 Internet Programming",
                "CS 4722 Computer Graphics and Multimedia",
                "CS 4732 Machine Vision"
        );

        cs = new ComboBox<>(csOptions);
        statOptions = FXCollections.observableArrayList(
                "STAT 2332 Probability and Data Analysis"
        );

         stat = new ComboBox<>(statOptions);
        ObservableList<String> itOptions = FXCollections.observableArrayList(
                "IT 4823 Information Security Administration & Privacy"
        );

         it = new ComboBox<>(itOptions);
        ObservableList<String> mathOptions = FXCollections.observableArrayList(
                "MATH 1111 College Algebra",
                "MATH 1113 Precalculus",
                "MATH 1190 Calculus I",
                "MATH 2202 Calculus II",
                "MATH 2345 Discrete Mathematics"
        );

       mathComboBox = new ComboBox<>(mathOptions);
        ObservableList<String> tcomOptions = FXCollections.observableArrayList(
                "TCOM 2010 Technical Writing"
        );

        tcomComboBox = new ComboBox<>(tcomOptions);

    }


    public void selectSubject() {



    }
    public String returnSubject() {
        return subjectComboBox.getValue();
    }


    }

