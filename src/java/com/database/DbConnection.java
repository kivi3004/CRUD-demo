/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kirty
 */
public class DbConnection {
    public static Connection createConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "");

        } catch (Exception e) {
            System.out.print("ERROR");
        }

        return con;

    }

    public static int save(Emp e) {
        int status=0;
        try {
            Connection con = createConnection();
            //Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement("insert into emp (name, password, email, country) values (?,?,?,?)");
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            status = ps.executeUpdate();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static int delete(int id) {
        int status =0;
        try {
            Connection con = createConnection();
            //Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement("delete from emp where ID=?");
            
            ps.setInt(1, id);
            status = ps.executeUpdate();
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
        
    }
    
    public static int update(Emp e) {
        int status=0;
        try {
            Connection con = createConnection();
            //Statement stmt = con.createStatement();
            PreparedStatement ps = con.prepareStatement("update emp set NAME=?,PASSWORD=?,EMAIL=?,COUNTRY=? where ID=?");
            
            ps.setString(1, e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getCountry());
            ps.setInt(5, e.getId());
            System.out.println("ok");
            
            status = ps.executeUpdate();
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static Emp getDataById(int id){
        Emp e = new Emp();
        
        try{
            Connection con = DbConnection.createConnection();
            PreparedStatement ps=con.prepareStatement("select * from emp where id = ?");
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery(); 
            if(rs.next()){
                e.setID(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setEmail(rs.getString(4));
                e.setCountry(rs.getString(5));
            }
            con.close();
        }
        catch(Exception ep){
            ep.printStackTrace();
        }
        return e;
    }
    public static List<Emp> viewData(){
          
        List<Emp> list=new ArrayList<Emp>();  
        try{
            Connection con = createConnection();
            PreparedStatement ps=con.prepareStatement("select * from emp"); 
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){
                Emp e = new Emp();
                e.setID(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);                  
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
        
    } 
}
