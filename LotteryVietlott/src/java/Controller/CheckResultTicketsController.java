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

/**
 *
 * @author HP
 */
@WebServlet(name = "CheckResultTicketsController", urlPatterns = {"/CheckResultTicketsController"})
public class CheckResultTicketsController extends HttpServlet {

    public String page = "lotteryResult.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = page;
        try {
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USERID");
            int roundID = (int) session.getAttribute("ROUND_NUMBER");
            LotteryDAO lotteryDAO = new LotteryDAO();
            ArrayList<Integer> winningNumber = lotteryDAO.getWinNumByRoundID(roundID);
            ArrayList<Integer> tickets = lotteryDAO.getTicketsByUserID(userID, roundID);
            int flag = 0;
            System.out.println("winn: "+winningNumber);
            System.out.println("tickets: " + tickets);
            for (int t : tickets) {
                   for(int w : winningNumber){
                       if(t == w){
                           System.out.println("this tickets is win:"+t);
                           flag=1;
                       }
                   }
                }
            if(flag == 1){
                request.setAttribute("SUCCESS", "WINNNNN");
            }else{
                request.setAttribute("ERROR", "YOU LOSE");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    public String getLastDigits(int number, int length) {
        String numStr = String.format("%0" + length + "d", number);  // zero-padding nếu cần
        if (numStr.length() <= length) {
            return numStr;
        }
        return numStr.substring(numStr.length() - length);
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
