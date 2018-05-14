/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.modules;

import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.ModulesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.htc.airtime.model.Modules;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "addModule", urlPatterns = {"/addModule"})
public class add extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            //KIEM TRA DA DANG NHAP CHUA 
            if (Tool.checkNull(session.getAttribute("acc"))) {
                response.sendRedirect(request.getContextPath() + "/");
                return;
            }
            request.setCharacterEncoding("UTF-8");
            String resouse = "";
            String name = "";
            String description = "";
            int type = 0;
            int status = 0;
            boolean rs = false;
            String redirectURL = null;
            redirectURL = request.getContextPath() + "/modules";

            if (!Tool.checkNull(request.getParameter("resouse"))) {
                resouse = request.getParameter("resouse").trim();
            }
            if (!Tool.checkNull(request.getParameter("name"))) {
                name = request.getParameter("name").trim();
            }
            if (!Tool.checkNull(request.getParameter("description"))) {
                description = request.getParameter("description").trim();
            }
            if (!Tool.checkNull(request.getParameter("type"))) {
                type = Integer.parseInt(request.getParameter("type"));
            }
            if (!Tool.checkNull(request.getParameter("status"))) {
                status = Integer.parseInt(request.getParameter("status"));
            }
            try {
                Modules dtn = new Modules();

                dtn.setRESOURCE(resouse);
                dtn.setNAME(name);
                dtn.setDESCRIPTION(description);
                dtn.setTYPE(type);
                dtn.setSTATUS(status);

                ModulesDAO dt = new ModulesDAO();
                rs = dt.add(dtn);
                System.out.println("Ket qua :" + rs);
                if (!rs) {
                    response.sendRedirect(request.getContextPath() + "/modules/add.jsp");
                    return;
                }

            } catch (Exception e) {
                System.out.println("--- 1.Lỗi rồi");
            }
            response.sendRedirect(request.getContextPath() + "/modules");
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
