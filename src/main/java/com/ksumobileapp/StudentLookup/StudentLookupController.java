package com.ksumobileapp.StudentLookup;

import com.ksumobileapp.Admin.AdminMain;
import com.ksumobileapp.Admin.AdminModel;
import com.ksumobileapp.Login.LoginMain;
import javafx.stage.Stage;

public class StudentLookupController {
private LoginMain loginMain;
private StudentLookupView studentLookupView;
    public StudentLookupController(Stage stage, StudentLookupView studentLookupView) {
        AdminModel adminModel = new AdminModel();
        AdminMain adminMain = new AdminMain();
        LoginMain loginMain = new LoginMain();
        StudentLookupService studentLookupService = new StudentLookupService();
        this.studentLookupView = studentLookupView;
        this.studentLookupView.getSearch().setOnAction(e-> {
            if (this.studentLookupView.getStudentID() == null || this.studentLookupView.getStudentID().isBlank()) {
                studentLookupView.displayNullValue();
                return;
            }
            if (!studentLookupService.ifExistsID(this.studentLookupView.getStudentID().trim())) {
                studentLookupView.displayIDDoesNotExits();
                return;
            }

            String studentID = studentLookupView.getStudentID().trim();
            adminModel.setStudentID(studentID);
            adminMain.start(stage);
        }); {

        }
        this.studentLookupView.getLogout().setOnAction(e-> loginMain.start(stage));
    }
}
