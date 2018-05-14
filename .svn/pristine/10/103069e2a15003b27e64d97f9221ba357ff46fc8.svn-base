/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.accounts;

import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.htc.airtime.model.Account;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "addAcc", urlPatterns = {"/addAcc"})
public class add extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
            String username = "";
            String password = "";
            String fullname = "";
            String description = "";
            String address = "";
            String phone = "";
            String email = "";
            int userType = 0;
            int status = 0;
            boolean rs = false;

            if (!Tool.checkNull(request.getParameter("username"))) {
                username = request.getParameter("username").trim();
            }
            if (!Tool.checkNull(request.getParameter("password"))) {
                password = request.getParameter("password").trim();
            }
            if (!Tool.checkNull(request.getParameter("fullname"))) {
                fullname = request.getParameter("fullname").trim();
            }
            if (!Tool.checkNull(request.getParameter("description"))) {
                description = request.getParameter("description").trim();
            }
            if (!Tool.checkNull(request.getParameter("address"))) {
                address = request.getParameter("address").trim();
            }
            if (!Tool.checkNull(request.getParameter("phone"))) {
                phone = request.getParameter("phone").trim();
            }
            if (!Tool.checkNull(request.getParameter("email"))) {
                email = request.getParameter("email").trim();
            }

            if (!Tool.checkNull(request.getParameter("userType"))) {
                userType = Integer.parseInt(request.getParameter("userType"));
            }
            if (!Tool.checkNull(request.getParameter("status"))) {
                status = Integer.parseInt(request.getParameter("status"));
            }

            int idUser = 0;
            if (!Tool.checkNull(session.getAttribute("acc"))) {
                Account acc = (Account) session.getAttribute("acc");
                idUser = acc.getAccId();
            }
            if (Tool.checkNull(username) || Tool.checkNull(password)) {
                Account dtn = new Account();
                dtn.setUserName(username);
                dtn.setPassword(password);
                dtn.setFullName(fullname);
                dtn.setDescription(description);
                dtn.setAddress(address);
                dtn.setPhone(phone);
                dtn.setEmail(email);
                dtn.setAddress(address);
                dtn.setUserType(userType);
                dtn.setStatus(status);

                System.out.println("YEU CAU KHONG DC DE TRONG CAC TRUONG");
                session.setAttribute("accSs", dtn);
                session.setAttribute("notification", "Yêu cầu nhập đầy đủ thông tin vào các trường!");
                response.sendRedirect(request.getContextPath() + "/accounts/add.jsp");
                return;
            } else {
                try {
                    Account dtn = new Account();

                    dtn.setUserName(username);
                    dtn.setPassword(password);
                    dtn.setFullName(fullname);
                    dtn.setDescription(description);
                    dtn.setAddress(address);
                    dtn.setPhone(phone);
                    dtn.setEmail(email);
                    dtn.setUserType(userType);
                    dtn.setStatus(status);
                    dtn.setParentId(idUser);
                    dtn.setCreateBy(idUser);

                    AccountDAO dt = new AccountDAO();
                    rs = dt.add(dtn);
                    System.out.println("Ket qua :" + rs);
                    if (!rs) {
                        response.sendRedirect(request.getContextPath() + "/accounts/add.jsp");
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("--- 1.Lỗi rồi");
                }
            }
            response.sendRedirect(request.getContextPath() + "/accounts");
            return;
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
