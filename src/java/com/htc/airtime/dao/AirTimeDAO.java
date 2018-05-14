/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBConnect;
import com.htc.airtime.connect.DBPool;
import com.htc.airtime.model.Account;
import com.htc.airtime.model.AirtimeReq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author Company
 */
public class AirTimeDAO {

    static final Logger logger = Logger.getLogger(AccountDAO.class);
    public static String table = "artime_request_otp";

    public enum STATUS {
        SUCCESS("Thành công"),
        FAIL("Thất bại"),;

        private String status;

        STATUS(String status) {
            this.status = status;
        }

        public String status() {
            return status;
        }
    }

    public int countAllSearch(String msisdn, String formDate, String toDate, String user, String cpCode, String cpGame, String price, String status, ArrayList<Account> arrAcc) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        int totalCount = 0;
//        String sql = "SELECT COUNT(*) AS total FROM " + table;
        String sql = "SELECT COUNT(*) AS total "
                + "FROM artime_request_otp A LEFT JOIN artime_request_charge B ON A.SYS_REQUEST_ID=B.SYS_REQUEST_ID ";
        sql += " WHERE 1=1";
        if (!Tool.checkNull(msisdn)) {
            sql += " AND A.MSISDN = ?";
        }
        if (!formDate.equals("")) {
            sql += " AND DATEDIFF(A.REQUEST_TIME,STR_TO_DATE(?, '%d/%m/%Y %H:%i:%s') ) >=0";
        }
        if (!toDate.equals("")) {
            sql += " AND DATEDIFF(A.REQUEST_TIME,STR_TO_DATE(?, '%d/%m/%Y %H:%i:%s') ) <=0";
        }
        if (!Tool.checkNull(user)) {
            sql += " AND A.USER_NAME = ?";
        }
        if (!Tool.checkNull(cpCode)) {
            sql += " AND A.CP_CODE = ?";
        }
        if (!Tool.checkNull(cpGame)) {
            sql += " AND A.GAME_CODE = ?";
        }
        if (!Tool.checkNull(price)) {
            sql += " AND A.PRICE = ?";
        }
        if (!Tool.checkNull(status)) {
            if (status.equals("SUCCESS")) {
                sql += " AND A.RS_MPS = ?";
            } else {
                sql += " AND A.RS_MPS != ?";
            }
        }
        if (arrAcc != null) {
            System.out.println("BAN CHI CO QUYEN XEM DU LIEU CUA CHINH BẠN HOAC CON CUA BAN THOI");
            sql += " AND A.USER_NAME IN (";
            String temp = "";
            for (Account dt : arrAcc) {
                temp += ",?";
            }
            temp = temp.replaceFirst(",", "");
            temp += ")";
            sql += temp;
        } else {
            System.out.println("BAN CO FULL QUYEN NEN KHONG CAN CHUC NANG NAY");
        }

        try {

            conn = DBPool.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;
            if (!Tool.checkNull(msisdn)) {
                pstm.setString(i++, msisdn);
            }
            pstm.setString(i++, formDate + " 00:00:00");
            pstm.setString(i++, toDate + " 23:59:59");
            if (!Tool.checkNull(user)) {
                pstm.setString(i++, user);
            }
            if (!Tool.checkNull(cpCode)) {
                pstm.setString(i++, cpCode);
            }
            if (!Tool.checkNull(cpGame)) {
                pstm.setString(i++, cpGame);
            }
            if (!Tool.checkNull(price)) {
                pstm.setString(i++, price + "000");
            }
            if (!Tool.checkNull(status)) {
                pstm.setString(i++, "4");
            }
            if (arrAcc != null) {
                for (Account dt : arrAcc) {
                    pstm.setString(i++, dt.getUserName());
                }
            }
            System.out.println(pstm);
            rs = pstm.executeQuery();
            if (rs.first()) {
                totalCount = rs.getInt("total");
            }
        } catch (Exception ex) {
            System.out.println("co loi OTP DAO countAllSearch" + ex);
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return totalCount;
    }

