/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.User;
import Utils.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 *
 * @author HP
 */
public class UserDAO {
    public String CHECKLOGIN = "SELECT user_id,username,password,registered_at FROM Users WHERE username=? AND password=?";
    public String REGISTER = "INSERT INTO Users(username,password) VALUES(?,?)";
    public User checkLogin(String name, String pass) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int id;
        LocalDateTime registerAt;
        try{
            conn = DBUtil.getConnection();
            pst = conn.prepareStatement(CHECKLOGIN);
            pst.setString(1, name);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getInt("user_id");
                registerAt = rs.getTimestamp("registered_at").toLocalDateTime();
                user = new User(pass, name, pass, registerAt);
            }
            
        }catch(Exception e){
            
        }finally{
            if(rs != null) rs.close();
            if(pst != null) pst.close();
            if(conn != null) conn.close();
        }
        return user;
    }

    public boolean checkRegister(String user, String pass) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            pst = conn.prepareStatement(REGISTER);
            pst.setString(1, user);
            pst.setString(2, pass);
            check = pst.executeUpdate()>0 ? true : false;
            
        }catch(Exception e){
        }finally{
             if(rs != null) rs.close();
            if(pst != null) pst.close();
            if(conn != null) conn.close();
        }
        return check;
    }
    
}
