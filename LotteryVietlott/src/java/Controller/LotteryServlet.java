package Controller;

/**
 *
 * @author HP
 */

import Utils.DBUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/lottery")
public class LotteryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int numTickets = Integer.parseInt(request.getParameter("num_tickets"));
        int userId = 1;  // Assuming the user is already logged in with ID 1

        try (Connection conn = DBUtil.getConnection()) {
            for (int i = 0; i < numTickets; i++) {
                int ticketNumber = (int)(Math.random() * 9999) + 1; // Random ticket number
                String sql = "INSERT INTO LotteryTickets (user_id, ticket_number) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, userId);
                    stmt.setInt(2, ticketNumber);
                    stmt.executeUpdate();
                }
            }
            response.sendRedirect("lottery.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
