package com.xworkz.payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePayment {
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection= null;
        Statement statement=null;
        String sqlQuery="update payment_info set payment_type = 'CASH' where account_no = 1002";
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemanthdb","root","hemanth@mysql");
            System.out.println("connection built succesfuly");
            statement=connection.createStatement();
            statement.executeUpdate(sqlQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
