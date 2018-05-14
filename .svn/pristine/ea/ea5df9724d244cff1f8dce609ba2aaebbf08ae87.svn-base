/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.connect.DBPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.htc.airtime.model.Account;
import com.htc.airtime.model.Modules;

/**
 *
 * @author Admin
 */
public class ModulesDAO {

    public ArrayList<Modules> getList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_modules";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Modules dt = new Modules();
                dt.setMODULE_ID(rs.getInt("MODULE_ID"));
                dt.setRESOURCE(rs.getString("RESOURCE"));
                dt.setNAME(rs.getString("NAME"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                dt.setCREATE_DATE(rs.getTimestamp("CREATE_DATE"));
                dt.setCREATE_BY(rs.getInt("CREATE_BY"));
                dt.setUPDATE_DATE(rs.getTimestamp("UPDATE_DATE"));
                dt.setUPDATE_BY(rs.getInt("UPDATE_BY"));
                dt.setTYPE(rs.getInt("TYPE"));
                dt.setSTATUS(rs.getInt("STATUS"));
                list.add(dt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public static boolean add(Modules dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "insert into tbl_modules(RESOURCE,NAME,DESCRIPTION,TYPE,STATUS,CREATE_DATE,CREATE_BY) "
                    + "values(                    ?       ,?   ,?          ,?   ,?     ,NOW()      ,?        ) ";
            pstm = conn.prepareStatement(sql);
            //MODULE_ID tu tang
            int i = 1;
            pstm.setString(i++, dt.getRESOURCE());//RESOURCE
            pstm.setString(i++, dt.getNAME());//NAME
            pstm.setString(i++, dt.getDESCRIPTION());//DESCRIPTION
            pstm.setInt(i++, dt.getTYPE());//USER_TYPE
            pstm.setInt(i++, dt.getSTATUS());//STATUS
            pstm.setInt(i++, 1);//CREATE_BY
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

    public static boolean update(Modules dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBPool.getConnection();
            String sql = "UPDATE tbl_modules"
                    + " SET RESOURCE=?,NAME=?,DESCRIPTION=?,TYPE=?,STATUS=?,UPDATE_DATE= NOW(),UPDATE_BY=? "
                    + " WHERE MODULE_ID = ? ";
            pstm = conn.prepareStatement(sql);
            int i = 1;

            pstm.setString(i++, dt.getRESOURCE());
            pstm.setString(i++, dt.getNAME());
            pstm.setString(i++, dt.getDESCRIPTION());
            pstm.setInt(i++, dt.getTYPE());//TYPE
            pstm.setInt(i++, dt.getSTATUS());
            pstm.setInt(i++, 1);//UPDATE_BY
            //Dieu kien luu theo MODULE_ID
            pstm.setInt(i++, dt.getMODULE_ID());
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

    public Modules view(int id) {
        Modules dt = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT MODULE_ID,RESOURCE,NAME,DESCRIPTION,TYPE,STATUS FROM tbl_modules WHERE MODULE_ID = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            dt = new Modules();
            if (rs.next()) {
                dt.setMODULE_ID(rs.getInt("MODULE_ID"));
                dt.setRESOURCE(rs.getString("RESOURCE"));
                dt.setNAME(rs.getString("NAME"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                dt.setTYPE(rs.getInt("TYPE"));
                dt.setSTATUS(rs.getInt("STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }
    public Modules view(String alias) {
        Modules dt = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT MODULE_ID,RESOURCE,NAME,DESCRIPTION,TYPE,STATUS FROM tbl_modules WHERE RESOURCE = ?";
            pstm = conn.prepareCall(sql);
            pstm.setString(1, alias);
            rs = pstm.executeQuery();
            dt = new Modules();
            if (rs.next()) {
                dt.setMODULE_ID(rs.getInt("MODULE_ID"));
                dt.setRESOURCE(rs.getString("RESOURCE"));
                dt.setNAME(rs.getString("NAME"));
                dt.setDESCRIPTION(rs.getString("DESCRIPTION"));
                dt.setTYPE(rs.getInt("TYPE"));
                dt.setSTATUS(rs.getInt("STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }
    
}
