/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cst8288Lab2.dataaccesslayer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DataSource class provides the connection to the database, and
 * uses the Singleton design pattern to ensure only one connection is created.
 * 
 * File: DataSource.java
 * Date: 6 July, 2024
 * 
 * @author yao yi
 */
public class DataSource {
    
    /**
     * The single connection instance.
     */
    private static Connection connection = null;

    /**
     * The private constructor.
     */
    private DataSource() { }

    /**
     * The public method to create a connection, if a connection already exists,
     * it returns the existing one. 
     *
     * @return a connection to the database
     */
    public static Connection getConnection() {
        String[] connectionInfo = openPropsFile();

        try {
            if (connection == null) { 
                String url = "jdbc:" + connectionInfo[0] + "://" + connectionInfo[2] + ":" + connectionInfo[4] + "/" + connectionInfo[1];
                connection = DriverManager.getConnection(url, connectionInfo[5], connectionInfo[3]);
            } else {
                System.out.println("Cannot create new connection, using existing one");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    /**
     * The private method to read the properties file and get connection info.
     *
     * @return an array of strings containing the database connection information
     */
    private static String[] openPropsFile() {
        
        Properties props = new Properties();

        try (InputStream in = Files.newInputStream(Paths.get("data/database.properties"));) {
            props.load(in);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }// catch()

        String db = props.getProperty("db");
        String name = props.getProperty("name");
        String host = props.getProperty("host");
        String password = props.getProperty("pass");
        String port = props.getProperty("port");
        String user = props.getProperty("user");
        
        String[] info = new String[6];
        info[0] = db;
        info[1] = name;
        info[2] = host;
        info[3] = password;
        info[4] = port;
        info[5] = user;

        return info;
    }
}