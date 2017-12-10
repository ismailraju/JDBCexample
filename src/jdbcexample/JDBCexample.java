/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcexample;

import java.sql.*;
import java.io.*;

/**
 *
 * @author ismailu
 */
public class JDBCexample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        mysqlJDBCconnection mysqlJDBCconnectionObject = new mysqlJDBCconnection();
        //mysqlJDBCconnectionObject.connectionTest();
        //mysqlJDBCconnectionObject.prepareStatment();
        //mysqlJDBCconnectionObject.callMysqlStoreProcedure();
        mysqlJDBCconnectionObject.transactionDemo();

    }

}
