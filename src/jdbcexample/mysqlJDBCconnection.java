/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void callMysqlStoreProcedure() {

        Connection myConn = null;
        CallableStatement myStmt = null;

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/US_LOCATIONS", "root", "PS");

            int state_id;
            state_id = 2;

            // Prepare the stored procedure call
            myStmt = myConn.prepareCall("{call get_count_for_US_CITIES(?, ?)}");

            // Set the parameters
            myStmt.setInt(1, state_id);
            myStmt.registerOutParameter(2, Types.INTEGER);

            // Call stored procedure
            System.out.println("Calling stored procedure.  get_count_for_US_CITIES('" + state_id + "', ?)");
            myStmt.execute();
            System.out.println("Finished calling stored procedure");

            // Get the value of the OUT parameter
            int theCount = myStmt.getInt(2);

            System.out.println("\nThe count = " + theCount);
        } catch (Exception exc) {

            exc.printStackTrace();
        } finally {
            try {
                close(myConn, myStmt);
            } catch (SQLException ex) {
                Logger.getLogger(mysqlJDBCconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private static void close(Connection myConn, Statement myStmt) throws SQLException {
        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

}
