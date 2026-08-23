package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args) {
        try {
           
            String url = "jdbc:mysql://localhost:3306/seleniumautomation";
            String user = "root";          
            String password = "Abhi2005";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database!");

            con.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
