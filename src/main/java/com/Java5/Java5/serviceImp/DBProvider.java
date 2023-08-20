/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Java5.Java5.serviceImp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class DBProvider {
     public static Connection getConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/java66";
        String userName = "root";
        String password = "";

        Connection conn = null;
        try {
            //call driver
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect db sucsess");

        } catch (Exception e) {
            System.out.println("connect db failed");
            e.printStackTrace();
        }
        return conn;

    }
}
