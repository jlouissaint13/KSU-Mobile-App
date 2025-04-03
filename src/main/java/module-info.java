module com.ksumobileapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ksumobileapp to javafx.fxml;
    exports com.ksumobileapp;
    exports com.ksumobileapp.Registration;
    opens com.ksumobileapp.Registration to javafx.fxml;
}