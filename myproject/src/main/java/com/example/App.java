package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 * Hello world!
 *
 */
//TODO Preform A Curd Operation Using Statement And PreparedStatement

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://148.135.137.198/demo";
        String user = "demo";
        String password = "c5fn+g9Fb!6";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            String sql = "SELECT * FROM user  ";

            // Statement  stmt = conn.createStatement();

            // ResultSet rs= stmt.executeQuery(sql);

            // while(rs.next()){
            //   int id =   rs.getInt("id");
            //   String  empCode = rs.getString("emp_code");

            //   System.out.println("ID=>" + id + "Emp Code "+empCode);

            // }


            String insertSql = "INSERT INTO user (id,emp_code,reporting_manager_id,name,email,password,role_id,department_id) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(insertSql);
            ps.setInt(1,1);
            ps.setString(2,"EMP101");
            ps.setInt(3,1);
            ps.setString(4,"EMP");
            ps.setString(5,"email@gmail.com");
            ps.setString(6,"EMP101");
            ps.setInt(7,1);
            ps.setInt(8,1);

            int row = ps.executeUpdate();
            // int row = ps.executeUpdate();
            // int row = ps.executeUpdate();int row = ps.executeUpdate();
            // int row = ps.executeUpdate();int row = ps.executeUpdate();


            System.out.println(row +"Rows Inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