    public ArrayList<AirtimeReq> getListSearch(String msisdn, String formDate, String toDate, String user, String cpCode, String cpGame, String price, String status, ArrayList<Account> arrAcc, int limit, int offset) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String sql = "SELECT A.ID,A.SYS_REQUEST_ID,A.CP_REQUEST_ID,A.CP_CODE,A.GAME_CODE,A.USER_NAME,A.MSISDN,"
                + "A.PRICE,A.OTP,B.OTP OTP_CHARGE ,A.RS_MPS,B.RS_MPS  RS_MPS_CHARGE ,A.RS_AHP,B.RS_AHP RS_AHP_CHARGE ,"
                + "A.CHARGER_TIME,B.CHARGER_TIME CHARGER_TIME_CHARGE ,A.SUB_SERVICE,A.OTHER_INFO,A.REQUEST_TIME,B.REQUEST_TIME REQUEST_TIME_CHARGE"
                + " FROM artime_request_otp A LEFT JOIN artime_request_charge B ON A.SYS_REQUEST_ID=B.SYS_REQUEST_ID ";
//        "SELECT A.ID ID_OTP, B.ID ID_CHARGE ,A.REQUEST_TIME,A.CP_REQUEST_ID,A.MSISDN,A.USER_NAME,A.CP_CODE,A.GAME_CODE,A.RS_MPS RS_MPS_OTP, B.RS_MPS RS_MPS_CHARGE FROM artime_request_otp A LEFT JOIN artime_request_charge B ON A.SYS_REQUEST_ID=B.SYS_REQUEST_ID  WHERE  A.ID = 460 ORDER BY A.REQUEST_TIME DESC LIMIT 2"
        sql += " WHERE 1=1";
        if (!Tool.checkNull(msisdn)) {
            sql += " AND A.MSISDN = ?";
        }
        if (!formDate.equals("")) {
            sql += " AND DATEDIFF(A.REQUEST_TIME,STR_TO_DATE(?, '%d/%m/%Y %H:%i:%s') ) >=0";
        }
        if (!toDate.equals("")) {
            sql += " AND DATEDIFF(A.REQUEST_TIME,STR_TO_DATE(?, '%d/%m/%Y %H:%i:%s') ) <=0";
        }
        if (!Tool.checkNull(user)) {
            sql += " AND A.USER_NAME = ?";
        }
        if (!Tool.checkNull(cpCode)) {
            sql += " AND A.CP_CODE = ?";
        }
        if (!Tool.checkNull(cpGame)) {
            sql += " AND A.GAME_CODE = ?";
        }
        if (!Tool.checkNull(price)) {
            sql += " AND A.PRICE = ?";
        }
        if (!Tool.checkNull(status)) {
            if (status.equals("SUCCESS")) {
                sql += " AND A.RS_MPS = ?";
            } else {
                sql += " AND A.RS_MPS != ?";
            }
        }
        if (arrAcc != null) {
            System.out.println("BAN CHI CO QUYEN XEM DU LIEU CUA CHINH BẠN HOAC CON CUA BAN THOI");
            sql += " AND A.USER_NAME IN (";
            String temp = "";
            for (Account dt : arrAcc) {
                temp += ",?";
            }
            temp = temp.replaceFirst(",", "");
            temp += ")";
            sql += temp;
        } else {
            System.out.println("BAN CO FULL QUYEN NEN KHONG CAN CHUC NANG NAY");
        }
        sql += " ORDER BY A.ID DESC";
        sql += " LIMIT ? OFFSET ?";

        try {

            conn = DBPool.getConnection();
//            conn = DBConnect.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;
            if (!Tool.checkNull(msisdn)) {
                pstm.setString(i++, msisdn);
            }
            pstm.setString(i++, formDate + " 00:00:00");
            pstm.setString(i++, toDate + " 23:59:59");
            if (!Tool.checkNull(user)) {
                pstm.setString(i++, user);
            }
            if (!Tool.checkNull(cpCode)) {
                pstm.setString(i++, cpCode);
            }
            if (!Tool.checkNull(cpGame)) {
                pstm.setString(i++, cpGame);
            }
            if (!Tool.checkNull(price)) {
                pstm.setString(i++, price + "000");
            }
            if (!Tool.checkNull(status)) {
                pstm.setString(i++, "4");
            }
            if (arrAcc != null) {
                for (Account dt : arrAcc) {
                    pstm.setString(i++, dt.getUserName());
                }
            }
            pstm.setInt(i++, limit);
            pstm.setInt(i++, offset);
            System.out.println(pstm);
            rs = pstm.executeQuery();
            try {
                while (rs.next()) {
                    AirtimeReq dt = new AirtimeReq();

                    dt.setId(rs.getInt("ID"));
                    dt.setSysReqId(rs.getString("SYS_REQUEST_ID"));
                    dt.setCpReqId(rs.getString("CP_REQUEST_ID"));
                    dt.setCpCode(rs.getString("CP_CODE"));
                    dt.setGameCode(rs.getString("GAME_CODE"));
                    dt.setUserName(rs.getString("USER_NAME"));
                    dt.setMsisdn(rs.getString("MSISDN"));
                    dt.setPrice(rs.getInt("PRICE"));
                    dt.setOtp(rs.getString("OTP"));
                    dt.setRsMps(rs.getString("RS_MPS"));
                    dt.setRsAhp(rs.getString("RS_AHP"));
                    dt.setChargerTime(rs.getString("CHARGER_TIME"));
                    dt.setSubService(rs.getString("SUB_SERVICE"));
                    dt.setOtherInfo(rs.getString("OTP_CHARGE") + "#" + rs.getString("RS_MPS_CHARGE") + "#" + rs.getString("REQUEST_TIME_CHARGE"));
                    dt.setReqTime(rs.getString("REQUEST_TIME"));

                    list.add(dt);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception ex) {
            System.out.println("CO LOI OTP DAO getListSearch ");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
//            DBConnect.freeConn(rs, pstm, conn);
        }
        return list;
    }
}
