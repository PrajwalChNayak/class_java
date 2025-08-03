package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://148.135.137.198/demo";
        String user = "demo";
        String password = "c5fn+g9Fb!6";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
