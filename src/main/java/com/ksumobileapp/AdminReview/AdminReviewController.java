package com.ksumobileapp.AdminReview;

import com.ksumobileapp.Admin.AdminMain;
import javafx.stage.Stage;

public class AdminReviewController {
    private AdminReviewView adminReviewView;
    private AdminReviewService adminReviewService;
    private  AdminReviewModel adminReviewModel;
    private AdminMain adminMain;
    public AdminReviewController(Stage stage, AdminReviewView adminReviewView, AdminReviewService adminReviewService, AdminReviewModel adminReviewModel) {
        adminMain = new AdminMain();
        this.adminReviewModel = adminReviewModel;
        this.adminReviewService = adminReviewService;
        this.adminReviewService.getData(this.adminReviewModel);
        this.adminReviewView = adminReviewView;
        this.adminReviewView.setInformation(adminReviewModel);

         this.adminReviewView.getUpdateButton().setOnAction(e-> {
             adminReviewService.updateData(this.adminReviewView);
             adminMain.start(stage);
         });
    }
}
