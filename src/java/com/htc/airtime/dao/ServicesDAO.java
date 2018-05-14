/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.htc.airtime.model.Services;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class ServicesDAO {

    static final Logger logger = Logger.getLogger(ServicesDAO.class);

    public ArrayList<Services> getList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ID,NAME,ALIAS,STATUS,DESCRIPTION"
                    + " FROM tbl_service ORDER BY ID DESC";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Services dt = new Services();
                dt.setID(rs.getInt("ID"));
                dt.setNAME(rs.getString("NAME"));
                dt.setALIAS(rs.getString("ALIAS"));
                dt.setSTATUS(rs.getInt("STATUS"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI O TRY : getListSearch");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public static boolean add(Services dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBPool.getConnection();
            String sql = "insert into tbl_service(NAME,ALIAS,STATUS,DESCRIPTION,CREATE_DATE,CREATE_BY) "
                    + "values(                    ?   ,?    ,?     ,?          ,NOW()      ,?        ) ";
            pstm = conn.prepareStatement(sql);
            //MODULE_ID tu tang
            int i = 1;
            pstm.setString(i++, dt.getNAME());
            pstm.setString(i++, dt.getALIAS());
            pstm.setInt(i++, dt.getSTATUS());
            pstm.setString(i++, dt.getDESCRIPTION());
            pstm.setInt(i++, 1);//CREATE_BY
            if (pstm.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("CO LOI O TRY : getListSearch");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

    public static boolean update(Services dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBPool.getConnection();
            String sql = "UPDATE tbl_service"
                    + " SET NAME=?,ALIAS=?,DESCRIPTION=?,STATUS=?,UPDATE_DATE=NOW(),UPDATE_BY=? "
                    + " WHERE ID = ? ";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++, dt.getNAME());
            pstm.setString(i++, dt.getALIAS());
            pstm.setString(i++, dt.getDESCRIPTION());
            pstm.setInt(i++, dt.getSTATUS());
//            pstm.setInt(i++, 1503304020);//UPDATE_DATE
            pstm.setInt(i++, 1);//UPDATE_BY
            //Dieu kien luu theo ID
            pstm.setInt(i++, dt.getID());
            if (pstm.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("CO LOI O TRY : getListSearch");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

    public Services view(int id) {
        Services dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ID,NAME,ALIAS,STATUS,DESCRIPTION"
                    + " FROM tbl_service"
                    + " WHERE ID = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            dt = new Services();
            if (rs.next()) {
                dt.setID(rs.getInt("ID"));
                dt.setNAME(rs.getString("NAME"));
                dt.setALIAS(rs.getString("ALIAS"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                dt.setSTATUS(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("CO LOI O TRY : getListSearch");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public Services serviceByAlias(String alias) {
        Services dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Connection connection = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ID,NAME,ALIAS,STATUS,DESCRIPTION"
                    + " FROM tbl_service"
                    + " WHERE ALIAS = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setString(i++, alias);
            rs = pstm.executeQuery();
            dt = new Services();
            if (rs.next()) {
                dt.setID(rs.getInt("ID"));
                dt.setNAME(rs.getString("NAME"));
                dt.setALIAS(rs.getString("ALIAS"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                dt.setSTATUS(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("CO LOI O TRY : getListSearch");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }
}
