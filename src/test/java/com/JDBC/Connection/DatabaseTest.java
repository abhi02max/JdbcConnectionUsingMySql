package com.JDBC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/seleniumautomation";
        String username = "root";
        String password = "Abhi2005";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement stat = con.createStatement();

            String query = "SELECT * FROM stu_detl";
            ResultSet rs = stat.executeQuery(query);

            System.out.println("====================");
            System.out.printf("%-10s %-15s %-15s %-10s%n", "Stu Code", "Student Name", "Dept Code", "Fine");
            System.out.println("====================");

            while (rs.next()) {
                String stuCode = rs.getString("stu_code");
                String studentName = rs.getString("name");
                String deptCode = rs.getString("dept_code");
                int fine = rs.getInt("fine");

                System.out.printf("%-10s %-15s %-15s %-10d%n", stuCode, studentName, deptCode, fine);
            }

            rs.close();
            stat.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
