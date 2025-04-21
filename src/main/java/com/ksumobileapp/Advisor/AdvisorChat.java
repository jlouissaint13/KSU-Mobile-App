package com.ksumobileapp.Advisor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdvisorChat extends Application {

    private VBox chatBox; // Container for chat messages

    @Override
    public void start(Stage stage) {

        // Back button (top-left)
        Button backButton = new Button("<");
        backButton.setStyle("-fx-font-size: 14px; -fx-background-color: transparent;");
        backButton.setOnAction(e -> {
            try {
                AdvisorMain advisorMain = new AdvisorMain();
                Stage advisorStage = new Stage();
                advisorMain.start(advisorStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Title
        Label titleLabel = new Label("Chat with Advisor");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        titleLabel.setMaxWidth(Double.MAX_VALUE);
        titleLabel.setAlignment(Pos.CENTER);

        // StackPane to center title & float back arrow to left
        StackPane topBar = new StackPane();
        topBar.setPadding(new Insets(10));
        topBar.setPrefHeight(40);
        StackPane.setAlignment(titleLabel, Pos.CENTER);
        StackPane.setAlignment(backButton, Pos.CENTER_LEFT);
        topBar.getChildren().addAll(titleLabel, backButton);

        // VBox to hold all chat messages
        chatBox = new VBox(10);
        chatBox.setPadding(new Insets(10));
        chatBox.setStyle("-fx-background-color: #f4f4f4;");

        // Scroll pane to allow scrolling through messages
        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(500);

        // Input field to type a message
        TextField inputField = new TextField();
        inputField.setPromptText("Type your message...");

        // Send button
        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(e -> {
            String message = inputField.getText().trim();
            if (!message.isEmpty()) {
                addUserMessage(message);
                addAdvisorResponse(message);
                inputField.clear();
            }
        });

        // Layout for input area
        HBox inputArea = new HBox(10, inputField, sendBtn);
        inputArea.setAlignment(Pos.CENTER);
        inputArea.setPadding(new Insets(10));

        // Main layout
        VBox root = new VBox(10, topBar, scrollPane, inputArea);
        root.setPadding(new Insets(15));

        // Set window size
        Scene scene = new Scene(root, 350, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Email Your Advisor");
        stage.setScene(scene);
        stage.show();

        // Advisor initiates conversation
        advisorIntroMessage();
    }

    // welcome message + options
    private void advisorIntroMessage() {
        String welcome = "Hi there! I'm Dr.Thompson, your advisor 😊\n\nWhat do you need help with today?\nHere are some things I can assist with:\n- Class registration\n- Graduation requirements\n- Course withdrawals\n- Academic probation\n- General questions";
        addAdvisorText(welcome);
    }

    // Display user's message
    private void addUserMessage(String msg) {
        Label messageLabel = new Label(msg);
        messageLabel.setStyle("-fx-background-color: #d1e7dd; -fx-padding: 8; -fx-background-radius: 10;");
        HBox box = new HBox(messageLabel);
        box.setAlignment(Pos.CENTER_RIGHT);
        chatBox.getChildren().add(box);
    }

    // Display advisor's response
    private void addAdvisorResponse(String userMsg) {
        String reply = generateAdvisorReply(userMsg);

        addAdvisorText(reply);
    }

    // Display advisor text
    private void addAdvisorText(String msg) {
        Label replyLabel = new Label(msg);
        replyLabel.setStyle("-fx-background-color: #f8d7da; -fx-padding: 8; -fx-background-radius: 10;");
        HBox box = new HBox(replyLabel);
        box.setAlignment(Pos.CENTER_LEFT);
        chatBox.getChildren().add(box);
    }

    // auto-response logic
    private String generateAdvisorReply(String userMsg) {
        String msg = userMsg.toLowerCase();
        if (msg.contains("schedule") || msg.contains("register")) {
            return "Registered classes can be viewed \nin the Registration section on OwlExpress as well\n as viewing your required courses, any other questions?";
        } else if (msg.contains("graduation") || msg.contains("graduating")) {
            return "Awesome! You just need to though the graduation application through Owl Express";
        } else if (msg.contains("withdrawal") || msg.contains("withdrawals") || msg.contains("withdrawing")) {
            return "Awesome! Just make sure you submit your graduation application through Owl Express";
        } else if (msg.contains("probation") || msg.contains("reported") || msg.contains("consequences")) {
            return "Its is a warning saying that your GPA has fallen \nbelow the minimum required standard—usually 2.0 /nit means you need to improve your grades within \na set time, or you could face suspension or dismissal \nfrom the university";
        }else if (msg.contains("thanks") || msg.contains("thank") || msg.contains("appreciate")) {
            return "You're very welcome!";
        } else if (msg.contains("withdraw")) {
            return "For withdrawals, the deadline varies by semester. Do you know the course you want to withdraw from?";
        }
        return "Alright then! I’ll look into that and \nget back to you shortly";
    }
}