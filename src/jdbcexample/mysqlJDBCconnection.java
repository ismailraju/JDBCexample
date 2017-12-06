/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexample;

import java.sql.*;
import static javax.swing.text.html.HTML.Tag.SELECT;

/**
 *
 * @author ismailu
 */
public class mysqlJDBCconnection {

    public void connectionTest() {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/US_LOCATIONS", "root", "PS");

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("SELECT * FROM US_LOCATIONS.US_CITIES;");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("CITY"));
            }
        } catch (Exception exc) {

            exc.printStackTrace();
        }

    }

    public void prepareStatment() {

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/US_LOCATIONS", "root", "PS");

            //2. Create a statement
            myStmt = myConn.prepareStatement("SELECT * FROM US_LOCATIONS.US_CITIES where ID_STATE =  ?");

            //3. Execute SQL query
            myStmt.setDouble(1, 2);

            //4. Execute SQl query
            myRs = myStmt.executeQuery();

            // 5. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("ID_STATE") + "," + myRs.getString("CITY"));
            }
        } catch (Exception exc) {

            exc.printStackTrace();
        }

    }

}
