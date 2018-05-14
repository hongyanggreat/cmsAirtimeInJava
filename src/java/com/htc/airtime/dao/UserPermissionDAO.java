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
import com.htc.airtime.model.UserPermission;
import java.sql.Timestamp;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class UserPermissionDAO {

    static final Logger logger = Logger.getLogger(UserPermissionDAO.class);

    public ArrayList<UserPermission> getList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts ORDER BY ID DESC";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                UserPermission dt = new UserPermission();
//                dt.setACC_ID(rs.getInt("ACC_ID"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public ArrayList<UserPermission> getListUserPermission() throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<UserPermission> list = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT a.ACC_ID as ID ,a.USERNAME ,COUNT(u.ACC_ID) as TOTAL_PERMISSION FROM tbl_accounts a LEFT JOIN tbl_user_permission u ON u.ACC_ID=a.ACC_ID GROUP BY a.ACC_ID ORDER BY `ID` ASC LIMIT 100";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            list = new ArrayList<UserPermission>();
            while (rs.next()) {
                UserPermission dt = new UserPermission();
                dt.setACC_ID(rs.getInt("ID"));
                dt.setUSERNAME(rs.getString("USERNAME"));
                dt.setTOTAL_PERMISSION(rs.getInt("TOTAL_PERMISSION"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }
    public ArrayList<UserPermission> getListUserPermission(int idAcc) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<UserPermission> list = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT a.ACC_ID as ID ,a.USERNAME ,COUNT(u.ACC_ID) as TOTAL_PERMISSION FROM tbl_accounts a LEFT JOIN tbl_user_permission u ON u.ACC_ID=a.ACC_ID WHERE a.PARENT_ID = ? GROUP BY a.ACC_ID ORDER BY `ID` ASC LIMIT 100";
            pstm = conn.prepareCall(sql);
            int i =1;
            pstm.setInt(i++, idAcc);
            rs = pstm.executeQuery();
            list = new ArrayList<UserPermission>();
            while (rs.next()) {
                UserPermission dt = new UserPermission();
                dt.setACC_ID(rs.getInt("ID"));
                dt.setUSERNAME(rs.getString("USERNAME"));
                dt.setTOTAL_PERMISSION(rs.getInt("TOTAL_PERMISSION"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public  ArrayList<UserPermission> getListModuleUserPermission(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {

            conn = DBPool.getConnection();
            String sql = "SELECT m.MODULE_ID,m.`NAME`,m.RESOURCE,m.`STATUS` as STATUS_MODULE ,u.`STATUS`,u.ALL_RIGHT,u.LIST_RIGHT,u.VIEW_RIGHT,u.ADD_RIGHT,u.EDIT_RIGHT,u.DEL_RIGHT,u.UP_RIGHT,u.DOWN_RIGHT,u.IS_RIGHT FROM tbl_modules m LEFT JOIN tbl_user_permission u ON m.MODULE_ID=u.MODULE_ID AND u.ACC_ID = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, id);
            rs = pstm.executeQuery();

            list = new ArrayList();
            while (rs.next()) {
                //Lay ra du lieu roi
                UserPermission dt = new UserPermission();

                //Gan giá tri vao doi tuong dt
                dt.setMODULE_ID(rs.getInt("MODULE_ID"));
                dt.setMODULE_NAME(rs.getString("NAME"));
                dt.setRESOURCE(rs.getString("RESOURCE"));
                dt.setSTATUS(rs.getInt("STATUS"));
                dt.setSTATUSMODULE(rs.getInt("STATUS_MODULE"));
                dt.setALL_RIGHT(rs.getBoolean("ALL_RIGHT"));
                dt.setLIST_RIGHT(rs.getBoolean("LIST_RIGHT"));
                dt.setVIEW_RIGHT(rs.getBoolean("VIEW_RIGHT"));
                dt.setADD_RIGHT(rs.getBoolean("ADD_RIGHT"));
                dt.setEDIT_RIGHT(rs.getBoolean("EDIT_RIGHT"));
                dt.setDEL_RIGHT(rs.getBoolean("DEL_RIGHT"));
                dt.setUP_RIGHT(rs.getBoolean("UP_RIGHT"));
                dt.setDOWN_RIGHT(rs.getBoolean("DOWN_RIGHT"));
                dt.setIS_RIGHT(rs.getInt("IS_RIGHT"));

                //Add dt vào list
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }
    public  ArrayList<UserPermission> getListModuleUserPermissionAcctive(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {

            conn = DBPool.getConnection();
            String sql = "SELECT m.MODULE_ID,m.`NAME`,m.RESOURCE,m.`STATUS` as STATUS_MODULE ,u.`STATUS`,u.ALL_RIGHT,u.LIST_RIGHT,u.VIEW_RIGHT,u.ADD_RIGHT,u.EDIT_RIGHT,u.DEL_RIGHT,u.UP_RIGHT,u.DOWN_RIGHT,u.IS_RIGHT FROM tbl_modules m LEFT JOIN tbl_user_permission u ON m.MODULE_ID=u.MODULE_ID AND u.ACC_ID = ? AND u.STATUS = 1";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, id);
            rs = pstm.executeQuery();

            list = new ArrayList();
            while (rs.next()) {
                //Lay ra du lieu roi
                UserPermission dt = new UserPermission();

                //Gan giá tri vao doi tuong dt
                dt.setMODULE_ID(rs.getInt("MODULE_ID"));
                dt.setMODULE_NAME(rs.getString("NAME"));
                dt.setRESOURCE(rs.getString("RESOURCE"));
                dt.setSTATUS(rs.getInt("STATUS"));
                dt.setSTATUSMODULE(rs.getInt("STATUS_MODULE"));
                dt.setALL_RIGHT(rs.getBoolean("ALL_RIGHT"));
                dt.setLIST_RIGHT(rs.getBoolean("LIST_RIGHT"));
                dt.setVIEW_RIGHT(rs.getBoolean("VIEW_RIGHT"));
                dt.setADD_RIGHT(rs.getBoolean("ADD_RIGHT"));
                dt.setEDIT_RIGHT(rs.getBoolean("EDIT_RIGHT"));
                dt.setDEL_RIGHT(rs.getBoolean("DEL_RIGHT"));
                dt.setUP_RIGHT(rs.getBoolean("UP_RIGHT"));
                dt.setDOWN_RIGHT(rs.getBoolean("DOWN_RIGHT"));
                dt.setIS_RIGHT(rs.getInt("IS_RIGHT"));

                //Add dt vào list
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public static boolean add(UserPermission dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "insert into tbl_user_permission(ACC_ID,MODULE_ID,ALL_RIGHT,LIST_RIGHT,VIEW_RIGHT,ADD_RIGHT,EDIT_RIGHT,DEL_RIGHT,UP_RIGHT,DOWN_RIGHT,CREATE_DATE,CREATE_BY,IS_RIGHT,STATUS) "
                    + "     values (                      ?     ,?        ,?        ,?         ,?         ,?        ,?         ,?        ,?       ,?         ,NOW()      ,?        ,?       ,?     ) ";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, dt.getACC_ID());//ACC_ID
            pstm.setInt(i++, dt.getMODULE_ID());//MODULE_ID
            pstm.setBoolean(i++, dt.isALL_RIGHT());//ALL_RIGHT
            pstm.setBoolean(i++, dt.isLIST_RIGHT());//LIST_RIGHT
            pstm.setBoolean(i++, dt.isVIEW_RIGHT());//VIEW_RIGHT
            pstm.setBoolean(i++, dt.isADD_RIGHT());//ADD_RIGHT
            pstm.setBoolean(i++, dt.isEDIT_RIGHT());//EDIT_RIGHT
            pstm.setBoolean(i++, dt.isDEL_RIGHT());//DEL_RIGHT
            pstm.setBoolean(i++, dt.isUP_RIGHT());//UP_RIGHT
            pstm.setBoolean(i++, dt.isDOWN_RIGHT());//DOWN_RIGHT
            pstm.setInt(i++, 1);//CREATE_BY
            pstm.setInt(i++, 1);//IS_RIGHT
            pstm.setInt(i++, dt.getSTATUS());//STATUS

            if (pstm.executeUpdate() == 1) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

    public static boolean update(UserPermission dt, int idAcc, int idModule) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "UPDATE tbl_user_permission SET ALL_RIGHT = ?, LIST_RIGHT = ?,VIEW_RIGHT = ?,ADD_RIGHT = ?,EDIT_RIGHT = ?,"
                + "DEL_RIGHT = ?,UP_RIGHT = ?,DOWN_RIGHT = ?,STATUS =? ,UPDATE_BY = ?,UPDATE_DATE = NOW() WHERE ACC_ID = ? AND MODULE_ID =? ";

        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setBoolean(i++, dt.isALL_RIGHT());//ALL_RIGHT
            pstm.setBoolean(i++, dt.isLIST_RIGHT());//LIST_RIGHT
            pstm.setBoolean(i++, dt.isVIEW_RIGHT());//VIEW_RIGHT
            pstm.setBoolean(i++, dt.isADD_RIGHT());//ADD_RIGHT
            pstm.setBoolean(i++, dt.isEDIT_RIGHT());//EDIT_RIGHT
            pstm.setBoolean(i++, dt.isDEL_RIGHT());//DEL_RIGHT
            pstm.setBoolean(i++, dt.isUP_RIGHT());//UP_RIGHT
            pstm.setBoolean(i++, dt.isDOWN_RIGHT());//DOWN_RIGHT
            pstm.setInt(i++, dt.getSTATUS());//STATUS
            pstm.setInt(i++, dt.getUPDATE_BY());//UPDATE_BY
            pstm.setInt(i++, idAcc);//ACC_ID
            pstm.setInt(i++, idModule);//MODULE_ID
            if (pstm.executeUpdate() == 1) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

}
