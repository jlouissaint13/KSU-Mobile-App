package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PaymentOptions extends Application {
    @Override
    public void start(Stage stage) {
        Button cardBtn = new Button("Credit/Debit Card");
        Button bankBtn = new Button("Bank Transfer");

        // Open CreditCardPayment on click
        cardBtn.setOnAction(e -> {
            try {
                CreditCardPayment cardWindow = new CreditCardPayment();
                Stage newStage = new Stage();
                cardWindow.start(newStage);
                stage.close(); // Optional: close current PaymentOptions window
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Open BankTransferPayment on click
        bankBtn.setOnAction(e -> {
            try {
                BankTransferPayment bankWindow = new BankTransferPayment();
                Stage newStage = new Stage();
                bankWindow.start(newStage);
                stage.close(); // Optional: close current PaymentOptions window
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(15, cardBtn, bankBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("Select Payment Method");
        stage.show();
    }
}