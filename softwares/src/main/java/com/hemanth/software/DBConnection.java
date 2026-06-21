package com.hemanth.software;

import com.sun.jdi.connect.spi.Connection;

import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/software_db","root","hemanth@mysql");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
