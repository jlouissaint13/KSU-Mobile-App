package com.ksumobileapp.ScheduleBuilder;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;



public class ScheduleBController {
    private ScheduleBView scheduleBView;
    private CourseModel courseModel;
    private SemesterMain semesterMain;
    public ScheduleBController(Stage stage,ScheduleBView scheduleBView) {
        this.scheduleBView = scheduleBView;
        this.scheduleBView.getSubjectComboBox().setOnAction(e -> setVisibleBox(this.scheduleBView.returnSubject()));
        semesterMain = new SemesterMain();

        this.scheduleBView.getEnroll().setOnAction(e-> {
            CourseModel.setCourseID(scheduleBView.getCourseID(whichValue()));

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
        }
    }
    public String whichValue() {
        ComboBox[] comboBoxes = new ComboBox[7];
        comboBoxes[0] = this.scheduleBView.getCsCombo();
        comboBoxes[1] = this.scheduleBView.getCseCombo();
        comboBoxes[2] = this.scheduleBView.getMathComboBox();
        comboBoxes[3] = this.scheduleBView.getStatComboBox();
        comboBoxes[4] = this.scheduleBView.getITComboBox();
        comboBoxes[5] = this.scheduleBView.getTcomComboBox();
        comboBoxes[6] = this.scheduleBView.getSweCombo();
        for (int i = 0;i<7;i++) {
            if (comboBoxes[i].isVisible()) return comboBoxes[i].getValue().toString();
        }
        return null;
    }
}
