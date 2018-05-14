/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.userService.svAirtime;

import com.htc.airtime.components.Helper;
import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.ServicesDAO;
import com.htc.airtime.dao.UserServicesDAO;
import com.htc.airtime.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.htc.airtime.model.Services;
import com.htc.airtime.model.UserServices;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "addServiceAirtime", urlPatterns = {"/addServiceAirtime"})
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
        String baseUrl = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");
            int idUser = 0;
            if (!Tool.checkNull(session.getAttribute("acc"))) {
                Account acc = (Account) session.getAttribute("acc");
                idUser = acc.getAccId();
            }else{
                response.sendRedirect(baseUrl + "/");
                return;
            }
            String cp_code = "";
            String gameName = "";
            String gameCode = "";
            String username = "";

            String servicePin = "";
            String accessKey = "";
            String secretKey = "";
            
            int idService = 0;
            String ipAllow = "";
            String optionData = "";
            String description = "";
            int status = 0;
            boolean rs = false;
            String redirectURL = null;
            redirectURL = request.getContextPath() + "/airtimeManager";
            cp_code = request.getParameter("cp_code");
            gameName = request.getParameter("gameName");
            gameCode = request.getParameter("gameCode");
            username = request.getParameter("username");

            servicePin = Tool.getRandomString(18);
            accessKey = Tool.getRandomString(18);
            secretKey = Tool.getRandomString(18);

            idService = Integer.parseInt(request.getParameter("idService"));

            ipAllow = request.getParameter("ipAllow");
            optionData = request.getParameter("optionData");
            description = request.getParameter("description");
//            out.print(gameCode);
            if (request.getParameter("status") != null) {
                status = Integer.parseInt(request.getParameter("status"));
            }
            try {
                UserServices dtn = new UserServices();

                dtn.setCpCode(cp_code);
                dtn.setGameName(gameName);
                dtn.setCodeGame(gameCode);
                dtn.setUserName(username);
                dtn.setServicePin(servicePin);
                dtn.setAccessKey(accessKey);
                dtn.setSecretKey(secretKey);
                dtn.setServiceType(idService);
                dtn.setIpAllow(ipAllow);
                dtn.setOptionData(optionData);
                dtn.setDescription(description);
                dtn.setStatus(status);
                UserServicesDAO dt = new UserServicesDAO();
                rs = dt.add(dtn);
                out.println("Ket qua :" + rs);
                if (!rs) {
                    redirectURL = request.getContextPath() + "/airtimeManager/add.jsp";
                }

            } catch (Exception e) {
                System.out.println("--- 1.Lỗi rồi");
            }
//            out.println("duong dan redirect la : "+redirectURL);
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
