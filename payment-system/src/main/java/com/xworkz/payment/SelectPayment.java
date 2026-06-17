package com.xworkz.payment;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectPayment {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("The driver is loaded.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String url = "jdbc:mysql://localhost:3306/hemanthdb";
        String username = "root";
        String password = "hemanth@mysql";
        String sqlQuery = "SELECT* from payment_info";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hemanthdb","root","hemanth@mysql");
            System.out.println("Connection established.");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);


            while(resultSet.next()){
                System.out.println(resultSet.getInt("account_no"));
                System.out.println(resultSet.getString("holder_name"));
                System.out.println(resultSet.getInt("amount"));
                System.out.println(resultSet.getString("payment_type"));
                System.out.println(resultSet.getString("payment_date"));
                System.out.println("___________________________________");
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                assert statement != null;
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
