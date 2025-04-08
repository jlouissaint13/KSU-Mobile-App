package com.ksumobileapp.StudentLookup;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class StudentLookupService {

    public boolean ifExistsID(String ID) {
        String url = "jdbc:sqlite:accounts.db";
        String sql = "Select studentID from users where studentID = ?";
        try (var conn = DriverManager.getConnection(url);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ID);
            var rs = pstmt.executeQuery();
            return Objects.equals(rs.getString(1), ID);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
