package com.ksumobileapp.Profile;

public class ProfileModel {
    private static String status;

    public static void setStatus(String status) {
        ProfileModel.status = status;
    }

    public static String getStatus() {
        return ProfileModel.status;
    }


}
