package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

                // Reuse the same stage instead of creating a new one
                paymentMain.start(stage);

                // Re-add logo to top-left of window
                stage.getIcons().clear(); // clear existing icons
                stage.getIcons().add(new Image("logo.png")); // add logo again

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

                creditCard.start(stage); // reuse stage
                stage.getIcons().clear();
                stage.getIcons().add(new Image("logo.png")); // re-add icon

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Open BankTransferPayment on click
        bankTransferBtn.setOnAction(e -> {
            try {
                BankTransferPayment bankTransfer = new BankTransferPayment();

                bankTransfer.start(stage); // reuse stage
                stage.getIcons().clear();
                stage.getIcons().add(new Image("logo.png")); // re-add icon

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox optionsBox = new VBox(20, creditCardBtn, bankTransferBtn);
        optionsBox.setAlignment(Pos.CENTER);
        optionsBox.setPadding(new Insets(20));

        VBox layout = new VBox(backBox, optionsBox);
        Scene scene = new Scene(layout, 350, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setTitle("Payment Options");

        // Make sure the logo is added when this screen first loads
        stage.getIcons().clear();
        stage.getIcons().add(new Image("logo.png"));

        stage.setScene(scene);
        stage.show();
    }
}