package com.ksumobileapp.Payments;

import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Profile.ProfileMain;
import com.ksumobileapp.ScheduleBuilder.EnrollmentService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.sql.*;

public class PaymentMain extends Application {

    @Override
    public void start(Stage primaryStage) {
    EnrollmentService enrollmentService = new EnrollmentService();
    double creditsBalance =  enrollmentService.getCreditForPayment() * 185.21;

        // Back button to return to Profile screen
        Button backButton = new Button("<");
        backButton.setOnAction(e -> {
            try {
                ProfileMain profile = new ProfileMain();
                Stage profileStage = new Stage();
                profile.start(profileStage);
                primaryStage.close(); // Close this window
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Position back button up top-left
        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_LEFT);
        backButtonContainer.setPadding(new Insets(10));

        // Title for the screen
        Label titleLabel = new Label("Student Account");
        titleLabel.setFont(new Font("Arial", 18));

        // === Here's where we pull the user's name and ID from the database ===
        String currentUserID = LoginModel.getCurrentUser();  // Get who's currently logged in
        String fullName = "Unknown"; // Default placeholder values
        String studentID = "Unknown";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:accounts.db");
             PreparedStatement stmt = conn.prepareStatement("SELECT firstName, lastName, studentID FROM users WHERE studentID = ?")) {

            stmt.setString(1, currentUserID); // Use logged-in ID to grab data
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fullName = rs.getString("firstName") + " " + rs.getString("lastName"); // Full name from DB
                studentID = rs.getString("studentID"); // Student ID
            }
        } catch (SQLException e) {
            e.printStackTrace(); // If something goes wrong, show the error
        }

        // === Calculate balance based on enrolled credits (credits * $121) ===


        // Display user's account information
        Label nameLabel = new Label("Name: " + fullName);
        Label idLabel = new Label("ID: " + studentID);
        Label balanceLabel = new Label(String.format("Balance: $%.2f", creditsBalance));

        double aidAmount = 961.60;
        Label aidLabel = new Label(String.format("Estimated Financial Aid: $%.2f", aidAmount));

// Calculate total balance after aid
        double finalBalance = creditsBalance - aidAmount;
        String formattedBalance = finalBalance < 0
                ? String.format("Credit Balance: -$%.2f", Math.abs(finalBalance))
                : String.format("Balance Due: $%.2f", finalBalance);

        Label totalLabel = new Label(formattedBalance);

        Label ebillLabel = new Label("Latest eBill Statement (1/8/25): -$3,238.00");

        // Stack all account-related info
        VBox accountInfoBox = new VBox(10, nameLabel, idLabel, balanceLabel, aidLabel, totalLabel, ebillLabel);
        accountInfoBox.setPadding(new Insets(10));
        accountInfoBox.setAlignment(Pos.TOP_LEFT);

        // Simple payment button
        Button makePaymentBtn = new Button("Make Payment");
        Label confirmationLabel = new Label();

        makePaymentBtn.setOnAction(e -> {
            try {
                // Open the new PaymentOptions screen
                PaymentOptions paymentOptions = new PaymentOptions();
                Stage paymentStage = new Stage();
                paymentOptions.start(paymentStage);

                // Close current Payment screen
                ((Stage) makePaymentBtn.getScene().getWindow()).close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox buttonBox = new VBox(10, makePaymentBtn, confirmationLabel);
        buttonBox.setAlignment(Pos.CENTER);

        // Whole middle content layout
        VBox contentBox = new VBox(20, titleLabel, accountInfoBox, buttonBox);
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.setPadding(new Insets(10));

        // Final layout: top = back button, middle = content
        VBox root = new VBox(backButtonContainer, contentBox);
        Scene scene = new Scene(root, 350, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setTitle("Payment");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // === Method to calculate balance from enrolled credits ===


    public static void main(String[] args) {
        launch(args);
    }
}
