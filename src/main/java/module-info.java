module com.ksumobileapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ksumobileapp to javafx.fxml;
    exports com.ksumobileapp;
}