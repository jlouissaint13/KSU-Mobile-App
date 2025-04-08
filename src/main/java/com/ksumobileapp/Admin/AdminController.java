package com.ksumobileapp.Admin;

import com.ksumobileapp.AdminReview.AdminReviewMain;
import com.ksumobileapp.AdminReview.AdminReviewView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminController {
    private AdminView adminView;
    private Button reviewButton;
    private AdminMain adminMain;
    private AdminReviewView reviewPage;
    private AdminReviewMain adminReviewMain;
    private Stage stage;
    public AdminController(Stage stage,AdminView adminView) {
        adminReviewMain = new AdminReviewMain();
        this.adminView = adminView;

        reviewButton = this.adminView.getReviewButton();


      reviewButton.setOnAction(e -> {
        reviewPage(stage);
      });

    }

    public void reviewPage(Stage stage) {
        adminReviewMain.start(stage);
    }
}
