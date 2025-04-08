package com.ksumobileapp.AdminReview;
import com.ksumobileapp.Admin.AdminMain;
import com.ksumobileapp.Admin.AdminModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class AdminUpdateMain extends Application {
private AdminUpdateView adminUpdateView;
    public static void main(String[] args) {
        launch(args);
    }
    private AdminReviewService adminReviewService;
    private AdminReviewModel adminReviewModel;
    private AdminUpdateController adminUpdateController;
    private AdminMain adminMain;
    @Override
    public void start(Stage primaryStage) {
        this.adminUpdateView = new AdminUpdateView(primaryStage);
        this.adminReviewService = new AdminReviewService();
        this.adminReviewModel = new AdminReviewModel();

        adminUpdateController = new AdminUpdateController(primaryStage,adminUpdateView,adminReviewService,adminReviewModel);



    }
}
