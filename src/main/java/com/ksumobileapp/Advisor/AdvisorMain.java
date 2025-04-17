package com.ksumobileapp.Advisor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AdvisorMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Title
        Label title = new Label("Advisor Information");
        title.setFont(new Font("Arial", 24));

        // Fake advisor info for now
        Label name = new Label("Name: Dr. Alex Morgan");
        Label department = new Label("Department: Computer Science");
        Label office = new Label("Office: Building J, Room 202");
        Label phone = new Label("Phone: (470) 578-1234");
        Label email = new Label("Email: amorgan@kennesaw.edu");

        // Email advisor button (just prints for now)
        Button emailBtn = new Button("Email Advisor");
        emailBtn.setOnAction(e -> {
            System.out.println("Opening email client for: amorgan@kennesaw.edu");
            // Later you can integrate with Desktop.getDesktop().mail(...) if desired
        });

        VBox layout = new VBox(10, title, name, department, office, phone, email, emailBtn);
        layout.setAlignment(Pos.TOP_LEFT);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 350, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Advisor");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}