module com.ksumobileapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;



    exports com.ksumobileapp.Registration;
    opens com.ksumobileapp.Registration to javafx.fxml;
    exports com.ksumobileapp.Login;
    opens com.ksumobileapp.Login to javafx.fxml;
    exports com.ksumobileapp.Profile;
    opens com.ksumobileapp.Profile to javafx.fxml;
    exports com.ksumobileapp.Personal;
    opens com.ksumobileapp.Personal to javafx.fxml;
    exports com.ksumobileapp.Payments;
    opens com.ksumobileapp.Payments to javafx.fxml;
}