/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hp
 */
public class DBConnection {

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql:///usermaintenance";
            conn = DriverManager.getConnection(url, "root", "");

        } catch (Exception e) {
            System.out.println("Exception in connect() : " + e);
        }
        return conn;
    }
}
