/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class MainController extends HttpServlet {

    public static final String LOGIN = "Login";
    public static final String LOGIN_CONTROLLER = "LoginController";

    public static final String REGISTER = "Register";
    public static final String REGISTER_CONTROLLER = "RegisterController";
    
    public static final String LOTTERY_RESULT = "LotteryResult";
    public static final String LOTTERY_RESULTGO = "LotteryResultGO";
    public static final String LOTTERY_RESULT_CONTROLLER = "LotteryResultController";
    public static final String LOTTERY_RESULT_PAGE = "lotteryResult.jsp";
    
    public static final String BUY_TICKET = "BuyTicketAuto";
    public static final String BUY_TICKET_CONTROLLER = "BuyTicketAutoController";    
    
    public static final String SAVE_DB = "saveDB";
    public static final String SAVE_DB_CONTROLLER = "saveDBController";
    
    public static final String START_ROUND = "startRound";
    public static final String START_ROUND_CONTROLLER = "StartRoundController";
    
    public static final String END_ROUND = "endRound";
    public static final String END_ROUND_CONTROLLER = "EndRoundController";
    
    public static final String CHECK_RESULT_TICKETS = "CheckResultTickets";
    public static final String CHECK_RESULT_TICKETS_CONTROLLER = "CheckResultTicketsController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "login.jsp";
        String action = request.getParameter("action");
        try {
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (REGISTER.equals(action)) {
                    url = REGISTER_CONTROLLER;
            } else if (LOTTERY_RESULT.equals(action)) {
                    url = LOTTERY_RESULT_PAGE;
            } else if (LOTTERY_RESULTGO.equals(action)) {
                    url = LOTTERY_RESULT_CONTROLLER;
            } else if (BUY_TICKET.equals(action)) {
                    url = BUY_TICKET_CONTROLLER;
            } else if (START_ROUND.equals(action)) {
                    url = START_ROUND_CONTROLLER;
            } else if (END_ROUND.equals(action)) {
                    url = END_ROUND_CONTROLLER;
            } else if (SAVE_DB.equals(action)) {
                    url = SAVE_DB_CONTROLLER;
            } else if (CHECK_RESULT_TICKETS.equals(action)) {
                    url = CHECK_RESULT_TICKETS_CONTROLLER;
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
