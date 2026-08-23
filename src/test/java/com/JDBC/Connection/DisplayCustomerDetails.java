package com.JDBC.Connection;

import java.sql.*;

public class DisplayCustomerDetails {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/seleniumautomation", "root", "Abhi2005");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM cust_new");

            System.out.printf("%-10s %-15s %-20s %-10s%n", "Cust ID", "Last Name", "DOB", "Mgr ID");
            while (rs.next()) {
                System.out.printf("%-10d %-15s %-20s %-10d%n",
                    rs.getInt("customer_id"),
                    rs.getString("cust_last_name"),
                    rs.getString("date_of_birth"),
                    rs.getInt("account_mgr_id"));
            }
            rs.close(); stat.close(); con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
