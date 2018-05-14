/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.model;

import com.htc.airtime.components.Tool;
import com.htc.airtime.dao.AccountDAO;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class Account {

    static final Logger logger = Logger.getLogger(Account.class);
    public static final HashMap<Integer, Account> CACHE = new HashMap<>();
    private int accId;
    private int parentId;
    private int parentID;
    private String userName;
    private String password;
    private String cpCode;
    private String fullName;
    private String description;
    private String address;
    private String phone;
    private String email;
    private Timestamp createDate;
    private int createBy;
    private Timestamp updateDate;
    private int updateBy;
    private int userType;
    private int status;
    private String optionData;

    public Account() {
    }

    public static Account getAccount(HttpSession session) {
        Account acc = null;
        try {
            acc = (Account) session.getAttribute("userlogin");
            if (acc != null) {
                // Lay Lai Doi tuong moi neu da bi Reload
                acc = getAccount(acc.getAccId());
            }
        } catch (Exception e) {
            logger.error("Account.getAccount:" + Tool.getLogMessage(e));
        }
        return acc;
    }

    public static Account getAccount(int id) {
        synchronized (CACHE) {
            return CACHE.get(id);
        }
    }

    public boolean isUser() {
        boolean result = false;
        for (AccountDAO.TYPE one : AccountDAO.TYPE.values()) {
            if (one.val == userType) {
                return true;
            }
        }
        return result;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOptionData() {
        return optionData;
    }

    public void setOptionData(String optionData) {
        this.optionData = optionData;
    }

}
