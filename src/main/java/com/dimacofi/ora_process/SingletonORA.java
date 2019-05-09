/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dimacofi.ora_process;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author apracticati1
 */
public class SingletonORA {
    
    private static SingletonORA instance;
    private Connection connection;
    private String ip;
    private String port;
    private String bd;
    private String username = "SAI";
    private String password = "sai";

    
 
    
    
    
    private SingletonORA() throws SQLException, IOException {
        
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@100.8.99.140:1521:TESTDIM", "SAI", "sai");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws IOException
     */
    public static SingletonORA getInstance() throws SQLException, IOException {
        if (instance == null) {
            instance = new SingletonORA();
        } else if (instance.getConnection().isClosed()) {
            instance = new SingletonORA();
        }

        return instance;
    }
}
