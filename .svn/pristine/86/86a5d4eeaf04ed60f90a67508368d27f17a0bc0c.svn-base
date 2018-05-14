/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBPool;
import com.htc.airtime.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.htc.airtime.model.UserServices;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class UserServicesDAO {

    static final Logger logger = Logger.getLogger(AccountDAO.class);

    public ArrayList<UserServices> getList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_user_service ORDER BY ID DESC";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                UserServices dt = new UserServices();

                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setServicePin(rs.getString("SERVICE_PIN"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setSecretKey(rs.getString("SECRET_KEY"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                dt.setUrlCallback(rs.getString("URL_CALLBACK"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setRouterTable(rs.getString("ROUTE_TABLE"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));

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

    public ArrayList<UserServices> getListByField(String field, int param) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_user_service WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, param);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UserServices dt = new UserServices();
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }
    public ArrayList<UserServices> getListByField(String field, String param) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_user_service WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setString(1, param);
            rs = pstm.executeQuery();

            while (rs.next()) {
                UserServices dt = new UserServices();
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public ArrayList<UserServices> getListByField(ArrayList<Account> arrAcc) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String sql = "SELECT * from tbl_user_service WHERE STATUS = ? AND USERNAME IN (";
        String temp = "";
        if (arrAcc != null) {
            for (Account dt : arrAcc) {
                temp += ",?";
            }
        }
        temp = temp.replaceFirst(",", "");
        temp += ")";
        sql = sql + temp;
        System.out.println("sql" + sql);

        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, 1);
            if (arrAcc != null) {
                for (Account dt : arrAcc) {
                    System.out.println("tai khoan : " + dt.getUserName());
                    pstm.setString(i++, dt.getUserName());
                }
            }
            rs = pstm.executeQuery();

            while (rs.next()) {
                UserServices dt = new UserServices();
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }
    public ArrayList<UserServices> getListByField(String field, String param,ArrayList<Account> arrAcc) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        String sql = "SELECT * from tbl_user_service WHERE STATUS = ? AND " + field + " = ?";
        String temp = "";
        if (arrAcc != null) {
            sql +=" AND USERNAME IN (";
            for (Account dt : arrAcc) {
                temp += ",?";
            }
            temp = temp.replaceFirst(",", "");
            sql = sql + temp;
            sql += ")";
        }
        System.out.println("sql" + sql);

        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, 1);
            pstm.setString(i++, param);
            if (arrAcc != null) {
                for (Account dt : arrAcc) {
                    System.out.println("tai khoan : " + dt.getUserName());
                    pstm.setString(i++, dt.getUserName());
                }
            }
            rs = pstm.executeQuery();

            while (rs.next()) {
                UserServices dt = new UserServices();
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public ArrayList<UserServices> getListByIdService(String idService) throws SQLException {

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;
        String sql = "SELECT * FROM tbl_user_service WHERE SERVICE_TYPE = ? ORDER BY ID DESC";

        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setString(i++, idService);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                UserServices dt = new UserServices();

                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setServicePin(rs.getString("SERVICE_PIN"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setSecretKey(rs.getString("SECRET_KEY"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                dt.setUrlCallback(rs.getString("URL_CALLBACK"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setRouterTable(rs.getString("ROUTE_TABLE"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));

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

    public ArrayList<UserServices> getListByIdService(int idService) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;
        try {
            conn = DBPool.getConnection();
//            String sql = "SELECT * FROM tbl_user_service";
            String sql = "SELECT * FROM tbl_user_service WHERE SERVICE_TYPE = ? ORDER BY ID DESC";
            int i = 1;
            pstm = conn.prepareCall(sql);
            pstm.setInt(i++, idService);
            System.out.println("CAU LENH SQL : " + pstm);
            rs = pstm.executeQuery();

            list = new ArrayList();
            while (rs.next()) {
                UserServices dt = new UserServices();

                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setServicePin(rs.getString("SERVICE_PIN"));
                dt.setAccessKey(rs.getString("ACCESS_KEY"));
                dt.setSecretKey(rs.getString("SECRET_KEY"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                dt.setUrlCallback(rs.getString("URL_CALLBACK"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setRouterTable(rs.getString("ROUTE_TABLE"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));

                list.add(dt);
            }

        } catch (Exception ex) {
            System.out.println("CO LOI getListByIdService +++ ");
            System.out.println(ex.getMessage());
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return list;
    }

    public UserServices view(int id) {
        UserServices dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT *"
                    + " FROM tbl_user_service"
                    + " WHERE ID = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            dt = new UserServices();
            if (rs.next()) {
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }
    public UserServices viewByField(String field,String param) {
        UserServices dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT *"
                    + " FROM tbl_user_service"
                    + " WHERE ? = ?";
            pstm = conn.prepareCall(sql);
            int i =1;
            pstm.setString(i++, field);
            pstm.setString(i++, param);
            rs = pstm.executeQuery();
            dt = new UserServices();
            if (rs.next()) {
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setServiceType(rs.getInt("SERVICE_TYPE"));
                dt.setIpAllow(rs.getString("IP_ALLOW"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public UserServices view(int id, int idService) {
        UserServices dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {

            conn = DBPool.getConnection();
            String sql = "SELECT *"
                    + " FROM tbl_user_service"
                    + " WHERE ID = ? AND SERVICE_TYPE = ?";
            int i = 1;
            pstm.setInt(i++, id);
            pstm.setInt(i++, idService);
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            dt = new UserServices();
            if (rs.next()) {
                dt.setId(rs.getInt("ID"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setGameName(rs.getString("GAME_NAME"));
                dt.setCodeGame(rs.getString("CODE_GAME"));
                dt.setUrlCallback(rs.getString("URL_CALLBACK"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setOptionData(rs.getString("OPTION_DATA"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("CO LOI");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public static boolean add(UserServices dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {

            conn = DBPool.getConnection();
            String sql = "insert into tbl_user_service(CP_CODE,GAME_NAME,CODE_GAME,USERNAME,SERVICE_PIN,ACCESS_KEY,SECRET_KEY,SERVICE_TYPE,IP_ALLOW,OPTION_DATA,DESCRIPTION,STATUS,CREATE_DATE,CREATE_BY) "
                    + "values     (                    ?      ,?        ,?        ,?       ,?          ,?         ,?         ,?           ,?           ,?          ,?          ,?     ,NOW()      ,?        ) ";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++, dt.getCpCode());
            pstm.setString(i++, dt.getGameName());
            pstm.setString(i++, dt.getCodeGame());
            pstm.setString(i++, dt.getUserName());
            pstm.setString(i++, dt.getServicePin());
            pstm.setString(i++, dt.getAccessKey());
            pstm.setString(i++, dt.getSecretKey());
            pstm.setInt(i++, dt.getServiceType());
            pstm.setString(i++, dt.getIpAllow());
            pstm.setString(i++, dt.getOptionData());
            pstm.setString(i++, dt.getDescription());
            pstm.setInt(i++, dt.getStatus());
            pstm.setInt(i++, 1);//CREATE_BY
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

    public static boolean update(UserServices dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {

            conn = DBPool.getConnection();
            String sql = "UPDATE tbl_user_service"
                    + " SET CP_CODE = ?,GAME_NAME = ?,CODE_GAME = ?,USERNAME = ?,IP_ALLOW = ?,OPTION_DATA = ?,DESCRIPTION = ?,STATUS = ?,UPDATE_DATE = NOW(),UPDATE_BY = ?"
                    + " WHERE ID = ? ";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            pstm.setString(i++, dt.getCpCode());
            pstm.setString(i++, dt.getGameName());
            pstm.setString(i++, dt.getCodeGame());
            pstm.setString(i++, dt.getUserName());

            pstm.setString(i++, dt.getIpAllow());
            pstm.setString(i++, dt.getOptionData());
            pstm.setString(i++, dt.getDescription());
            pstm.setInt(i++, dt.getStatus());
            pstm.setInt(i++, 1);//UPDATE_BY
            //Dieu kien luu theo ID
            pstm.setInt(i++, dt.getId());
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

    public boolean delete(int id) {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "DELETE FROM  tbl_user_service WHERE ID = ?";
        try {
            conn = DBPool.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
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
//    public static void main(String[] args) {
//      
//    }
}
