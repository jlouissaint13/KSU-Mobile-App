package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BankTransferPayment extends Application {
    @Override
    public void start(Stage stage) {
        Label titleLabel = new Label("Bank Transfer Payment");

        TextField routingNumberField = new TextField();
        routingNumberField.setPromptText("Routing Number (9 digits)");

        TextField accountNumberField = new TextField();
        accountNumberField.setPromptText("Account Number (up to 17 digits)");

        Label errorLabel = new Label();
        Button submitBtn = new Button("Submit Transfer");

        // Handle payment validation
        submitBtn.setOnAction(e -> {
            String routing = routingNumberField.getText();
            String account = accountNumberField.getText();

            if (!routing.matches("\\d{9}")) {
                errorLabel.setText("Routing number must be 9 digits.");
            } else if (!account.matches("\\d{1,17}")) {
                errorLabel.setText("Account number must be 1-17 digits.");
            } else {
                errorLabel.setText("Transfer Successful!");
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

        VBox mainBox = new VBox(10, backContainer, titleLabel, routingNumberField, accountNumberField, submitBtn, errorLabel);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setPadding(new Insets(20));
        mainBox.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(new Scene(mainBox, 300, 280));
        stage.setTitle("Bank Transfer Payment");
        stage.show();
    }
}
