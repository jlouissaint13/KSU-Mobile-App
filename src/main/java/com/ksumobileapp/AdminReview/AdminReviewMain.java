package com.ksumobileapp.AdminReview;

import javafx.application.Application;
import javafx.stage.Stage;

public class AdminReviewMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private AdminReviewView adminReviewView;
    private AdminReviewController adminReviewController;
    private AdminReviewService adminReviewService;
    private AdminReviewModel adminReviewModel;
    @Override
    public void start(Stage primaryStage) {
        this.adminReviewView = new AdminReviewView(primaryStage);
        this.adminReviewService = new AdminReviewService();
        this.adminReviewModel = new AdminReviewModel();
        AdminReviewController adminReviewController = new AdminReviewController(primaryStage,this.adminReviewView,adminReviewService,adminReviewModel);
    }
}
