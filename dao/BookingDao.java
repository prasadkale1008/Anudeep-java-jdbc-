package dao;

import model.Booking;
import model.Customer;
import model.Stylist;
import connection.DatabaseConnection;
import model.Date; 
import model.Time;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
    // Add a new booking to the database
    public void createBooking(Booking booking) {
        String query = "INSERT INTO booking (stylist_id, customer_id, date, time, price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query)) { 
            System.out.println( "test : " + booking.getCustomer() );
            
            pstmt.setInt(1, booking.getStylist().getId());
            pstmt.setInt( 2, booking.getCustomer().getId());
            pstmt.setDate(3, booking.getDate().toSqlDate());
            pstmt.setTime(4, booking.getTime().toSqlTime());
            pstmt.setDouble(5, booking.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a booking by ID
    public Booking getBooking(int id) {
        String query = "SELECT * FROM booking WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                CustomerDao customerDao = new CustomerDao();
                StylistDao stylistDao = new StylistDao();

                // Fetch customer and stylist details separately if needed
                Customer customer = customerDao.getCustomer(rs.getInt("customer_id"));
                Stylist stylist = stylistDao.getStylist(rs.getInt("stylist_id"));
               
                Booking booking = new Booking(customer, stylist, Date.fromSqlDate( rs.getDate("date") ), Time.fromSqlTime( rs.getTime("time") ), rs.getDouble("price") );
                return booking;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all bookings from the database
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM booking";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CustomerDao customerDao = new CustomerDao();
                StylistDao stylistDao = new StylistDao();

                // Fetch customer and stylist details separately if needed
                Customer customer = customerDao.getCustomer(rs.getInt("customer_id"));
                Stylist stylist = stylistDao.getStylist(rs.getInt("stylist_id"));
                Booking booking = new Booking(rs.getInt("id"), customer, stylist, Date.fromSqlDate( rs.getDate("date") ), Time.fromSqlTime( rs.getTime("time") ), rs.getDouble("price") );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Update an existing booking
    public void updateBooking(Booking booking) {
        String query = "UPDATE booking SET customer_id = ?, stylist_id = ?, date = ?, time = ?, price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, booking.getCustomer().getId());
            pstmt.setInt(2, booking.getStylist().getId());
            pstmt.setDate(3, booking.getDate().toSqlDate());
            pstmt.setTime(4, booking.getTime().toSqlTime());
            pstmt.setDouble(5, booking.getPrice());
            pstmt.setInt(6, booking.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a booking by ID
    public boolean deleteBooking(int id) {
        String query = "DELETE FROM booking WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
         
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
