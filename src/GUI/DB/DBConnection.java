package GUI.DB;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author vedev
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/billing_system";    
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";   
    private static final String USERNAME = "root";   
    private static final String PASSWORD = "";
    private static Connection con;
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_NAME);
            try {
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                // log an exception. fro example:
                JOptionPane.showMessageDialog(null, ex.getMessage());
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Driver not found."); 
        }
        return con;
    }
}
