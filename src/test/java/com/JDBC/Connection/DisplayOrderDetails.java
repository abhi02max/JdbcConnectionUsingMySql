package com.JDBC.Connection;

import java.sql.*;

public class DisplayOrderDetails {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/seleniumautomation", "root", "Abhi2005");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM order_new");

            System.out.printf("%-10s %-20s %-10s %-10s %-15s%n", 
                "Order ID", "Order Date", "Mode", "Cust ID", "Total");
            while (rs.next()) {
                System.out.printf("%-10d %-20s %-10s %-10d %-15.2f%n",
                    rs.getInt("order_id"),
                    rs.getString("order_date"),
                    rs.getString("order_mode"),
                    rs.getInt("customer_id"),
                    rs.getDouble("order_total"));
            }
            rs.close(); stat.close(); con.close();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
