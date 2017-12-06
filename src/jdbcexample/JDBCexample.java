/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexample;

import java.sql.*;

/**
 *
 * @author ismailu
 */
public class JDBCexample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            System.out.println("try");
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/US_LOCATIONS", "root", "PS");
            System.out.println("myConn");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("SELECT * FROM US_LOCATIONS.US_CITIES;");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("CITY"));
            }
        } catch (Exception exc) {
        } finally {
            if (myRs != null) {
                //myRs.close();
            }

            if (myStmt != null) {
                // myStmt.close();
            }

            if (myConn != null) {
                //myConn.close();
            }
        }
    }

}
