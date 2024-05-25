/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SqlServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author linh
 */
public class ConnectDB {
    private Connection con;
    public void Open() throws ClassNotFoundException, SQLException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;database=QLCP;encrypt=true;trustServerCertificate=true;user=sa;password=Linh123456";
            con = DriverManager.getConnection(connectionUrl);
            System.out.println("Connected to SQL Server!"); 
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    
    public void Close(){
        try {
            this.con.close();
        } 
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        Statement sm = null;
        try {
            sm = con.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    
    
    public ResultSet executeQueryP(String sql, String para){
        ResultSet rs = null;
        try{
            PreparedStatement preSm = con.prepareStatement(sql);
            preSm.setString(1,para);
            rs = preSm.executeQuery();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate(String sql){
        int n =-1;
        try{
            Statement sm = con.createStatement();
            n = sm.executeUpdate(sql);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return n;
    }
    
    
}
