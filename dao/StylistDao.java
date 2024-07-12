package dao;

import model.Stylist;
import connection.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StylistDao {
    public void addStylist(Stylist stylist) {
        String query = "INSERT INTO stylist (name, phone_number) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, stylist.getName());
            pstmt.setString(2, stylist.getPhoneNumber()); 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Stylist getStylist(int id) {
        String query = "SELECT * FROM stylist WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Stylist(rs.getString("name"), rs.getString("phone_number"), rs.getInt("id") ); // Assuming Service is an enum
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Stylist> getAllStylists() {
        List<Stylist> stylists = new ArrayList<>();
        String query = "SELECT * FROM stylist";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                stylists.add(new Stylist(rs.getString("name"), rs.getString("phone_number"), rs.getInt("id") ) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stylists;
    }

    public void updateStylist(Stylist stylist) {
        String query = "UPDATE stylist SET name = ?, phone_number = ?, job = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, stylist.getName());
            pstmt.setString(2, stylist.getPhoneNumber());
            pstmt.setInt(4, stylist.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStylist(String id) {
        String query = "DELETE FROM stylist WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
