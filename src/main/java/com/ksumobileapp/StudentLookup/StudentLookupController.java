package com.ksumobileapp.StudentLookup;

import com.ksumobileapp.Admin.AdminMain;
import com.ksumobileapp.Admin.AdminModel;
import javafx.stage.Stage;

public class StudentLookupController {


    public StudentLookupController(Stage stage, StudentLookupView studentLookupView) {
        AdminModel adminModel = new AdminModel();
        AdminMain adminMain = new AdminMain();
        studentLookupView.getSearch().setOnAction(e-> {
            String studentID = studentLookupView.getStudentID();;
            adminModel.setStudentID(studentID);
            adminMain.start(stage);
        }); {

        }
    }
}
