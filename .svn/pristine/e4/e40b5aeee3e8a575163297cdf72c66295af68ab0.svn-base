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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updateAcc", urlPatterns = {"/updateAcc"})
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
            int idUser = 0;
            Account acc = null;
            String userTypeSs = "";
            if (!Tool.checkNull(session.getAttribute("acc"))) {
                acc = (Account) session.getAttribute("acc");
                idUser = acc.getAccId();
                userTypeSs = AccountDAO.TYPE.getType(acc.getUserType()).toString();
            }

            int accId = 0;
            int parentId = 0;
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
            String redirectURL = null;
            redirectURL = request.getContextPath() + "/accounts";
            accId = Integer.parseInt(request.getParameter("accId"));
            parentId = Integer.parseInt(request.getParameter("parentId"));

            username = request.getParameter("username");
            password = request.getParameter("password");
            fullname = request.getParameter("fullname");
            description = request.getParameter("description");
            address = request.getParameter("address");
            phone = request.getParameter("phone");
            email = request.getParameter("email");
            //CHECK GET userType : NEU LA ADMIN or AGENCY_MANAGER thì phải khac 1 con neu = 3 thi phai la idUser = accID
            if ((userTypeSs.equals("ADMIN")) || (userTypeSs.equals("AGENCY_MANAGER") && (userType != 1)) || (userTypeSs.equals("AGENCY_MANAGER") && userType == 3 && idUser == accId)) {
                if (request.getParameter("userType") != null) {
                    userType = Integer.parseInt(request.getParameter("userType"));
                }
            }

            if (request.getParameter("status") != null) {
                status = Integer.parseInt(request.getParameter("status"));
            }

            try {
                Account dtn = new Account();

                dtn.setAccId(accId);
                dtn.setUserName(username);
                dtn.setPassword(password);
                dtn.setFullName(fullname);
                dtn.setDescription(description);
                dtn.setAddress(address);
                dtn.setPhone(phone);
                dtn.setEmail(email);

                dtn.setUserType(userType);
                dtn.setStatus(status);
                dtn.setUpdateBy(idUser);
//                int a = 2/0;
//                KIEM TRA NEU la ADMIN hoạc TAI KHOAN DANG NHAP = IDACC CAN CAP NHAT HOAC TAI KHOAN DANG NHAP LA PARENT_ID thi cho cap nhat
                if (userTypeSs.equals("ADMIN") || idUser == accId || idUser == parentId) {
                    AccountDAO dt = new AccountDAO();
                    rs = dt.update(dtn);
                    if (!rs) {
                        System.out.println("CAP NHAT KHONG THANH CONG");
                        //                    redirectURL = request.getContextPath() + "/accounts/update.jsp?id=" + accId;
                        RequestDispatcher rd = request.getRequestDispatcher("/accounts/update.jsp?id=" + accId);
                        request.setAttribute("err", "<span style='color:red'>Cập nhật thất bại</span>");
                        rd.include(request, response);
                        //                    request.setAttribute("error", "Unknown login, please try again."); // Set error.
                        //                    request.getRequestDispatcher("/accounts/update.jsp?id=" + accId).forward(request, response); // Forward to same page so that you can display error.
                    } else {
                        redirectURL = request.getContextPath() + "/accounts/view.jsp?id=" + accId;
                        response.sendRedirect(redirectURL);
                    }
                } else {
                    System.out.println("BAN SU DUNG SAI TINH NANG");
                    //                    redirectURL = request.getContextPath() + "/accounts/update.jsp?id=" + accId;
                    RequestDispatcher rd = request.getRequestDispatcher("/accounts/update.jsp?id=" + accId);
                    request.setAttribute("err", "<span style='color:red'>Đã ghi log.Cấm tuyệt đối với hành vi này.</span>");
                    rd.include(request, response);
                }
            } catch (Exception e) {
                System.out.println("Loi nhe");
                redirectURL = request.getContextPath() + "/accounts/view.jsp?id=" + accId;
                response.sendRedirect(redirectURL);
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
