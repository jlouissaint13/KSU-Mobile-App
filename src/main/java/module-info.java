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
    exports com.ksumobileapp.Schedule;
    opens com.ksumobileapp.Schedule to javafx.fxml;
    exports com.ksumobileapp.Admin;
    opens com.ksumobileapp.Admin to javafx.fxml;
    exports com.ksumobileapp.AdminReview;
    opens com.ksumobileapp.AdminReview to javafx.fxml;
    exports com.ksumobileapp.StudentLookup;
    opens com.ksumobileapp.StudentLookup to javafx.fxml;
    exports com.ksumobileapp.ScheduleBuilder;
    opens com.ksumobileapp.ScheduleBuilder to javafx.fxml;
    exports com.ksumobileapp.AcademicHistory;
    opens com.ksumobileapp.AcademicHistory to javafx.fxml;
    exports com.ksumobileapp.RecommendCourses;
    opens com.ksumobileapp.RecommendCourses to javafx.fxml;
    exports com.ksumobileapp.Advisor; // JavaFX access to AdvisorMain
}