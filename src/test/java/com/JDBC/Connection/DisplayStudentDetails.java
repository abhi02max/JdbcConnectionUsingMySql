package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudentDetails {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Abhi2005";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement stat = con.createStatement();

            String query = "SELECT * FROM book_detl";
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                String auth = rs.getString("author");
                String tit = rs.getString("title");
                System.out.println("author: " + auth + ", title: " + tit);
            }

            rs.close();
            stat.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
