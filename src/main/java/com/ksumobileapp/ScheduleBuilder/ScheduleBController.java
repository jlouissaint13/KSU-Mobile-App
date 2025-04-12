package com.ksumobileapp.ScheduleBuilder;

import javafx.stage.Stage;

public class ScheduleBController {
    private ScheduleBView scheduleBView;

    public ScheduleBController(Stage stage,ScheduleBView scheduleBView) {

        this.scheduleBView = scheduleBView;

        this.scheduleBView.getSubjectComboBox().setOnAction(e -> setVisibleBox(this.scheduleBView.returnSubject()));

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
}
