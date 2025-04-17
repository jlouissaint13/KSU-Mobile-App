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
        // Title
        Label title = new Label("Choose Payment Method");

        // Payment options(can customize later)
        RadioButton creditCardOption = new RadioButton("Credit/Debit Card");
        RadioButton bankTransferOption = new RadioButton("Bank Transfer");
        RadioButton financialAidOption = new RadioButton("Use Financial Aid");
        ToggleGroup paymentGroup = new ToggleGroup();
        creditCardOption.setToggleGroup(paymentGroup);
        bankTransferOption.setToggleGroup(paymentGroup);
        financialAidOption.setToggleGroup(paymentGroup);

        VBox paymentOptionsBox = new VBox(10, creditCardOption, bankTransferOption, financialAidOption);
        paymentOptionsBox.setPadding(new Insets(10));

        // Proceed Button
        Button proceedBtn = new Button("Proceed");
        Label confirmationLabel = new Label();

        proceedBtn.setOnAction(e -> {
            confirmationLabel.setText("Payment Method Selected!");
        });

        VBox root = new VBox(20, title, paymentOptionsBox, proceedBtn, confirmationLabel);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 350, 300);
        stage.setTitle("Payment Options");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}