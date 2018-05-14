/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.auth;

import com.htc.airtime.components.Helper;
import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.AccountDAO;
import com.htc.airtime.dao.UserPermissionDAO;
import com.htc.airtime.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    static final Logger logger = Logger.getLogger(login.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (!Tool.checkNull(session.getAttribute("acc"))) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
            String userName = "";
            String password = "";
            String remember = "";
            if (!Tool.checkNull(request.getParameter("username"))) {
                userName = request.getParameter("username").trim();
            }
            if (!Tool.checkNull(request.getParameter("password"))) {
                password = request.getParameter("password").trim();
            }
            AccountDAO accountDAO = new AccountDAO();

            password = Helper.generatePassword(userName.trim() + password.trim());
            Account acc = accountDAO.checkLogin(userName, password);
            if (acc != null) {
                session.setAttribute("acc", acc);
                //CACHE QUYEN CUA USER 
                int AccID = acc.getAccId();
                UserPermissionDAO userPermissionDAO = new UserPermissionDAO();
                ArrayList userPermission = null;
                try {
                    userPermission = userPermissionDAO.getListModuleUserPermissionAcctive(AccID);
                    session.setAttribute("userPermission", userPermission);
                } catch (Exception ex) {
                    logger.error(Tool.getLogMessage(ex));
                }
                response.sendRedirect(request.getContextPath() + "/");
                return;
            } else {
                session.setAttribute("mess", "Tài khoản hoặc mật khẩu không đúng!");
                request.getRequestDispatcher("/login.jsp").include(request, response);
                return;
            }
            
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
