package com.ksumobileapp.RecommendCourses;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Profile.ProfileMain;
import com.ksumobileapp.ScheduleBuilder.CourseModel;
import com.ksumobileapp.ScheduleBuilder.EnrollmentModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class RecommendationMain extends Application {
    private CourseRecommender recommender;


    @Override
    public void start(Stage primaryStage) {

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
        pageLabel.setLayoutX(150);
        pageLabel.setLayoutY(5);
        pageLabel.setFont(new Font("Arial", 18));

        //Pull user ID and connect
        String currentUser = LoginModel.getCurrentUser();
        recommender = new CourseRecommender(currentUser);
        recommender.connect();

        ListView<String> courseList = new ListView<>();

        ArrayList<String> recs =  recommender.getRecommendations();
        courseList.getItems().addAll(recs);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(back, backContain, pageLabel, courseList);

        Scene scene = new Scene(vBox, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommended Courses");
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);}
}
