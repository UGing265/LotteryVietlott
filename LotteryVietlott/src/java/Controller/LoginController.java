/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.RoundDAO;
import DAO.UserDAO;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name="LoginController", urlPatterns={"/LoginController"})
public class LoginController extends HttpServlet {
   
   public String  SUCCESS = "lottery.jsp";
   public String ERROR = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      String url = ERROR;
      try{
          HttpSession session = request.getSession();
          String name = request.getParameter("username");
          String pass = request.getParameter("password");
          UserDAO userDAO = new UserDAO();
          RoundDAO roundDAO = new RoundDAO();
          User user = userDAO.checkLogin(name,pass);
          if(user != null){
              session.setAttribute("ROUND_NUMBER", roundDAO.getIDbyRound());
              session.setAttribute("USERID", user.getUserID());
              url = SUCCESS;
              System.out.println("success");
          }
          
          
      }catch(Exception e){
          e.printStackTrace();
      }finally{
          request.getRequestDispatcher(url).forward(request, response);
      }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
