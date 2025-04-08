package com.ksumobileapp.AdminReview;

import com.ksumobileapp.Admin.AdminMain;
import javafx.stage.Stage;

public class AdminUpdateController {
    private AdminUpdateView adminUpdateView;
    private AdminReviewModel adminReviewModel;
    private AdminReviewService adminReviewService;
    private AdminMain adminMain;
    public AdminUpdateController(Stage stage, AdminUpdateView adminUpdateView,AdminReviewService adminReviewService,AdminReviewModel adminReviewModel) {
        this.adminReviewModel = adminReviewModel;
        this.adminReviewService = adminReviewService;
        this.adminReviewService.getData(this.adminReviewModel);
        this.adminUpdateView = adminUpdateView;
        adminMain = new AdminMain();
        this.adminUpdateView.setInformation(this.adminReviewModel);


        this.adminUpdateView.getBackButton().setOnAction(e-> adminMain.start(stage));

        this.adminUpdateView.getUpdateProfile().setOnAction(e->{
            this.adminReviewService.updateData(this.adminUpdateView);
            adminMain.start(stage);
        });
    }
}
