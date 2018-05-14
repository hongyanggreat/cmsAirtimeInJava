/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.services;

import com.htc.airtime.components.Helper;
import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.ServicesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.htc.airtime.model.Services;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updateService", urlPatterns = {"/updateService"})
public class update extends HttpServlet {

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
            int idService = 0;
            String name = "";
            String alias = "";
            String description = "";
            int status = 0;
            boolean rs = false;
            String redirectURL = null;
            redirectURL = request.getContextPath() + "/services";
            if(request.getParameter("idService") !=null){
                idService = Integer.parseInt(request.getParameter("idService"));
            }
            name  = request.getParameter("name");
            alias = request.getParameter("alias");
            Helper helper = new Helper();
            if(!alias.isEmpty()){
                alias = helper.toSlug(alias);
            }else{
                alias = helper.toSlug(name);
            }
            description = request.getParameter("description");
          
            if(request.getParameter("status") !=null){
                status = Integer.parseInt(request.getParameter("status"));
            }
            try {
                Services dtn = new Services();

                dtn.setID(idService);
                dtn.setNAME(name);
                dtn.setALIAS(alias);
                dtn.setDESCRIPTION(description);
                dtn.setSTATUS(status);

                ServicesDAO dt = new ServicesDAO();
                rs = dt.update(dtn);
//                System.out.println("Ket qua :"+rs);
                 if (!rs) {
                    redirectURL = request.getContextPath() + "/services/update.jsp?id="+idService;
                }else{
                    redirectURL = request.getContextPath() + "/services/view.jsp?id="+idService;
                }
            } catch (Exception e) {
                System.out.println("--- 1.Lỗi rồi");
            }
//            System.out.println("duong dan redirect la : "+redirectURL);
            
            response.sendRedirect(redirectURL);
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
