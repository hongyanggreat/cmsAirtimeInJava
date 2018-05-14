/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.userPermissionChild;

import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.AccountDAO;
import com.htc.airtime.servlet.userPermission.*;
import com.htc.airtime.dao.UserPermissionDAO;
import com.htc.airtime.model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.htc.airtime.model.UserPermission;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "addUserPermissionChild", urlPatterns = {"/addUserPermissionChild"})
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
        String baseUrl = request.getContextPath();
        request.setCharacterEncoding("UTF-8");
        boolean rs = false;
        String redirectURL = null;
        redirectURL = baseUrl + "/userPermission";
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String updateOne = request.getParameter("updateOne");
            String strIdModule = "";
            int idUser = 0;
            System.out.println("THE NAO NHI");
            if (!Tool.checkNull(session.getAttribute("acc"))) {
                System.out.println("CO TK DANG NHAP SAO");
                Account acc = (Account) session.getAttribute("acc");
                idUser = acc.getAccId();
            } else {
                System.out.println("CO CHUYEN HUONG KHONG");
                response.sendRedirect(baseUrl + "/");
                return;
            }
            int idAcc = 0;
            if (!Tool.checkNull(request.getAttribute("idAcc"))) {
                idAcc = Integer.parseInt(request.getParameter("idAcc"));
            }
            System.out.println("CHECK XEM CO QUYEN VOI TAI KHOAN NAY KHONG");
            boolean checkChild = AccountDAO.checkIsParent(idAcc, idUser);
            if (!checkChild) {
                response.sendRedirect(baseUrl + "/userPermissionChild");
                return;
            }
            if (updateOne != null) {
                if (updateOne.equals("updateAll")) {
                    System.out.println("VAO DAY KHONG");
                    //out.print("cap nhat tat ca");
                    Enumeration enumer = request.getParameterNames();
                    while (enumer.hasMoreElements()) {
                        String nextElement = (String) enumer.nextElement();
                        String input = "idModule";
                        boolean moduleChecked = checkString(nextElement, input);
                        if (moduleChecked) {
                            int idModule = Integer.parseInt(request.getParameter(nextElement));
                            String actionModule = request.getParameter("actionModule" + idModule);
                            //Kiểm tra xem  actionModule co phai updateOne addOne 
                            if (actionModule.equals("updateOne") || actionModule.equals("addOne")) {

                                boolean allRight = (request.getParameter("allRight" + idModule) != null) ? true : false;
                                boolean listRight = (request.getParameter("listRight" + idModule) != null) ? true : false;
                                boolean viewRight = (request.getParameter("viewRight" + idModule) != null) ? true : false;
                                boolean addRight = (request.getParameter("addRight" + idModule) != null) ? true : false;
                                boolean editRight = (request.getParameter("editRight" + idModule) != null) ? true : false;
                                boolean deleteRight = (request.getParameter("deleteRight" + idModule) != null) ? true : false;
                                boolean upRight = (request.getParameter("upRight" + idModule) != null) ? true : false;
                                boolean downRight = (request.getParameter("downRight" + idModule) != null) ? true : false;
                                int status = (request.getParameter("status" + idModule) != null) ? 1 : 0;

                                try {
                                    UserPermission dtn = new UserPermission();

                                    dtn.setACC_ID(idAcc);
                                    dtn.setMODULE_ID(idModule);
                                    dtn.setALL_RIGHT(allRight);
                                    dtn.setLIST_RIGHT(listRight);
                                    dtn.setVIEW_RIGHT(viewRight);
                                    dtn.setADD_RIGHT(addRight);
                                    dtn.setEDIT_RIGHT(editRight);
                                    dtn.setDEL_RIGHT(deleteRight);
                                    dtn.setUP_RIGHT(upRight);
                                    dtn.setDOWN_RIGHT(downRight);
                                    dtn.setSTATUS(status);

                                    UserPermissionDAO dt = new UserPermissionDAO();

                                    if (actionModule.equals("updateOne")) {
                                        //cap nhat
                                        rs = dt.update(dtn, idAcc, idModule);
                                    } else if (actionModule.equals("addOne")) {
                                        //Them moi
                                        rs = dt.add(dtn);
                                    } else {
                                        out.print("Không thực hiện gì cả");
                                    }

                                    System.out.println("Ket qua :" + rs);
                                    if (!rs) {
                                        redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                                    } else {
                                        redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                                    }

                                } catch (Exception e) {
                                    System.out.println("--- 1.Lỗi rồi");
                                }
                            } else {
                                out.print("Bạn sử dụng sai tính năng");
                            }
//                            out.println("<br/>----------");
//                            out.println("<br/>");
                        } else {
                            out.print("Bạn sử dụng sai tính năng : moduleChecked = " + moduleChecked);
                        }

                        //out.println(nextElement);
                    }
                    response.sendRedirect(redirectURL);
                } else {
                    //out.print("cap nhat tung module 1");
                    strIdModule = request.getParameter("updateOne");
                    int idModule = Integer.parseInt(strIdModule);
                    boolean allRight = (request.getParameter("allRight" + idModule) != null) ? true : false;
                    boolean listRight = (request.getParameter("listRight" + idModule) != null) ? true : false;
                    boolean viewRight = (request.getParameter("viewRight" + idModule) != null) ? true : false;
                    boolean addRight = (request.getParameter("addRight" + idModule) != null) ? true : false;
                    boolean editRight = (request.getParameter("editRight" + idModule) != null) ? true : false;
                    boolean deleteRight = (request.getParameter("deleteRight" + idModule) != null) ? true : false;
                    boolean upRight = (request.getParameter("upRight" + idModule) != null) ? true : false;
                    boolean downRight = (request.getParameter("downRight" + idModule) != null) ? true : false;
                    int status = (request.getParameter("status" + idModule) != null) ? 1 : 0;

                    try {
                        UserPermission dtn = new UserPermission();

                        dtn.setACC_ID(idAcc);
                        dtn.setMODULE_ID(idModule);
                        dtn.setALL_RIGHT(allRight);
                        dtn.setLIST_RIGHT(listRight);
                        dtn.setVIEW_RIGHT(viewRight);
                        dtn.setADD_RIGHT(addRight);
                        dtn.setEDIT_RIGHT(editRight);
                        dtn.setDEL_RIGHT(deleteRight);
                        dtn.setUP_RIGHT(upRight);
                        dtn.setDOWN_RIGHT(downRight);
                        dtn.setSTATUS(status);

                        UserPermissionDAO dt = new UserPermissionDAO();

                        //thuc hien cap nhat 1 lan theo module
                        rs = dt.update(dtn, idAcc, idModule);

                        System.out.println("Ket qua :" + rs);
                        if (!rs) {
                            redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                        } else {
                            redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                        }
                    } catch (Exception e) {
                        System.out.println("--- 1.Lỗi rồi");
                    }
                    System.out.println("duong dan redirect la : " + redirectURL);

                    response.sendRedirect(redirectURL);
                }
            } else {
                out.print("them  moi");
                strIdModule = request.getParameter("addOne");
                int idModule = Integer.parseInt(strIdModule);
                boolean allRight = (request.getParameter("allRight" + idModule) != null) ? true : false;
                boolean listRight = (request.getParameter("listRight" + idModule) != null) ? true : false;
                boolean viewRight = (request.getParameter("viewRight" + idModule) != null) ? true : false;
                boolean addRight = (request.getParameter("addRight" + idModule) != null) ? true : false;
                boolean editRight = (request.getParameter("editRight" + idModule) != null) ? true : false;
                boolean deleteRight = (request.getParameter("deleteRight" + idModule) != null) ? true : false;
                boolean upRight = (request.getParameter("upRight" + idModule) != null) ? true : false;
                boolean downRight = (request.getParameter("downRight" + idModule) != null) ? true : false;
                int status = (request.getParameter("status" + idModule) != null) ? 1 : 0;
                try {
                    UserPermission dtn = new UserPermission();

                    dtn.setACC_ID(idAcc);
                    dtn.setMODULE_ID(idModule);
                    dtn.setALL_RIGHT(allRight);
                    dtn.setLIST_RIGHT(listRight);
                    dtn.setVIEW_RIGHT(viewRight);
                    dtn.setADD_RIGHT(addRight);
                    dtn.setEDIT_RIGHT(editRight);
                    dtn.setDEL_RIGHT(deleteRight);
                    dtn.setUP_RIGHT(upRight);
                    dtn.setDOWN_RIGHT(downRight);
                    dtn.setSTATUS(status);

                    UserPermissionDAO dt = new UserPermissionDAO();

                    //thuc hien them moi
                    rs = dt.add(dtn);

                    System.out.println("Ket qua :" + rs);
                    if (!rs) {
                        redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                    } else {
                        redirectURL = baseUrl + "/userPermissionChild/list.jsp?id=" + idAcc;
                    }
                } catch (Exception e) {
                    System.out.println("--- 1.Lỗi rồi");
                }
                System.out.println("duong dan redirect la : " + redirectURL);

                response.sendRedirect(redirectURL);
            }
        }
    }

    public static boolean checkString(String str, String input) {
        boolean retval = str.contains(input);
        return retval;
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
