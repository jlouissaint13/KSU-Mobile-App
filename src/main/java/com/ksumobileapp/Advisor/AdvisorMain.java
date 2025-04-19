package com.ksumobileapp.Advisor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdvisorMain extends Application {
    @Override
    public void start(Stage stage) {
        Label title = new Label("Advisor Info");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label advisorName = new Label("Dr. Sarah Thompson");
        Label advisorEmail = new Label("sarah.thompson@ksu.edu");
        Label advisorPhone = new Label("470-578-1234");

        Button emailBtn = new Button("Email Advisor");

        // Use the existing stage variable directly here
        emailBtn.setOnAction(e -> {
            try {
                new AdvisorChat().start(new Stage()); // Opens new chat window
                stage.close(); // Closes the current AdvisorMain window
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(15, title, advisorName, advisorEmail, advisorPhone, emailBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 350, 600);
        stage.setScene(scene);
        stage.setTitle("Advisor Page");
        stage.show();
    }
}