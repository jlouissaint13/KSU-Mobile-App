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

         this.adminReviewView.getAcceptButton().setOnAction(e-> {
             adminReviewService.updateData(this.adminReviewView);
             adminMain.start(stage);
         });


         this.adminReviewView.getBackButton().setOnAction(e-> adminMain.start(stage));

         this.adminReviewView.getAcceptButton().setOnAction(e-> acceptance(stage));

         this.adminReviewView.getDenyButton().setOnAction(e-> deny(stage));
    }

    public void acceptance(Stage stage) {
        adminReviewService.updateStatusAccept(this.adminReviewView);
        adminMain.start(stage);
    }
    public void deny(Stage stage) {
        adminReviewService.updateStatusDenied(this.adminReviewView);
        adminMain.start(stage);
    }

}
