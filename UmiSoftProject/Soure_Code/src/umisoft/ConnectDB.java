/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package umisoft;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnection(){
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=UMISOFT;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "sa";
            conn = DriverManager.getConnection(url, user, password);
            if(conn!=null)
                System.out.println("Connect done");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return conn;
    }
}
