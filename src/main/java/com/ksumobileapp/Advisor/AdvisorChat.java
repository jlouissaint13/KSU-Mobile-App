package com.ksumobileapp.Advisor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdvisorChat extends Application {
    private VBox chatBox; // Container for chat messages
    @Override
    public void start(Stage stage) {
        // Back button to go back to AdvisorMain
        Button backButton = new Button("<");
        backButton.setOnAction(e -> {
            AdvisorMain advisorMain = new AdvisorMain();
            advisorMain.start(stage); // Reuse the same stage

            // Set window/taskbar icon again for consistency
            stage.getIcons().clear();
            stage.getIcons().add(new Image("logo.png"));
        });

        // Title label
        Label titleLabel = new Label("Chat with Advisor");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Top bar layout
        HBox topBar = new HBox(backButton, titleLabel);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setSpacing(10);
        topBar.setPadding(new Insets(10));

        // VBox to hold all chat messages
        chatBox = new VBox(10);
        chatBox.setPadding(new Insets(10));
        chatBox.setStyle("-fx-background-color: #f4f4f4;");

        // Scroll pane to allow scrolling through messages
        ScrollPane scrollPane = new ScrollPane(chatBox);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(500);

        // Input field and send button
        TextField inputField = new TextField();
        inputField.setPromptText("Type your message...");

        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(e -> {
            String message = inputField.getText().trim();
            if (!message.isEmpty()) {
                addUserMessage(message);
                addAdvisorResponse(message);
                inputField.clear();
            }
        });

        HBox inputArea = new HBox(10, inputField, sendBtn);
        inputArea.setAlignment(Pos.CENTER);
        inputArea.setPadding(new Insets(10));

        VBox root = new VBox(10, topBar, scrollPane, inputArea);
        root.setPadding(new Insets(15));

        Scene scene = new Scene(root, 350, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // Set window/taskbar icon
        stage.getIcons().clear();
        stage.getIcons().add(new Image("logo.png"));

        stage.setTitle("Email Your Advisor");
        stage.setScene(scene);
        stage.show();

        advisorIntroMessage();
    }

    private void advisorIntroMessage() {
        String welcome = "Hi there! I'm Dr.Thompson, your advisor 😊\n\nWhat do you need help with today?\nHere are some things I can assist with:\n- Class registration\n- Graduation requirements\n- Course withdrawals\n- Academic probation\n- General questions";
        addAdvisorText(welcome);
    }

    private void addUserMessage(String msg) {
        Label messageLabel = new Label(msg);
        messageLabel.setStyle("-fx-background-color: #d1e7dd; -fx-padding: 8; -fx-background-radius: 10;");
        HBox box = new HBox(messageLabel);
        box.setAlignment(Pos.CENTER_RIGHT);
        chatBox.getChildren().add(box);
    }

    private void addAdvisorResponse(String userMsg) {
        String reply = generateAdvisorReply(userMsg);
        addAdvisorText(reply);
    }

    private void addAdvisorText(String msg) {
        Label replyLabel = new Label(msg);
        replyLabel.setStyle("-fx-background-color: #f8d7da; -fx-padding: 8; -fx-background-radius: 10;");
        HBox box = new HBox(replyLabel);
        box.setAlignment(Pos.CENTER_LEFT);
        chatBox.getChildren().add(box);
    }

    private String generateAdvisorReply(String userMsg) {
        String msg = userMsg.toLowerCase();
        if (msg.contains("schedule") || msg.contains("register")) {
            return "Registered classes can be viewed \nin the Registration section on OwlExpress as well\nas viewing your required courses. Any other questions?";
        } else if (msg.contains("graduation") || msg.contains("graduating")) {
            return "Awesome! You just need to complete the graduation application through Owl Express.";
        } else if (msg.contains("withdrawal") || msg.contains("withdrawals") || msg.contains("withdrawing")) {
            return "There's a certain period of time you can opt out\nwithout repercussions. It can be done on Owl Express.\n\nAnything else?";
        } else if (msg.contains("probation") || msg.contains("reported") || msg.contains("consequences")) {
            return "It's a warning that your GPA has fallen below\nthe minimum required standard—usually 2.0.\nYou need to improve your grades within a set time\nor you could face suspension or dismissal.";
        } else if (msg.contains("thanks") || msg.contains("thank") || msg.contains("appreciate")) {
            return "You're very welcome!";
        } else if (msg.contains("withdraw")) {
            return "For withdrawals, the deadline varies by semester.\nDo you know the course you want to withdraw from?";
        }
        return "Alright then! I’ll look into that and \nget back to you shortly.";
    }
}