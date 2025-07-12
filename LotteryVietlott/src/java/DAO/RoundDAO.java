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
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class RoundDAO {

    public String INSERT_ROUNDS = "INSERT INTO Rounds (roundDate, status) VALUES (?, ?)";
    public String SELECT_ROUNDS = "SELECT TOP 1 roundID FROM Rounds WHERE status = 'Open' ORDER BY roundID DESC";
    public String SET_ROUNDS = "UPDATE Rounds\n"
            + "SET status = 'Closed'\n"
            + "WHERE status = 'Open';";

    public boolean insertRound(LocalDate nowDate, String open) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            pst = conn.prepareStatement(INSERT_ROUNDS);
            pst.setDate(1, java.sql.Date.valueOf(nowDate));
            pst.setString(2, open);

            check = pst.executeUpdate() > 0 ? true : false;

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

    public int getIDbyRound() throws SQLException {
        int roundID = 0;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pst = conn.prepareStatement(SELECT_ROUNDS);
            rs = pst.executeQuery();
            while (rs.next()) {
                roundID = rs.getInt("roundID");
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
        return roundID;
    }

    public boolean setCloseRound() throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            pst = conn.prepareStatement(SET_ROUNDS);
            check = pst.executeUpdate()>0 ? true:false;

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
}
