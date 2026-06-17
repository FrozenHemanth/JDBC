package com.xworkz.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeletePayment {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver loaded succesfullly");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection= null;
        Statement statement=null;
        String sqlQuery="delete from payment_info where account_no = 1001";
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemanthdb","root", "hemanth@mysql");
            System.out.println("Connection built successfully");
            statement = connection.createStatement();
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
