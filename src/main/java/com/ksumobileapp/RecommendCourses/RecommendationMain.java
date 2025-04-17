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

import java.sql.SQLException;
import java.util.ArrayList;

public class RecommendationMain extends Application {
    private CourseRecommender recommender;

    @Override
    public void start(Stage primaryStage) throws SQLException {

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
        recommender = new CourseRecommender(LoginModel.getCurrentUser());


        ListView<String> courseList = new ListView<>();
        ObservableList<String> showCourses = FXCollections.observableArrayList();

        ArrayList<String> recommendations = recommender.getEligible(recommender.completedCourses());
        showCourses.addAll(recommendations);
        courseList.setItems(showCourses);




        VBox vBox = new VBox();
        vBox.getChildren().addAll(back, backContain, pageLabel, courseList);

        Scene scene = new Scene(vBox, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Recommended Courses");
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);}
}
