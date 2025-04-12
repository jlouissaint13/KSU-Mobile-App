package com.ksumobileapp.ScheduleBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ScheduleBView {
    private Pane pane;
    private ObservableList<String> cseOptions,csOptions,itOptions;
    private ComboBox cse,cs,stat,math,it,tcom,swe;
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
        subjectComboBox.setPrefWidth(200);
        subjectComboBox.setLayoutX(65);
        subjectComboBox.setLayoutY(100);
        subjectComboBox.setStyle("-fx-font-size: 12.5px;");

        selectCourse.setPromptText("Select Course");
        selectCourse.setDisable(true);
        selectCourse.setLayoutX(65);
        selectCourse.setLayoutY(140);
        selectCourse.setPrefWidth(200);
        selectCourse.setStyle("-fx-font-size: 12.5px;");

        cse.setLayoutX(65);
        cse.setLayoutY(140);
        cse.setPrefWidth(200);
        cse.setPromptText("Select Course");
        cse.setStyle("-fx-font-size: 12.5px;");
        cse.setVisible(false);

        cs.setLayoutX(65);
        cs.setLayoutY(140);
        cs.setPrefWidth(200);
        cs.setPromptText("Select Course");
        cs.setStyle("-fx-font-size: 12.5px;");
        cs.setVisible(false);

        math.setLayoutX(65);
        math.setLayoutY(140);
        math.setPrefWidth(200);
        math.setPromptText("Select Course");
        math.setStyle("-fx-font-size: 12.5px;");
        math.setVisible(false);

        stat.setLayoutX(65);
        stat.setLayoutY(140);
        stat.setPrefWidth(200);
        stat.setPromptText("Select Course");
        stat.setStyle("-fx-font-size: 12.5px;");
        stat.setVisible(false);

        tcom.setLayoutX(65);
        tcom.setLayoutY(140);
        tcom.setPrefWidth(200);
        tcom.setPromptText("Select Course");
        tcom.setStyle("-fx-font-size: 12.5px;");
        tcom.setVisible(false);

        it.setLayoutX(65);
        it.setLayoutY(140);
        it.setPrefWidth(200);
        it.setPromptText("Select Course");
        it.setStyle("-fx-font-size: 12.5px;");
        it.setVisible(false);

        swe.setLayoutX(65);
        swe.setLayoutY(140);
        swe.setPrefWidth(200);
        swe.setPromptText("Select Course");
        swe.setStyle("-fx-font-size: 12.5px;");
        swe.setVisible(false);

    }


    public void addComponents() {
    pane.getChildren().addAll(scheduleBuilder,subjectComboBox,selectCourse,swe,cs,cse,math,stat,tcom,it);
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
                "IT 4823 Information Security Administration & Privacy",
                "IT 4323 Data Communications & Networking",
                "IT 4683 Management of Information Technology and Human Computer Interaction",
                "IT 4723 IT Policy and Laws",
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

       math = new ComboBox<>(mathOptions);
        ObservableList<String> tcomOptions = FXCollections.observableArrayList(
                "TCOM 2010 Technical Writing"
        );

        tcom = new ComboBox<>(tcomOptions);
        ObservableList<String> sweOptions = FXCollections.observableArrayList(
                "SWE 3313 Introduction to Software Engineering",
                "SWE 3623 Software Systems Requirements",
                "SWE 3633 Software Architecture and Design",
                "SWE 3643 Software Testing & Quality Assurance",
                "SWE 4324 User-Centered Design",
                "SWE 4663 Software Project Management",
                "SWE 4713 SWE Application Domain",
                "SWE 4724 Software Engineering Capstone Project",
                "SWE 3683 Embedded Systems Analysis and Design",
                "SWE 4633 Cloud Software Development",
                "SWE 4723 Undergraduate Research Methods",
                "SWE 4743 Object-Oriented Development",
                "SWE 4783 User Interaction Engineering",
                "SWE 4490 Special Topics",
                "SWE 4803 Independent Study"
        );

        swe = new ComboBox<>(sweOptions);
    }

    public ComboBox<String> getFillerComboBox() {
        return selectCourse;
    }
    public ComboBox<String> getSubjectComboBox() {
        return subjectComboBox;
    }
    public String returnSubject() {
        return subjectComboBox.getValue();
    }

    public ComboBox<String> getCseCombo() {
        return cse;
    }

    public ComboBox<String> getCsCombo() {
        return cs;
    }
    public ComboBox<String> getMathComboBox() {
       return math;
    }
    public ComboBox<String> getStatComboBox() {
        return stat;
    }
    public ComboBox<String> getTcomComboBox() {
        return tcom;
    }

    public ComboBox<String> getITComboBox() {
        return it;
    }
    public ComboBox<String> getSweCombo() {
        return swe;
    }

    public void setCoursesInvisible() {
        cse.setVisible(false);
        math.setVisible(false);
        stat.setVisible(false);
        it.setVisible(false);
        cs.setVisible(false);
        tcom.setVisible(false);
        swe.setVisible(false);
        selectCourse.setVisible(false);
    }



    }


