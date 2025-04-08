package com.ksumobileapp.Payments;

import com.ksumobileapp.Profile.ProfileMain;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class PaymentMain extends Application {



    @Override
    public void start(Stage primaryStage) {



        // Creates a back button labeled "<"
        Button backButton = new Button("<");

        // Action when back button is clicked
        backButton.setOnAction(e -> {
            try {
                // Launches the ProfileMain window
                ProfileMain profile = new ProfileMain();
                Stage profileStage = new Stage();
                profile.start(profileStage);

                // Closes the current payment window
                primaryStage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Places the back button to "Profile"
        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_LEFT);
        backButtonContainer.setPadding(new Insets(10));

        // Adds a title for the payment window
        Label titleLabel = new Label("Student Account");
        titleLabel.setFont(new Font("Arial", 18)); // Set font size

        // labels show student and payment info
        Label nameLabel = new Label("Name: John Doe");
        Label idLabel = new Label("ID: 001020932");
        Label balanceLabel = new Label("Balance: $1,100.00");
        Label aidLabel = new Label("Estimated Financial Aid: $1,961.60");
        Label totalLabel = new Label("Balance including estimated aid: -$861.60");
        Label ebillLabel = new Label("Latest eBill Statement (1/8/25): -$3,238.00");

        // Groups all account info vertically with spacing
        VBox accountInfoBox = new VBox(10, nameLabel, idLabel, balanceLabel, aidLabel, totalLabel, ebillLabel);
        accountInfoBox.setPadding(new Insets(10));
        accountInfoBox.setAlignment(Pos.TOP_LEFT);

        // ===== MAKE PAYMENT BUTTON =====
        Button makePaymentBtn = new Button("Make Payment");

        // Label to show confirmation message after clicking the button
        Label confirmationLabel = new Label();

        // Action when "Make Payment" is clicked
        makePaymentBtn.setOnAction(e -> {
            confirmationLabel.setText("Payment Successful!");
        });

        // Puts the button and confirmation label in a vertical layout
        VBox buttonBox = new VBox(10, makePaymentBtn, confirmationLabel);
        buttonBox.setAlignment(Pos.CENTER);

        // Combines title, account info, and button into one vertical box
        VBox contentBox = new VBox(20, titleLabel, accountInfoBox, buttonBox);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(10));

        // Final root layout that includes back button + content
        VBox root = new VBox();
        root.getChildren().addAll(backButtonContainer, contentBox);

        Scene scene = new Scene(root, 350, 600); // Size as requested

        // Window title and scene display
        primaryStage.setTitle("Payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX app
    }
}