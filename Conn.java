package universty.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    Conn() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Correct the JDBC URL
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/subbrotoray", "root", "123456");

            // Create a statement object
            s = c.createStatement();

            System.out.println("Connection Established Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn(); // Test the connection
    }
}
