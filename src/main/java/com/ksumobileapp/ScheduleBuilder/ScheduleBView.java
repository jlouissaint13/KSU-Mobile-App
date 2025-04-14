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
    private ComboBox<String> econ;
    private ObservableList<String> englOptions;
    private ComboBox<String> hist;
    private ComboBox<String> chem;
    private ComboBox<String> phys;
    private ComboBox<String> biol;
    private ComboBox<String> engl;

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



        econ.setLayoutX(65);
        econ.setLayoutY(140);
        econ.setPrefWidth(200);
        econ.setPromptText("Select Course");
        econ.setStyle("-fx-font-size: 12.5px;");
        econ.setVisible(false);

        engl.setLayoutX(65);
        engl.setLayoutY(140);
        engl.setPrefWidth(200);
        engl.setPromptText("Select Course");
        engl.setStyle("-fx-font-size: 12.5px;");
        engl.setVisible(false);

        hist.setLayoutX(65);
        hist.setLayoutY(140);
        hist.setPrefWidth(200);
        hist.setPromptText("Select Course");
        hist.setStyle("-fx-font-size: 12.5px;");
        hist.setVisible(false);

        chem.setLayoutX(65);
        chem.setLayoutY(140);
        chem.setPrefWidth(200);
        chem.setPromptText("Select Course");
        chem.setStyle("-fx-font-size: 12.5px;");
        chem.setVisible(false);

        phys.setLayoutX(65);
        phys.setLayoutY(140);
        phys.setPrefWidth(200);
        phys.setPromptText("Select Course");
        phys.setStyle("-fx-font-size: 12.5px;");
        phys.setVisible(false);

        biol.setLayoutX(65);
        biol.setLayoutY(140);
        biol.setPrefWidth(200);
        biol.setPromptText("Select Course");
        biol.setStyle("-fx-font-size: 12.5px;");
        biol.setVisible(false);


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
    pane.getChildren().addAll(scheduleBuilder,subjectComboBox,selectCourse,swe,cs,cse,math,stat,tcom,it,hist,chem,biol,engl,phys,econ,enroll,unenroll,back);
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
                "TCOM-Technical Communication",
                "ECON-Economics",
                "ENGL-English",
                "HIST-History",
                "CHEM-Chemistry",
                "PHYS-Physics",
                "BIOL-Biology"
        );
        subjectComboBox = new ComboBox<>(subjectOptions);
        ObservableList<String> cseOptions = FXCollections.observableArrayList(
                "CSE 1321 Programming and Problem Solving I 9:00-10:30",
                "CSE 1321L Programming and Problem Solving I Laboratory 10:30-12:00",
                "CSE 1322 Programming and Problem Solving II 9:00-10:30",
                "CSE 1322L Programming and Problem Solving II Laboratory 10:30-12:00",
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
                "MATH 1111 College Algebra 7:00-8:30",
                "MATH 1113 Precalculus 7:00-8:30",
                "MATH 1190 Calculus I 7:00-8:30",
                "MATH 2202 Calculus II 7:00-8:30",
                "MATH 2345 Discrete Mathematics 6:30-8:00"
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

        ObservableList<String> econOptions = FXCollections.observableArrayList(
                "ECON 1000 Contemporary Economic Issues 7:00-8:30"
        );
        econ = new ComboBox<>(econOptions);

        englOptions = FXCollections.observableArrayList(
                "ENGL 1101 English Composition I 12:00-1:30",
                "ENGL 1102 English Composition II 1:45-3:15",
                "ENGL 2110 World Literature 4:00-5:30",
                "ENGL 2120 British Literature 5:00-6:30",
                "ENGL 2130 American Literature 4:30-6:00",
                "ENGL 2140 African American Literature 6:00-7:30"
        );
        engl = new ComboBox<>(englOptions);
        ObservableList<String> histOptions = FXCollections.observableArrayList(
                "HIST 1111 Survey of World History I 5:30-7:00",
                "HIST 1112 Survey of World History II 4:45-6:15",
                "HIST 2111 Survey of U.S. History I 5:30-7:00",
                "HIST 2112 Survey of U.S. History II 4:00-5:30"
        );
        hist = new ComboBox<>(histOptions);
        ObservableList<String> chemOptions = FXCollections.observableArrayList(
                "CHEM 1211 Principles of Chemistry I 12:00-1:30",
                "CHEM 1211L Principles of Chemistry Laboratory I 1:30-3:00",
                "CHEM 1212 Principles of Chemistry II 12:00-1:30",
                "CHEM 1212L Principles of Chemistry Laboratory II 1:30-3:00"
        );
        chem = new ComboBox<>(chemOptions);

        ObservableList<String> physOptions = FXCollections.observableArrayList(
                "PHYS 1111 Introductory Physics I 10:30-12:00",
                "PHYS 1111L Introductory Physics Laboratory I 12:15-1:45",
                "PHYS 1112 Introductory Physics II 10:30-12:00",
                "PHYS 1112L Introductory Physics Laboratory II 12:15-1:45",
                "PHYS 2211 Principles of Physics I 2:00-3:30",
                "PHYS 2211L Principles of Physics Laboratory I 3:45-5:15",
                "PHYS 2212 Principles of Physics II 2:00-3:30",
                "PHYS 2212L Principles of Physics Laboratory II 3:45-5:15"
        );
        phys = new ComboBox<>(physOptions);
        ObservableList<String> biolOptions = FXCollections.observableArrayList(
                "BIOL 1107 Principles of Biology I 7:00-8:30",
                "BIOL 1107L Principles of Biology I Laboratory 1:30-3:00",
                "BIOL 1108 Principles of Biology II 12:00-1:30",
                "BIOL 1108L Principles of Biology II Laboratory 1:30-3:00"
        );
         biol = new ComboBox<>(biolOptions);
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

    public ComboBox<String> getEconCombo() {
        return econ;
    }

    public ComboBox<String> getEnglCombo() {
        return engl;
    }

    public ComboBox<String> getHistCombo() {
        return hist;
    }

    public ComboBox<String> getChemCombo() {
        return chem;
    }

    public ComboBox<String> getPhysCombo() {
        return phys;
    }

    public ComboBox<String> getBiolCombo() {
        return biol;
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
    public String getEconValue() {
        return econ.getValue().toString();
    }

    public String getEnglValue() {
        return engl.getValue().toString();
    }

    public String getHistValue() {
        return hist.getValue().toString();
    }

    public String getChemValue() {
        return chem.getValue().toString();
    }

    public String getPhysValue() {
        return phys.getValue().toString();
    }

    public String getBiolValue() {
        return biol.getValue().toString();
    }


    public void setCoursesInvisible() {
        cse.setVisible(false);
        econ.setVisible(false);
        engl.setVisible(false);
        hist.setVisible(false);
        chem.setVisible(false);
        phys.setVisible(false);
        biol.setVisible(false);
        math.setVisible(false);
        stat.setVisible(false);
        it.setVisible(false);
        cs.setVisible(false);
        tcom.setVisible(false);
        swe.setVisible(false);
        selectCourse.setVisible(false);
    }



    }


