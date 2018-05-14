/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.servlet.demoAirTime;

import com.htc.airtime.components.RequestTool;
import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.ChargeOnlineDAO;
import com.htc.airtime.httpRequest.AirTimeHttpReq;
import com.htc.airtime.model.Account;
import com.htc.airtime.model.AirTimeRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
@WebServlet(name = "sendOtp", urlPatterns = {"/sendOtp"})
public class sendOtp extends HttpServlet {

//    public final static String URL = "http://airtime.kenhthe.vn:9989/service/Otp";
    public final static String URL = "http://127.0.0.1:8686/service/Otp";
    public final static String URL_CHARGE = "http://127.0.0.1:8686/service/Charge";

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
            String result = "";
            HttpSession session = request.getSession();
            //KIEM TRA DA DANG NHAP CHUA 

            int idUser = 0;
            if (Tool.checkNull(session.getAttribute("acc"))) {
                result = "{\"code\":\"211\",\"message\":\"Vui lòng đăng nhập vào hệ thống\"}";
                out.println(result);
                return;
            }
            Account acc = (Account) session.getAttribute("acc");
            idUser = acc.getAccId();
            RequestTool.debugParam(request);

            String cpCode = "";
            String user = "";
            String accesskey = "";
            String cpGame = "";
            String msisdn = "";
            String price = "";
            String cpRequestId = "";
            String otp = "1";
            int currentid = RequestTool.getInt(request, "currentid");

            if (!Tool.checkNull(request.getParameter("cpCode")) && !"all".equals(request.getParameter("cpCode"))) {
                cpCode = request.getParameter("cpCode").trim();
            }
            if (!Tool.checkNull(request.getParameter("user")) && !"all".equals(request.getParameter("user"))) {
                user = request.getParameter("user").trim();
            }

            if (!Tool.checkNull(request.getParameter("accesskey"))) {
                accesskey = request.getParameter("accesskey").trim();
            }
            if (!Tool.checkNull(request.getParameter("cpGame")) && !"all".equals(request.getParameter("cpGame"))) {
                cpGame = request.getParameter("cpGame").trim();
            }
            if (!Tool.checkNull(request.getParameter("msisdn"))) {
                msisdn = request.getParameter("msisdn").trim();
            }
            if (!Tool.checkNull(request.getParameter("price"))) {
                price = request.getParameter("price").trim() + "000";
            }
            if (!Tool.checkNull(request.getParameter("cpRequestId"))) {
                cpRequestId = request.getParameter("cpRequestId").trim();
            }
            if (!Tool.checkNull(request.getParameter("otp"))) {
                otp = request.getParameter("otp").trim();
            }
            AirTimeRequest dataGet = new AirTimeRequest();

//            String cpRequestId = "cms_" + Tool.getRandomString(11);
//            String otp = "1";
            String signature = "";
            String otherInfo = "";
            System.out.println("************************************");
            System.out.println("---------------------cpCode:" + cpCode);
            System.out.println("************************************");
            System.out.println("---------------------user:" + user);
            System.out.println("************************************");
            dataGet.setCpCode(cpCode);
            dataGet.setCpGame(cpGame);
            dataGet.setUser(user);
            dataGet.setCpRequestId(cpRequestId);
            dataGet.setMsisdn(msisdn);
            dataGet.setPrice(price);
            dataGet.setOtp(otp);
            dataGet.setAccesskey(accesskey);
            dataGet.setSignature("signature");
            dataGet.setOtherInfo("otherInfo");
            String dataSend = dataGet.toJson();
            dataSend = URLEncoder.encode(dataSend);

//            System.out.println("cpCode:" + cpCode);
//            System.out.println("cpGame:" + cpGame);
//            System.out.println("user:" + user);
//            System.out.println("cpRequestId:" + cpRequestId);
//            System.out.println("msisdn:" + msisdn);
//            System.out.println("price:" + price);
//            System.out.println("otp:" + otp);
//            System.out.println("accesskey:" + accesskey);
//            System.out.println("signature:" + signature);
//            System.out.println("otherInfo:" + otherInfo);
            String url = URL + "?data=" + dataSend;
            if (!"1".equals(otp)) {
                url = URL_CHARGE + "?data=" + dataSend;
            }
            System.out.println("==== url  :" + url);
//            String result = "{\"code\":\"90\",\"message\":\"IP khong cho phep\"}" ;
            url = "http://cms.airtime.dev/test.jsp";
//            url = "http://cms.kenhthe.vn/test.jsp";
            result = AirTimeHttpReq.sendGET(url);

            if (!"1".equals(otp)) {
                System.out.println("CHARGING TU MA OTP");
                String code = "";
                String message = "";
                try {
                    JSONObject rsJson = JSONObject.fromObject(result);
                    code = rsJson.getString("code");
                    message = rsJson.getString("message");
                } catch (Exception e) {
                    result = "{\"code\":\"212\",\"message\":\"Lien he Admin\"}";
                    out.println(result);
                    return;
                }

                if (code.equals("00")) {
                    System.out.println("-------------------------------------");
                    System.out.println("XOA PHAN TU RA KHOI MANG");
                    System.out.println("-------------------------------------");
                    ChargeOnlineDAO chargeOnlineDAO = new ChargeOnlineDAO();
                    boolean checkUpdateStatus = chargeOnlineDAO.updateStatus(currentid, idUser);
//                    if (!checkUpdateStatus) {
//                        result = "{\"code\":\"213\",\"message\":\"Charge thành công nhưng log thất bại\"}";
//                        return;
//                    }
                    boolean checkUpdateDelete = chargeOnlineDAO.delete(currentid);
//                    if (!checkUpdateDelete) {
//                        result = "{\"code\":\"214\",\"message\":\"Charge thành công nhưng log thất bại\"}";
//                        return;
//                    }
                }
            } else {
                System.out.println("LAY MA OTP");
            }
            out.println(result);
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
