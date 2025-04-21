package com.ksumobileapp.Advisor;

import com.ksumobileapp.Profile.ProfileMain;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdvisorMain extends Application {
    @Override
    public void start(Stage stage) {
        // Back button to go to ProfileMain
        Button backButton = new Button("<");
        backButton.setOnAction(e -> {
            try {
                // Replace the current scene with ProfileMain on the same stage
                ProfileMain profileMain = new ProfileMain();
                profileMain.start(stage);  // Reuse the same stage
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Header layout with back button
        HBox backContainer = new HBox(backButton);
        backContainer.setAlignment(Pos.TOP_LEFT);
        backContainer.setPadding(new Insets(10));

        Label title = new Label("Advisor Info");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label advisorName = new Label("Dr. Sarah Thompson");
        Label advisorEmail = new Label("sarah.thompson@ksu.edu");
        Label advisorPhone = new Label("470-578-1234");

        Button emailBtn = new Button("Email Advisor");
        emailBtn.setOnAction(e -> {
            try {
                // Set the same stage to the AdvisorChat screen
                AdvisorChat chatWindow = new AdvisorChat();
                chatWindow.start(stage);  // Reuse the same stage for the chat screen
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox content = new VBox(15, title, advisorName, advisorEmail, advisorPhone, emailBtn);
        content.setAlignment(Pos.CENTER);
        content.setPadding(new Insets(20));

        VBox root = new VBox(backContainer, content);
        Scene scene = new Scene(root, 350, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Advisor Page");
        stage.show();
    }
}