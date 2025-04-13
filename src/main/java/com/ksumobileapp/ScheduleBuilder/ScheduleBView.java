package com.ksumobileapp.ScheduleBuilder;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<Object> tableView;
    private Button enroll,unenroll,back;
    private String []info;
    public void components() {
        pane = new Pane();
        scheduleBuilder = new Text("Schedule Builder");
        enroll = new Button("Enroll");
        unenroll = new Button("Unenroll");
        tableView = new TableView<>();
        back = new Button("<");
        /*
        TableColumn<Course, String> codeCol = new TableColumn<>("Course Code");
        codeCol.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        codeCol.setPrefWidth(100);

        TableColumn<Course, String> nameCol = new TableColumn<>("Course Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        nameCol.setPrefWidth(200);

        TableColumn<Course, Integer> creditsCol = new TableColumn<>("Credit Hours");
        creditsCol.setCellValueFactory(new PropertyValueFactory<>("creditHours"));
        creditsCol.setPrefWidth(100);

        TableColumn<Course, String> prereqCol = new TableColumn<>("Prerequisites");
        prereqCol.setCellValueFactory(new PropertyValueFactory<>("prerequisites"));
        prereqCol.setPrefWidth(150);

        tableView.getColumns().addAll(codeCol, nameCol, creditsCol, prereqCol);

         */
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


        enroll.setLayoutX(130);
        enroll.setLayoutY(180);
        enroll.setPrefWidth(80);
        unenroll.setLayoutX(130);
        unenroll.setLayoutY(220);
        unenroll.setPrefWidth(80);
        back.setLayoutX(30);
        back.setLayoutY(30);

    }


    public void addComponents() {
    pane.getChildren().addAll(scheduleBuilder,subjectComboBox,selectCourse,swe,cs,cse,math,stat,tcom,it,enroll,unenroll,back);
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
    public String getCourseID(String courseName) {

        info = courseName.split(" ");
        String courseID = info[0] + " " + info[1];
        System.out.println(courseID);
        return courseID;
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
                "CSE 1321 Programming and Problem Solving I 9:00-10:30",
                "CSE 1321L Programming and Problem Solving I Laboratory 10:30-12:00",
                "CSE 1322 Programming and Problem Solving II 1:00-2:30",
                "CSE 1322L Programming and Problem Solving II Laboratory 2:30-4:00",
                "CSE 2300 Discrete Structures for Computing 9:00-10:30",
                "CSE 3153 Database Systems 3:30-5:00",
                "CSE 3801 Professional Practices and Ethics 12:00-1:30",
                "CSE 4983 CSE Computing Internship 2:00-3:30"
        );
        cse = new ComboBox(cseOptions);

        ObservableList<String> csOptions = FXCollections.observableArrayList(
                "CS 3305 Data Structures 9:30-11:00",
                "CS 3502 Operating Systems 10:30-12:00",
                "CS 3503 Computer Organization and Architecture 1:30-3:00",
                "CS 4308 Concepts of Programming Languages 3:00-4:30",
                "CS 4504 Parallel and Distributed Computing 11:00-12:30",
                "CS 4514 Real Time Systems 2:00-3:30",
                "CS 4523 Programming Massively Parallel Processors 9:00-10:30",
                "CS 4524 Cloud Computing 1:00-2:30",
                "CS 4612 Software Security 12:30-2:00",
                "CS 4622 Computer Networks 10:00-11:30",
                "CS 4632 Modeling and Simulation 1:00-2:30",
                "CS 4712 User Interface Engineering 3:30-5:00",
                "CS 4720 Internet Programming 9:30-11:00",
                "CS 4722 Computer Graphics and Multimedia 12:00-1:30",
                "CS 4732 Machine Vision 2:30-4:00"
        );
        cs = new ComboBox(csOptions);

        ObservableList<String> statOptions = FXCollections.observableArrayList(
                "STAT 2332 Probability and Data Analysis 3:30-5:00"
        );
        stat = new ComboBox(statOptions);

        ObservableList<String> itOptions = FXCollections.observableArrayList(
                "IT 4823 Information Security Administration & Privacy 1:30-3:00",
                "IT 4323 Data Communications & Networking 9:00-10:30",
                "IT 4683 Management of Information Technology and Human Computer Interaction 2:30-4:00",
                "IT 4723 IT Policy and Laws 11:00-12:30"
        );
        it = new ComboBox(itOptions);

        ObservableList<String> mathOptions = FXCollections.observableArrayList(
                "MATH 1111 College Algebra 9:00-10:30",
                "MATH 1113 Precalculus 10:30-12:00",
                "MATH 1190 Calculus I 1:00-2:30",
                "MATH 2202 Calculus II 3:00-4:30",
                "MATH 2345 Discrete Mathematics 9:30-11:00"
        );
        math = new ComboBox(mathOptions);

        ObservableList<String> tcomOptions = FXCollections.observableArrayList(
                "TCOM 2010 Technical Writing 3:30-5:00"
        );
        tcom = new ComboBox(tcomOptions);

        ObservableList<String> sweOptions = FXCollections.observableArrayList(
                "SWE 3313 Introduction to Software Engineering 9:00-10:30",
                "SWE 3623 Software Systems Requirements 10:30-12:00",
                "SWE 3633 Software Architecture and Design 1:00-2:30",
                "SWE 3643 Software Testing & Quality Assurance 2:30-4:00",
                "SWE 4324 User Centered Design 3:00-4:30",
                "SWE 4663 Software Project Management 9:00-10:30",
                "SWE 4713 SWE Application Domain 12:00-1:30",
                "SWE 4724 Software Engineering Capstone Project 3:30-5:00",
                "SWE 3683 Embedded Systems Analysis and Design 9:30-11:00",
                "SWE 4633 Cloud Software Development 10:30-12:00",
                "SWE 4723 Undergraduate Research Methods 12:30-2:00",
                "SWE 4743 Object Oriented Development 1:30-3:00",
                "SWE 4783 User Interaction Engineering 2:30-4:00",
                "SWE 4490 Special Topics 3:30-5:00",
                "SWE 4803 Independent Study 12:00-1:30"
        );
        swe = new ComboBox(sweOptions);

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
    public Button getEnroll() {
        return enroll;
    }
    public Button getUnenroll() {
        return unenroll;
    }
    public Button getBack() {
        return back;
    }


    //combobox values

    public String getcseValue() {
       return cse.getValue().toString();
    }
    public String getStatValue() {
       return stat.getValue().toString();
    }
    public String getSweValue() {
        return swe.getValue().toString();
    }
    public String getITValue() {
        return it.getValue().toString();
    }
    public String getCsValue() {
        return cs.getValue().toString();
    }
    public String getMathValue() {
        return mathComboBox.getValue().toString();
    }
    public String getTcomValue() {
        return tcom.getValue().toString();
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


