package connection;

import java.sql.*;

  public class DatabaseConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/salonbookingsystem";
        private static final String USER = "root";
        private static final String PASSWORD = "Achieve$1994";
        
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
