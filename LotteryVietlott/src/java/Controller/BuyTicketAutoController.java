/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.LotteryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP
 */
@WebServlet(name = "BuyTicketAutoController", urlPatterns = {"/BuyTicketAutoController"})
public class BuyTicketAutoController extends HttpServlet {

    public String home_page = "lottery.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = home_page;
        try {
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USERID");
            int numTickets = Integer.parseInt(request.getParameter("numTickets"));

            Random rand = new Random();
            ArrayList<Integer> randomNumbers = new ArrayList<>();
            for (int i = 0; i < numTickets; i++) {
                int randomNum = rand.nextInt(99999) + 1;
                randomNumbers.add(randomNum);
            }

            LotteryDAO lotteryDAO = new LotteryDAO();
            boolean check = lotteryDAO.insertTickets(userID, randomNumbers);

            if (check) {
                System.out.println(randomNumbers.size());
                session.setAttribute("TICKETS", randomNumbers);
            }

        } catch (Exception e) {
            e.printStackTrace();
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
