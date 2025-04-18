package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CreditCardPayment extends Application {
    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Credit/Debit Card Payment");

        TextField cardNumberField = new TextField();
        cardNumberField.setPromptText("Card Number (16 digits)");

        TextField expiryField = new TextField();
        expiryField.setPromptText("MM/YY");

        TextField cvvField = new TextField();
        cvvField.setPromptText("CVV (3 digits)");

        Label errorLabel = new Label();
        Button submitBtn = new Button("Submit Payment");

        // Handle payment validation
        submitBtn.setOnAction(e -> {
            String cardNum = cardNumberField.getText();
            String expiry = expiryField.getText();
            String cvv = cvvField.getText();

            if (!cardNum.matches("\\d{16}")) {
                errorLabel.setText("Card number must be 16 digits.");
            } else if (!expiry.matches("\\d{2}/\\d{2}")) {
                errorLabel.setText("Expiry must be in MM/YY format.");
            } else if (!cvv.matches("\\d{3}")) {
                errorLabel.setText("CVV must be 3 digits.");
            } else {
                errorLabel.setText("Payment Successful!");
            }
        });

        // Back button
        Button backButton = new Button("<");
        backButton.setOnAction(e -> {
            PaymentOptions paymentOptions = new PaymentOptions();
            Stage backStage = new Stage();
            try {
                paymentOptions.start(backStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            stage.close();
        });

        HBox backContainer = new HBox(backButton);
        backContainer.setAlignment(Pos.TOP_LEFT);

        VBox mainBox = new VBox(10, backContainer, titleLabel, cardNumberField, expiryField, cvvField, submitBtn, errorLabel);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(20));

        stage.setScene(new Scene(mainBox, 300, 320));
        stage.setTitle("Credit/Debit Card Payment");
        stage.show();
    }
}
