/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBConnect;
import com.htc.airtime.connect.DBPool;
import com.htc.airtime.model.ChargeOnline;
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
public class ChargeOnlineDAO {

    public static String table = "charge_online";
    static final Logger logger = Logger.getLogger(AccountDAO.class);

    public ArrayList<ChargeOnline> getListSearch(int limit) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String sql = "SELECT * FROM " + table;
        sql += " ORDER BY ID ASC";
        sql += " LIMIT ?";

        try {

            conn = DBPool.getConnection();
//            conn = DBConnect.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;

            pstm.setInt(i++, limit);
            System.out.println(pstm);
            rs = pstm.executeQuery();
            try {
                while (rs.next()) {
                    ChargeOnline dt = new ChargeOnline();

                    dt.setId(rs.getInt("ID"));
                    dt.setUserName(rs.getString("USER_NAME"));
                    dt.setCpCode(rs.getString("CP_CODE"));
                    dt.setGameCode(rs.getString("GAME_CODE"));
                    dt.setAccessKey(rs.getString("ACCESS_KEY"));
                    dt.setPrice(rs.getString("PRICE"));
                    dt.setMisidn(rs.getString("MSISDN"));
                    dt.setStatus(rs.getInt("STATUS"));
                    dt.setCreateAt(rs.getTimestamp("CREATE_AT"));
                    dt.setCreateBy(rs.getInt("CREATE_BY"));
                    dt.setUpdateAt(rs.getTimestamp("UPDATE_AT"));
                    dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                    dt.setOpt(rs.getString("OTP"));
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

    public ArrayList<ChargeOnline> getListSearch(int idUser, int limit) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String sql = "SELECT * FROM " + table;
        sql += " WHERE CREATE_BY = ?";
//        sql += " ORDER BY ID ASC";
        sql += " ORDER BY ID DESC";
        sql += " LIMIT ?";

        try {

            conn = DBPool.getConnection();
//            conn = DBConnect.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;

            pstm.setInt(i++, idUser);
            pstm.setInt(i++, limit);
            System.out.println(pstm);
            rs = pstm.executeQuery();
            try {
                while (rs.next()) {
                    ChargeOnline dt = new ChargeOnline();

                    dt.setId(rs.getInt("ID"));
                    dt.setUserName(rs.getString("USER_NAME"));
                    dt.setCpCode(rs.getString("CP_CODE"));
                    dt.setGameCode(rs.getString("GAME_CODE"));
                    dt.setAccessKey(rs.getString("ACCESS_KEY"));
                    dt.setPrice(rs.getString("PRICE"));
                    dt.setMisidn(rs.getString("MSISDN"));
                    dt.setStatus(rs.getInt("STATUS"));
                    dt.setCreateAt(rs.getTimestamp("CREATE_AT"));
                    dt.setCreateAt(rs.getTimestamp("CREATE_AT"));
                    dt.setCreateBy(rs.getInt("CREATE_BY"));
                    dt.setUpdateAt(rs.getTimestamp("UPDATE_AT"));
                    dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                    dt.setOpt(rs.getString("OTP"));
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

    public static int addReturnId(ChargeOnline dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int lastId = 0;
        try {
            conn = DBPool.getConnection();
            String sql = "insert into " + table + "(USER_NAME,CP_CODE,GAME_CODE,ACCESS_KEY,PRICE,"
                    + "MSISDN,STATUS,CREATE_AT,CREATE_BY,OTP) "
                    + "values( ?        ,?      ,?        ,?         ,?    "
                    + ",?     ,?     ,NOW()    ,?        ,?   ) ";
            pstm = conn.prepareStatement(sql, pstm.RETURN_GENERATED_KEYS);
            //MODULE_ID tu tang
            int i = 1;
            pstm.setString(i++, dt.getUserName());//USER_NAME
            pstm.setString(i++, dt.getCpCode());//CP_CODE
            pstm.setString(i++, dt.getGameCode());//GAME_CODE
            pstm.setString(i++, dt.getAccessKey());//ACCESS_KEY
            pstm.setString(i++, dt.getPrice());//PRICE
            pstm.setString(i++, dt.getMisidn());//MSISDN
            pstm.setInt(i++, dt.getStatus());//STATUS
            pstm.setInt(i++, dt.getCreateBy());//CREATE_BY
            pstm.setString(i++, dt.getOpt());//OTP
            if (pstm.executeUpdate() == 1) {
                rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    lastId = rs.getInt(1);
                }
                System.out.println("=============ID LAST:" + lastId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return lastId;
    }

    public static boolean add(ChargeOnline dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "insert into " + table + "(USER_NAME,CP_CODE,GAME_CODE,ACCESS_KEY,PRICE,"
                    + "MSISDN,STATUS,CREATE_AT,CREATE_BY,OTP) "
                    + "values( ?        ,?      ,?        ,?         ,?    "
                    + ",?     ,?     ,NOW()    ,?        ,?   ) ";
            pstm = conn.prepareStatement(sql);
            //MODULE_ID tu tang
            int i = 1;
            pstm.setString(i++, dt.getUserName());//USER_NAME
            pstm.setString(i++, dt.getCpCode());//CP_CODE
            pstm.setString(i++, dt.getGameCode());//GAME_CODE
            pstm.setString(i++, dt.getAccessKey());//ACCESS_KEY
            pstm.setString(i++, dt.getPrice());//PRICE
            pstm.setString(i++, dt.getMisidn());//MSISDN
            pstm.setInt(i++, dt.getStatus());//STATUS
            pstm.setInt(i++, dt.getCreateBy());//CREATE_BY
            pstm.setString(i++, dt.getOpt());//OTP
            if (pstm.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

    public boolean delete(int id) {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "DELETE FROM  " + table + " WHERE ID = ?";
        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, id);
            if (pstm.executeUpdate() == 1) {
                ok = true;
            }
        } catch (SQLException ex) {
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return ok;
    }
    public boolean deleteByAcc(int idAcc) {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "DELETE FROM  " + table + " WHERE CREATE_BY = ?";
        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, idAcc);
            if (pstm.executeUpdate() == 1) {
                ok = true;
            }
        } catch (SQLException ex) {
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return ok;
    }
    public static boolean updateStatus(int id,int accId) {
      boolean ok = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "UPDATE " + table + " SET ";
            
            sql += "STATUS = ? ,UPDATE_BY = ?,UPDATE_AT = NOW() WHERE ID = ? ";
        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setInt(i++, 1);
            pstm.setInt(i++, accId);
            pstm.setInt(i++, id);
            System.out.println("CAU LENH SQL UPDATE:"+pstm);
            if (pstm.executeUpdate() == 1) {
                ok = true;
            }
        } catch (SQLException ex) {
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return ok;
    }
}
