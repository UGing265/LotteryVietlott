/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lottery;

/**
 *
 * @author HP
 */

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/lotteryResult")
public class LotteryResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int resultNumber = (int)(Math.random() * 9999) + 1; // Random lottery result number

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO LotteryResults (result_number) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, resultNumber);
                stmt.executeUpdate();
            }

            String checkSql = "SELECT * FROM LotteryTickets WHERE ticket_number = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setInt(1, resultNumber);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    response.getWriter().println("You have won the lottery with ticket number: " + resultNumber);
                } else {
                    response.getWriter().println("Sorry, you did not win. The winning number was " + resultNumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

