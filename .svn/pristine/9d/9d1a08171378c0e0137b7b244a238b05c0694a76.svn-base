/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.dao;

import com.htc.airtime.components.DateProc;
import com.htc.airtime.components.Helper;
import com.htc.airtime.components.MyDate;
import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.htc.airtime.model.Account;
import com.htc.airtime.model.Modules;
import com.htc.airtime.model.UserPermission;
import com.htc.airtime.utils.Md5;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class AccountDAO {

    static final Logger logger = Logger.getLogger(AccountDAO.class);
    public static final boolean debugRight = false;

    public static enum TYPE {

        USER(0, "Người dùng"),
        ADMIN(1, "Quyền quản trị"),
        AGENCY(2, "Tk con"),
        AGENCY_MANAGER(3, "Đại lý");
        public int val;
        public String name;

        private TYPE(int val, String name) {
            this.val = val;
            this.name = name;
        }

        public static String getname(int val) {
            String result = "Unknow";
            for (TYPE one : TYPE.values()) {
                if (one.val == val) {
                    return one.name;
                }
            }
            return result;
        }

        public static TYPE getType(int val) {
            for (TYPE one : TYPE.values()) {
                if (one.val == val) {
                    return one;
                }
            }
            return null;
        }
    }

    public ArrayList<Account> getList() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public ArrayList<Account> getListAgency(int idAgenct) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE ACC_ID = ? OR PARENT_ID = ? ";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, idAgenct);
            pstm.setInt(i++, idAgenct);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public ArrayList<Account> getListAgency(int idAgenct, int status) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = null;

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE ACC_ID = ? OR PARENT_ID = ? AND STATUS = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, idAgenct);
            pstm.setInt(i++, idAgenct);
            pstm.setInt(i++, status);
            rs = pstm.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public ArrayList<Account> getListByField(String field, String param) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setString(1, param);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public ArrayList<Account> getListByField(String field, int param) throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, param);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public int countAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int totalCount = 0;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT COUNT(*) AS total FROM tbl_accounts";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            if (rs.first()) {
                totalCount = rs.getInt("total");
            }
        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return totalCount;
    }

    public ArrayList<Account> getListPaginator() throws SQLException {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts";
            pstm = conn.prepareCall(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public Account view(int id) {
        Account dt = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ACC_ID,USERNAME,FULL_NAME,DESCRIPTION,ADDRESS,PHONE,EMAIL,USER_TYPE,STATUS,PARENT_ID FROM tbl_accounts WHERE ACC_ID = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            dt = new Account();
            if (rs.next()) {
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public Account viewByField(String field, String param) {
        Account dt = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ACC_ID,USERNAME,FULL_NAME,DESCRIPTION,ADDRESS,PHONE,EMAIL,USER_TYPE,STATUS FROM tbl_accounts WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setString(1, param);
            rs = pstm.executeQuery();
            dt = new Account();
            if (rs.next()) {
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public Account viewByField(String field, int param, String selected) {
        Account dt = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT " + selected + " FROM tbl_accounts WHERE " + field + " = ?";
            pstm = conn.prepareCall(sql);
            pstm.setInt(1, param);
            rs = pstm.executeQuery();
            dt = new Account();
            if (rs.next()) {
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return dt;

    }

    public boolean delete(int id) {
        boolean ok = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "DELETE FROM  tbl_accounts WHERE ACC_ID = ?";
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

    public ArrayList<Account> getAccount(String username, String password) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList list = new ArrayList();

        try {

            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE USERNAME = ? AND PASSWORD = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setString(i++, username);
            pstm.setString(i++, password);

            rs = pstm.executeQuery();
            while (rs.next()) {
                Account dt = new Account();
                dt.setAccId(rs.getInt("ACC_ID"));
                dt.setParentId(rs.getInt("PARENT_ID"));
                dt.setUserName(rs.getString("USERNAME"));
                dt.setPassword(rs.getString("PASSWORD"));
                dt.setCpCode(rs.getString("CP_CODE"));
                dt.setFullName(rs.getString("FULL_NAME"));
                dt.setDescription(rs.getString("DESCRIPTION"));
                dt.setAddress(rs.getString("ADDRESS"));
                dt.setPhone(rs.getString("PHONE"));
                dt.setEmail(rs.getString("EMAIL"));
                dt.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                dt.setCreateBy(rs.getInt("CREATE_BY"));
                dt.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                dt.setUpdateBy(rs.getInt("UPDATE_BY"));
                dt.setUserType(rs.getInt("USER_TYPE"));
                dt.setStatus(rs.getInt("STATUS"));
                dt.setOptionData(rs.getString("OPTION_DATA"));

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

    public Account checkLogin(String username, String password) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Account account = null;

        try {

            conn = DBPool.getConnection();
            String sql = "SELECT * FROM tbl_accounts WHERE USERNAME = ? AND PASSWORD = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setString(i++, username);
            pstm.setString(i++, password);

            rs = pstm.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setAccId(rs.getInt("ACC_ID"));
                account.setParentId(rs.getInt("PARENT_ID"));
                account.setUserName(rs.getString("USERNAME"));
                account.setPassword(rs.getString("PASSWORD"));
                account.setCpCode(rs.getString("CP_CODE"));
                account.setFullName(rs.getString("FULL_NAME"));
                account.setDescription(rs.getString("DESCRIPTION"));
                account.setAddress(rs.getString("ADDRESS"));
                account.setPhone(rs.getString("PHONE"));
                account.setEmail(rs.getString("EMAIL"));
                account.setCreateDate(rs.getTimestamp("CREATE_DATE"));
                account.setCreateBy(rs.getInt("CREATE_BY"));
                account.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
                account.setUpdateBy(rs.getInt("UPDATE_BY"));
                account.setUserType(rs.getInt("USER_TYPE"));
                account.setStatus(rs.getInt("STATUS"));
                account.setOptionData(rs.getString("OPTION_DATA"));
            }

        } catch (Exception ex) {
            System.out.println("Co loi");
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return account;
    }

    public static boolean add(Account dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = DBPool.getConnection();
            String sql = "insert into tbl_accounts(PARENT_ID,USERNAME,PASSWORD,CP_CODE,FULL_NAME,DESCRIPTION,ADDRESS,PHONE,EMAIL,USER_TYPE,STATUS,CREATE_DATE,CREATE_BY) "
                    + "     values        (        ?        ,?       ,?       ,?      ,?        ,?          ,?      ,?    ,?    ,?        ,?     ,NOW()      ,?         ) ";
            pstm = conn.prepareStatement(sql);
            //ACC_ID
            int i = 1;
            System.out.println("getParentId : " + dt.getParentId());
            pstm.setInt(i++, dt.getParentId());//PARENT_ID
            pstm.setString(i++, dt.getUserName());//USERNAME
            pstm.setString(i++, Helper.generatePassword(dt.getUserName().trim() + dt.getPassword().trim()));//PASSWORD
            pstm.setString(i++, (Tool.getRandomString(5)).toUpperCase());//CP_CODE
            pstm.setString(i++, dt.getFullName());//FULL_NAME
            pstm.setString(i++, dt.getDescription());//DESCRIPTION
            pstm.setString(i++, dt.getAddress());//ADDRESS
            pstm.setString(i++, dt.getPhone());//PHONE
            pstm.setString(i++, dt.getEmail());//EMAIL
            pstm.setInt(i++, dt.getUserType());//USER_TYPE
            pstm.setInt(i++, dt.getStatus());//STATUS
            pstm.setInt(i++, dt.getCreateBy());//CREATE_BY
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

    public static boolean update(Account dt) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            conn = DBPool.getConnection();
            String password = "";
            password = dt.getPassword();
            String sql = "UPDATE tbl_accounts SET ";
            if (!Tool.checkNull(password)) {
                System.out.println("DANG CHAY VAO DAY");
                sql += "PASSWORD =\"" + Helper.generatePassword(dt.getUserName().trim() + password.trim()) + "\", ";
            }
            sql += "FULL_NAME = ?,DESCRIPTION = ?,ADDRESS = ?,PHONE = ?,EMAIL = ?,USER_TYPE = ?,STATUS = ? ,UPDATE_BY = ?,UPDATE_DATE = NOW() WHERE ACC_ID = ? ";
            pstm = conn.prepareStatement(sql);
            int i = 1;
            System.out.println("sql:" + sql);
            pstm.setString(i++, dt.getFullName());
            pstm.setString(i++, dt.getDescription());
            pstm.setString(i++, dt.getAddress());
            pstm.setString(i++, dt.getPhone());
            pstm.setString(i++, dt.getEmail());
            pstm.setInt(i++, dt.getUserType());
            pstm.setInt(i++, dt.getStatus());
            pstm.setInt(i++, dt.getUpdateBy());
            //Dieu kien luu theo ID
            pstm.setInt(i++, dt.getAccId());
            if (pstm.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("CO LOI ROI");
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }

        return false;
    }

    public boolean checkList(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isLIST_RIGHT();
                    }
                }
            }
        }

        return right || debugRight;
    }

    public boolean checkList(HttpServletRequest request, HttpSession session, String moduleSourse) {
        boolean right = false;

        // Lay ra modul dang truy xuat
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isLIST_RIGHT();
                    }
                }
            }
        }

        return right || debugRight;
    }

    public boolean checkView(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isVIEW_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public boolean checkAdd(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        System.out.println("module:" + module.getMODULE_ID());
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isADD_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public boolean checkEdit(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        System.out.println("module:" + module.getMODULE_ID());
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isEDIT_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public boolean checkDelete(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        System.out.println("module:" + module.getMODULE_ID());
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isDEL_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public boolean checkUpload(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        System.out.println("module:" + module.getMODULE_ID());
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isUP_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public boolean checkDownload(HttpServletRequest request, HttpSession session) {
        boolean right = false;
        String uri = Tool.getURI(request);

        // Lay ra modul dang truy xuat
        String moduleSourse = getModuleSourse(uri);
        ModulesDAO mDao = new ModulesDAO();
        Modules module = mDao.view(moduleSourse);
        int moduleId = module.getMODULE_ID();
        System.out.println("module:" + module.getMODULE_ID());
        ArrayList<UserPermission> userPermission = null;
        if (session.getAttribute("userPermission") != null && !session.getAttribute("userPermission").equals("")) {
            userPermission = (ArrayList<UserPermission>) session.getAttribute("userPermission");
            for (UserPermission one : userPermission) {
                if (one.getMODULE_ID() == moduleId) {
                    if (one.isALL_RIGHT()) {
                        return one.isALL_RIGHT();
                    } else {
                        return one.isDOWN_RIGHT();
                    }
                }
            }
        }
        return right || debugRight;
    }

    public static boolean checkIsParent(int accId, int parentId) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstm = null;
        boolean flag = false;
        try {
            conn = DBPool.getConnection();
            String sql = "SELECT ACC_ID,STATUS,PARENT_ID FROM tbl_accounts WHERE ACC_ID = ?";
            pstm = conn.prepareCall(sql);
            int i = 1;
            pstm.setInt(i++, accId);
            rs = pstm.executeQuery();
            if (rs.next()) {
                if (rs.getInt("PARENT_ID") == parentId) {
                    flag = true;
//                    System.out.println("DUNG ROI.DUNG LA CHA CUA TOI MA");
                } else {
//                    System.out.println("DECH PHAI CHA CUA TAO.LUON DI");
                }
//                System.out.println("ACC_ID"+rs.getInt("ACC_ID"));
//                System.out.println("PARENT_ID"+rs.getInt("PARENT_ID"));

            }
        } catch (Exception ex) {
            System.out.println("ex" + ex);
            logger.error(Tool.getLogMessage(ex));
        } finally {
            DBPool.freeConn(rs, pstm, conn);
        }
        return flag;
    }

    public static String getModuleSourse(String uri) {
        String moduleSourse = "";
        moduleSourse = Helper.uri(uri, 1, 0);
        return moduleSourse;
    }
//    public static void main(String[] args) throws SQLException {
//        DBPool.getConnection();
////        AccountDAO dt = new AccountDAO();
////        for (Account ds : dt.getList()) {
////            System.out.println(ds.getACC_ID() + " - " + ds.getUSERNAME());
////        }
//
//    }
}
