/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vola
 */
public class DBConnection { 
    
    public static Connection psqlConnection() {
        try {
            Class.forName("org.postgresql.Driver");
        
            String url = "jdbc:postgresql://localhost:5432/resto";
            String user = "root";
            String pwd = "root";
            try {
                return DriverManager.getConnection(url, user, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Connection mysqlConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            String url = "jdbc:mysql://192.168.43.21:5432/restaurant";
            String user = "postgres";
            String pwd = "postgres";
            try {
                return DriverManager.getConnection(url, user, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
