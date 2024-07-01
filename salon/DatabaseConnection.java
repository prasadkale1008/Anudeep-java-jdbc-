package Salon;

import java.sql.*;

  public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/salon_booking";
        private static final String USER = "your_username";
        private static final String PASSWORD = "your_password";
        
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        
        public static void closeConnection(Connection connection) {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
