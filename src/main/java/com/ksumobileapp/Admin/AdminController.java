package com.ksumobileapp.Admin;

import com.ksumobileapp.AdminReview.AdminReviewMain;
import com.ksumobileapp.AdminReview.AdminReviewView;
import com.ksumobileapp.AdminReview.AdminUpdateMain;
import com.ksumobileapp.StudentLookup.StudentLookUpMain;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController {
    private AdminView adminView;
    private Button reviewButton,updateButton,deleteButton,logout;
    private AdminMain adminMain;
    private AdminReviewView reviewPage;
    private AdminReviewMain adminReviewMain;
    private StudentLookUpMain studentLookUpMain;
    private AdminUpdateMain adminUpdateMain;
    private Stage stage;
    public AdminController(Stage stage,AdminView adminView) {
        studentLookUpMain = new StudentLookUpMain();
        adminReviewMain = new AdminReviewMain();
        adminUpdateMain = new AdminUpdateMain();
        this.adminView = adminView;

        reviewButton = this.adminView.getReviewButton();
        updateButton = this.adminView.getUpdateProfileButton();
        logout = this.adminView.getLogout();

      reviewButton.setOnAction(e -> {
        reviewPage(stage);
      });
      updateButton.setOnAction(e-> adminUpdateMain.start(stage));


      logout.setOnAction(e -> studentLookUpMain.start(stage));



    }

    public void reviewPage(Stage stage) {
        adminReviewMain.start(stage);
    }
}
