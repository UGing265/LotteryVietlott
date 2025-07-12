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

    public String INSERT_TIKCETS = "INSERT INTO LotteryTickets(userID, ticketNumber,roundID, isWin, isCheck) VALUES(?,?,?,0 ,0);";
    public String INSERT_RESULTS = "INSERT INTO WinningNumbers(tierID, roundID, winningNumber) VALUES(1,?,?)";
    public String GET_TICKETS = "SELECT ticketNumber FROM LotteryTickets WHERE userID=? AND roundID=?";
    public String GET_WINNING_NUM = "SELECT winningNumber FROM WinningNumbers WHERE  roundID=?";

    public boolean insertTickets(String userID, ArrayList<Integer> randomNumbers,int roundID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            for (int num : randomNumbers) {

                pst = conn.prepareStatement(INSERT_TIKCETS);
                pst.setString(1, userID);
                pst.setInt(2, num);
                pst.setInt(3, roundID);

                check = pst.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean saveResult(int roundID, ArrayList<Integer> randomNumbers) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            for (int num : randomNumbers) {
                pst = conn.prepareStatement(INSERT_RESULTS);
                pst.setInt(1, roundID);
                pst.setInt(2, num);

                check = pst.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

       public ArrayList<Integer> getTicketsByUserID(String userID, int roundID) throws SQLException {
        ArrayList<Integer> tickets = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int ticketNumber;
        try {
            conn = DBUtil.getConnection();

                pst = conn.prepareStatement(GET_TICKETS);
                pst.setString(1, userID);
                pst.setInt(2, roundID);

                rs = pst.executeQuery();
                while(rs.next()){
                    ticketNumber = rs.getInt("ticketNumber");
                    tickets.add(ticketNumber);
                }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return tickets;
    }

    public ArrayList<Integer> getWinNumByRoundID(int roundID) throws SQLException {
        ArrayList<Integer> winNum = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int ticketNumber;
        try {
            conn = DBUtil.getConnection();

                pst = conn.prepareStatement(GET_WINNING_NUM);
                pst.setInt(1, roundID);

                rs = pst.executeQuery();
                while(rs.next()){
                    ticketNumber = rs.getInt("winningNumber");
                    winNum.add(ticketNumber);
                }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return winNum;
    }

}
