package com.ksumobileapp.Admin;

import com.ksumobileapp.AdminReview.AdminReviewMain;
import com.ksumobileapp.AdminReview.AdminReviewService;
import com.ksumobileapp.AdminReview.AdminReviewView;
import com.ksumobileapp.AdminReview.AdminUpdateMain;
import com.ksumobileapp.StudentLookup.StudentLookUpMain;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class AdminController {
    private AdminView adminView;
    private Button reviewButton,updateButton,deleteButton,logout;
    private AdminMain adminMain;
    private AdminReviewView reviewPage;
    private AdminReviewMain adminReviewMain;
    private StudentLookUpMain studentLookUpMain;
    private AdminUpdateMain adminUpdateMain;
    private AdminReviewService adminReviewService;
    private Stage stage;
    public AdminController(Stage stage,AdminView adminView) {
        studentLookUpMain = new StudentLookUpMain();
        adminReviewMain = new AdminReviewMain();
        adminUpdateMain = new AdminUpdateMain();
        adminReviewService = new AdminReviewService();
        this.adminView = adminView;

        reviewButton = this.adminView.getReviewButton();
        updateButton = this.adminView.getUpdateProfileButton();
        deleteButton = this.adminView.getDeleteAccount();
        logout = this.adminView.getLogout();

      reviewButton.setOnAction(e -> {
        reviewPage(stage);
      });
      updateButton.setOnAction(e-> adminUpdateMain.start(stage));


      deleteButton.setOnAction(e-> {
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Confirmation");
                  alert.setHeaderText("Are you sure?");
                  alert.setContentText("Are you sure you would like to delete the user associated with the student ID:" + AdminModel.getStudentIDStaticMethod() );

                  Optional<ButtonType> result = alert.showAndWait();

                  if (result.isPresent() && result.get() == ButtonType.OK) {
                      adminReviewService.deleteUser();
                  } else {

                  }

      });

      logout.setOnAction(e -> studentLookUpMain.start(stage));



    }

    public void reviewPage(Stage stage) {
        adminReviewMain.start(stage);
    }
}
