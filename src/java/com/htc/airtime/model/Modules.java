/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class Modules {

    private int MODULE_ID;
    private String RESOURCE;
    private String NAME;
    private String DESCRIPTION;
    private Timestamp CREATE_DATE;
    private int CREATE_BY;
    private Timestamp UPDATE_DATE;
    private int UPDATE_BY;
    private int TYPE;
    private int STATUS;

    public Modules() {
    }

    public Modules(int MODULE_ID, String RESOURCE, String NAME, String DESCRIPTION, Timestamp CREATE_DATE, int CREATE_BY, Timestamp UPDATE_DATE, int UPDATE_BY, int TYPE, int STATUS) {
        this.MODULE_ID = MODULE_ID;
        this.RESOURCE = RESOURCE;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.CREATE_DATE = CREATE_DATE;
        this.CREATE_BY = CREATE_BY;
        this.UPDATE_DATE = UPDATE_DATE;
        this.UPDATE_BY = UPDATE_BY;
        this.TYPE = TYPE;
        this.STATUS = STATUS;
    }

    public Timestamp getCREATE_DATE() {
        return CREATE_DATE;
    }

    public void setCREATE_DATE(Timestamp CREATE_DATE) {
        this.CREATE_DATE = CREATE_DATE;
    }

    public Timestamp getUPDATE_DATE() {
        return UPDATE_DATE;
    }

    public void setUPDATE_DATE(Timestamp UPDATE_DATE) {
        this.UPDATE_DATE = UPDATE_DATE;
    }
    
    public int getMODULE_ID() {
        return MODULE_ID;
    }

    public void setMODULE_ID(int MODULE_ID) {
        this.MODULE_ID = MODULE_ID;
    }

    public String getRESOURCE() {
        return RESOURCE;
    }

    public void setRESOURCE(String RESOURCE) {
        this.RESOURCE = RESOURCE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getCREATE_BY() {
        return CREATE_BY;
    }

    public void setCREATE_BY(int CREATE_BY) {
        this.CREATE_BY = CREATE_BY;
    }

    public int getUPDATE_BY() {
        return UPDATE_BY;
    }

    public void setUPDATE_BY(int UPDATE_BY) {
        this.UPDATE_BY = UPDATE_BY;
    }

    public int getTYPE() {
        return TYPE;
    }

    public void setTYPE(int TYPE) {
        this.TYPE = TYPE;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

}
