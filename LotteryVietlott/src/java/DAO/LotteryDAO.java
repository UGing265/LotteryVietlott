/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LotteryDAO {

    public String INSERT_TIKCETS = "INSERT INTO LotteryTickets(userID,ticketNumber, isWin, isCheck) VALUES(?,?,0 ,0);";
    public boolean insertTickets(String userID, ArrayList<Integer> randomNumbers) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            for(int num : randomNumbers){
            
            pst = conn.prepareStatement(INSERT_TIKCETS);
            pst.setString(1, userID);
            pst.setInt(2, num);
            
            check = pst.executeUpdate()>0 ? true : false;
            }
            
        }catch(Exception e){
        }finally{
             if(rs != null) rs.close();
            if(pst != null) pst.close();
            if(conn != null) conn.close();
        }
        return check;
    }
    
}
