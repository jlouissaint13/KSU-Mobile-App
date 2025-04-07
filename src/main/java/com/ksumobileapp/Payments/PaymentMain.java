package com.ksumobileapp.Payments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class PaymentMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tuition Payment");

        // Hardcoded
        Label amountLabel = new Label("Amount Due: $2,300");
        amountLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Pay Now Button
        Button payButton = new Button("Pay Now");
        payButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        payButton.setOnAction(e -> {

            // confirmation message
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Payment Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Payment Successful! Thank you.");
            alert.showAndWait();
        });

        // Layout container
        VBox layout = new VBox(20);
        layout.getChildren().addAll(amountLabel, payButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 30px;");

        // Create scene with 350x600 size
        Scene scene = new Scene(layout, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
