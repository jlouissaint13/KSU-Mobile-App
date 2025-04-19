package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PaymentOptions extends Application {

    @Override
    public void start(Stage stage) {

        // === Back Button ===
        Button backButton = new Button("<");
        backButton.setOnAction(e -> {
            try {
                PaymentMain paymentMain = new PaymentMain();
                Stage paymentStage = new Stage();
                paymentMain.start(paymentStage);
                stage.close(); // close PaymentOptions
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Back button positioned top-left
        HBox backBox = new HBox(backButton);
        backBox.setAlignment(Pos.TOP_LEFT);
        backBox.setPadding(new Insets(10));

        // === Payment Option Buttons ===
        Button creditCardBtn = new Button("Credit/Debit Card");
        Button bankTransferBtn = new Button("Bank Transfer");

        // Open CreditCardPayment on click
        creditCardBtn.setOnAction(e -> {
            try {
                CreditCardPayment creditCard = new CreditCardPayment();
                Stage creditStage = new Stage();
                creditCard.start(creditStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Open BankTransferPayment on click
        bankTransferBtn.setOnAction(e -> {
            try {
                BankTransferPayment bankTransfer = new BankTransferPayment();
                Stage bankStage = new Stage();
                bankTransfer.start(bankStage);
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox optionsBox = new VBox(20, creditCardBtn, bankTransferBtn);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPadding(new Insets(20));

        VBox layout = new VBox(backBox, optionsBox);
        Scene scene = new Scene(layout, 350, 600);

        stage.setTitle("Payment Options");
        stage.setScene(scene);
        stage.show();
    }
}