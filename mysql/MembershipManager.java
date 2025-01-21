package mysql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembershipManager {
    public void addMembership(int studentId, int clubId) throws SQLException {
        String query = "INSERT INTO memberships (student_id, club_id, join_date) VALUES (?, ?, ?)";
        Date currentDate = new Date(System.currentTimeMillis()); // Get today's date
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, studentId);
            stmt.setInt(2, clubId);
            stmt.setDate(3, currentDate); // Use today's date
            stmt.executeUpdate();
        }
    }

    public void viewMemberships() throws SQLException {
        String query = "SELECT s.name AS student_name, c.name AS club_name, m.join_date " +
                       "FROM memberships m " +
                       "JOIN students s ON m.student_id = s.id " +
                       "JOIN clubs c ON m.club_id = c.id";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Student: " + rs.getString("student_name") +
                                   ", Club: " + rs.getString("club_name") +
                                   ", Join Date: " + rs.getDate("join_date"));
                System.out.println();
            }
        }
    }
}
