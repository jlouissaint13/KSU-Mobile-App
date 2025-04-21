package com.ksumobileapp.Profile;

import com.ksumobileapp.AcademicHistory.AcademicHistory;
import com.ksumobileapp.Admin.AdminModel;
import com.ksumobileapp.Login.LoginMain;
import com.ksumobileapp.Login.LoginModel;
import com.ksumobileapp.Payments.PaymentMain;
import com.ksumobileapp.Personal.PersonalMain;
import com.ksumobileapp.RecommendCourses.RecommendationMain;
import com.ksumobileapp.Registration.RegisterModel;
import com.ksumobileapp.Schedule.ScheduleMain;
import com.ksumobileapp.ScheduleBuilder.SemesterMain;
import com.ksumobileapp.Advisor.AdvisorMain;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Optional;

public class ProfileController {
    private ProfileView profileView;
    private Stage stage;
    private Button backButton,viewInfo,payOnline,schedule,viewAcademic, recCourses;
    private LoginMain loginMain;
    private PersonalMain personalMain;
    private PaymentMain paymentMain;
    private ScheduleMain scheduleMain;
    private SemesterMain semesterMain;
    private AcademicHistory academicHistory;
    private RecommendationMain recommendationMain;
    private Button digitalAdvisor;
    private AdvisorMain advisorMain;

    public ProfileController(Stage stage, ProfileView profileView) {
        this.profileView = profileView;
        loginMain = new LoginMain();

        ProfileService profileService = new ProfileService();
        profileService.setStatus();
        if (!ProfileModel.getStatus().equals("Accepted")) this.profileView.disableButtons();
        personalMain = new PersonalMain();
        paymentMain = new PaymentMain();
        semesterMain = new SemesterMain();
        academicHistory = new AcademicHistory();
        recommendationMain = new RecommendationMain();
        backButton = profileView.getBackButton();
        viewInfo = profileView.getViewInformation();
        payOnline = profileView.getPayCourses();
        schedule = profileView.getScheduleBuilder();
        viewAcademic = profileView.getViewCourses();
        recCourses = profileView.getRecCourses();
        advisorMain = new AdvisorMain();
        digitalAdvisor = profileView.getDigitalAdvisor();



        viewInfo.setOnAction(e -> viewInfo(stage,personalMain));
        payOnline.setOnAction(e ->  paymentMain.start(stage));
        schedule.setOnAction(e -> semesterMain.start(stage));
        viewAcademic.setOnAction(e-> academicHistory.start(stage));
        recCourses.setOnAction(e -> {
            try {
                recommendationMain.start(stage);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        digitalAdvisor.setOnAction(e -> {
            try {
                advisorMain.start(stage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });



        backButton.setOnAction(e-> {
            LoginModel.resetLogin();
            RegisterModel.resetStudentID();;
            back(stage,loginMain);
        });
    }


    public void back(Stage stage,LoginMain loginMain) {
        loginMain.start(stage);
    }
    public void viewInfo(Stage stage,PersonalMain personalMain) {
        personalMain.start(stage);
    }


}
