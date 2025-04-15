package com.ksumobileapp.ScheduleBuilder;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Optional;


public class ScheduleBController {
    private ScheduleBView scheduleBView;
    private CourseModel courseModel;
    private SemesterMain semesterMain;
    private EnrollmentService enrollmentService;
    private EnrollmentModel enrollmentModel;
    public ScheduleBController(Stage stage,ScheduleBView scheduleBView,EnrollmentModel enrollmentModel) {
        this.scheduleBView = scheduleBView;
        enrollmentService = new EnrollmentService();
        this.enrollmentModel = enrollmentModel;
        this.scheduleBView.getSubjectComboBox().setOnAction(e -> setVisibleBox(this.scheduleBView.returnSubject()));
        semesterMain = new SemesterMain();

        this.scheduleBView.getEnroll().setOnAction(e-> {
            CourseModel.setCourseID(scheduleBView.getCourseID(whichValue()));

            enrollmentService.setPrerequisites(this.enrollmentModel);
            enrollmentService.getData(this.enrollmentModel);


            if (enrollmentService.creditLimitError()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Credit Limit");
                alert.setHeaderText("Credit Limit Error");
                alert.setContentText("You cannot take more then 18 credits");

                Optional<ButtonType> result = alert.showAndWait();

            }
            try {
                if (enrollmentService.courseExists()) {

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Duplicate Error");
                    alert.setHeaderText("Duplicate Error");
                    alert.setContentText("You are already enrolled in this course");

                    Optional<ButtonType> result = alert.showAndWait();
                    return;
                };

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            switch (enrollmentService.prereqChecker(this.enrollmentModel)) {
                case 1,2 -> {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Prerequisite Error");
                    alert.setHeaderText("Prerequisite Error");
                    alert.setContentText("You are missing at least one of the following prerequisites: " + this.enrollmentModel.getPrerequisites());

                    Optional<ButtonType> result = alert.showAndWait();
                    return;
                }
            }

            if (enrollmentService.scheduleError(enrollmentModel)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Schedule Error");
                alert.setHeaderText("Schedule Error");
                alert.setContentText("You are enrolled in a class that takes place during the allocated time slot");

                Optional<ButtonType> result = alert.showAndWait();
                return;
            }


            enrollmentService.enroll(this.enrollmentModel);
            this.scheduleBView.fillTable();

        });




        this.scheduleBView.getUnenroll().setOnAction(e-> {
            CourseModel.setCourseID(this.scheduleBView.getCourseID(whichValue()));
            enrollmentService.unenroll();
            this.scheduleBView.fillTable();
        });

        this.scheduleBView.getBack().setOnAction(e-> semesterMain.start(stage));
    }

    public void setVisibleBox(String subject) {
        this.scheduleBView.setCoursesInvisible();
        switch (subject) {
            case "CS-Computer Science" -> this.scheduleBView.getCsCombo().setVisible(true);
            case "CSE-Computer Science and Engineering" -> this.scheduleBView.getCseCombo().setVisible(true);
            case "MATH-Mathematics" -> this.scheduleBView.getMathComboBox().setVisible(true);
            case "STAT-Statistics" -> this.scheduleBView.getStatComboBox().setVisible(true);
            case "IT-Information Technology" -> this.scheduleBView.getITComboBox().setVisible(true);
            case "TCOM-Technical Communication" -> this.scheduleBView.getTcomComboBox().setVisible(true);
            case "SWE-Software Engineering" -> this.scheduleBView.getSweCombo().setVisible(true);
            case "ECON-Economics" -> this.scheduleBView.getEconCombo().setVisible(true);
            case "ENGL-English" -> this.scheduleBView.getEnglCombo().setVisible(true);
            case "HIST-History" -> this.scheduleBView.getHistCombo().setVisible(true);
            case "CHEM-Chemistry" -> this.scheduleBView.getChemCombo().setVisible(true);
            case "PHYS-Physics" -> this.scheduleBView.getPhysCombo().setVisible(true);
            case "BIOL-Biology" -> this.scheduleBView.getBiolCombo().setVisible(true);

            case "1" -> {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Please select a Subject");
                alert.setHeaderText("Subject Error");
                alert.setContentText("You need to select a subject");

            }
        }
    }
    public String whichValue() {
        ComboBox[] comboBoxes = new ComboBox[13];
        comboBoxes[0] = this.scheduleBView.getCsCombo();
        comboBoxes[1] = this.scheduleBView.getCseCombo();
        comboBoxes[2] = this.scheduleBView.getMathComboBox();
        comboBoxes[3] = this.scheduleBView.getStatComboBox();
        comboBoxes[4] = this.scheduleBView.getITComboBox();
        comboBoxes[5] = this.scheduleBView.getTcomComboBox();
        comboBoxes[6] = this.scheduleBView.getSweCombo();
        comboBoxes[7] = this.scheduleBView.getEconCombo();
        comboBoxes[8] = this.scheduleBView.getEnglCombo();
        comboBoxes[9] = this.scheduleBView.getHistCombo();
        comboBoxes[10] = this.scheduleBView.getChemCombo();
        comboBoxes[11] = this.scheduleBView.getPhysCombo();
        comboBoxes[12] = this.scheduleBView.getBiolCombo();

        for (int i = 0; i < 13; i++) {
            if (comboBoxes[i].isVisible()) return comboBoxes[i].getValue().toString();
        }
        return "1";
    }
}
