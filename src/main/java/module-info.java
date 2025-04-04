module com.ksumobileapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.ksumobileapp to javafx.fxml;
    exports com.ksumobileapp;
    exports com.ksumobileapp.Registration;
    opens com.ksumobileapp.Registration to javafx.fxml;
    exports com.ksumobileapp.Login;
    opens com.ksumobileapp.Login to javafx.fxml;
}