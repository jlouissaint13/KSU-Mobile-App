package com.ksumobileapp.RecommendCourses;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Profile.ProfileMain;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class RecommendationMain extends Application {
    private CourseRecommender recommender;

    public static void main(String[] args) {launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception {

        Button back = new Button("<");
        back.setOnAction(e -> {
            try{
                ProfileMain profile = new ProfileMain();
                Stage profileStage = new Stage();
                profile.start(profileStage);
                primaryStage.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        //Position the back button on the top left
        HBox backContain = new HBox(back);
        backContain.setAlignment(Pos.TOP_LEFT);

        //Title
        Label pageLabel = new Label("Recommended Courses");
        pageLabel.setFont(new Font("Arial", 18));

        //Pull user ID and connect
        String currentUser = LoginModel.getCurrentUser();
        recommender = new CourseRecommender(currentUser);
        recommender.connect();

        //Create the list of courses

    }
}
