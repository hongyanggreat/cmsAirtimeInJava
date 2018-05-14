/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.model;

import java.sql.Timestamp;

/**
 *
 * @author Company
 */
public class ChargeOnline {
    private int id;
    private String userName;
    private String cpCode;
    private String gameCode;
    private String accessKey;
    private String price;
    private String misidn;
    private int status;
    private Timestamp createAt;
    private int createBy;
    private Timestamp updateAt;
    private int updateBy;
    private String opt;

    public ChargeOnline() {
    }

    public ChargeOnline(int id, String userName, String cpCode, String gameCode, String accessKey, String price, String misidn, int status, Timestamp createAt, int createBy, Timestamp updateAt, int updateBy, String opt) {
        this.id = id;
        this.userName = userName;
        this.cpCode = cpCode;
        this.gameCode = gameCode;
        this.accessKey = accessKey;
        this.price = price;
        this.misidn = misidn;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.opt = opt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMisidn() {
        return misidn;
    }

    public void setMisidn(String misidn) {
        this.misidn = misidn;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    
    
}
