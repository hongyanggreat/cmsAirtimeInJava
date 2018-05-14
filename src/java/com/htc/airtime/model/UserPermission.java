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
public class UserPermission {

    private int ID;
    private int ACC_ID;
    private int MODULE_ID;
    private boolean ALL_RIGHT;
    private boolean LIST_RIGHT;
    private boolean VIEW_RIGHT;
    private boolean ADD_RIGHT;
    private boolean EDIT_RIGHT;
    private boolean DEL_RIGHT;
    private boolean UP_RIGHT;
    private boolean DOWN_RIGHT;
    private String DESCRIPTION;
    private int STATUS;

    private int IS_RIGHT;

    private int CREATE_BY;
    private int UPDATE_BY;

    private Timestamp CREATE_DATE;
    private Timestamp UPDATE_DATE;

    private String USERNAME;
    private int TOTAL_PERMISSION;

    private String MODULE_NAME;
    private String RESOURCE;
    private int STATUSMODULE;

    public UserPermission() {

    }

    public UserPermission(int ID, int ACC_ID, int MODULE_ID, boolean ALL_RIGHT, boolean LIST_RIGHT, boolean VIEW_RIGHT, boolean ADD_RIGHT, boolean EDIT_RIGHT, boolean DEL_RIGHT, boolean UP_RIGHT, boolean DOWN_RIGHT, String DESCRIPTION, int STATUS, int IS_RIGHT, int CREATE_BY, int UPDATE_BY, Timestamp CREATE_DATE, Timestamp UPDATE_DATE, String USERNAME, int TOTAL_PERMISSION, String MODULE_NAME, String RESOURCE, int STATUSMODULE) {
        this.ID = ID;
        this.ACC_ID = ACC_ID;
        this.MODULE_ID = MODULE_ID;
        this.ALL_RIGHT = ALL_RIGHT;
        this.LIST_RIGHT = LIST_RIGHT;
        this.VIEW_RIGHT = VIEW_RIGHT;
        this.ADD_RIGHT = ADD_RIGHT;
        this.EDIT_RIGHT = EDIT_RIGHT;
        this.DEL_RIGHT = DEL_RIGHT;
        this.UP_RIGHT = UP_RIGHT;
        this.DOWN_RIGHT = DOWN_RIGHT;
        this.DESCRIPTION = DESCRIPTION;
        this.STATUS = STATUS;
        this.IS_RIGHT = IS_RIGHT;
        this.CREATE_BY = CREATE_BY;
        this.UPDATE_BY = UPDATE_BY;
        this.CREATE_DATE = CREATE_DATE;
        this.UPDATE_DATE = UPDATE_DATE;
        this.USERNAME = USERNAME;
        this.TOTAL_PERMISSION = TOTAL_PERMISSION;
        this.MODULE_NAME = MODULE_NAME;
        this.RESOURCE = RESOURCE;
        this.STATUSMODULE = STATUSMODULE;
    }

    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getACC_ID() {
        return ACC_ID;
    }

    public void setACC_ID(int ACC_ID) {
        this.ACC_ID = ACC_ID;
    }

    public int getMODULE_ID() {
        return MODULE_ID;
    }

    public void setMODULE_ID(int MODULE_ID) {
        this.MODULE_ID = MODULE_ID;
    }

    public boolean isALL_RIGHT() {
        return ALL_RIGHT;
    }

    public void setALL_RIGHT(boolean ALL_RIGHT) {
        this.ALL_RIGHT = ALL_RIGHT;
    }

    public boolean isLIST_RIGHT() {
        return LIST_RIGHT;
    }

    public void setLIST_RIGHT(boolean LIST_RIGHT) {
        this.LIST_RIGHT = LIST_RIGHT;
    }

    public boolean isVIEW_RIGHT() {
        return VIEW_RIGHT;
    }

    public void setVIEW_RIGHT(boolean VIEW_RIGHT) {
        this.VIEW_RIGHT = VIEW_RIGHT;
    }

    public boolean isADD_RIGHT() {
        return ADD_RIGHT;
    }

    public void setADD_RIGHT(boolean ADD_RIGHT) {
        this.ADD_RIGHT = ADD_RIGHT;
    }

    public boolean isEDIT_RIGHT() {
        return EDIT_RIGHT;
    }

    public void setEDIT_RIGHT(boolean EDIT_RIGHT) {
        this.EDIT_RIGHT = EDIT_RIGHT;
    }

    public boolean isDEL_RIGHT() {
        return DEL_RIGHT;
    }

    public void setDEL_RIGHT(boolean DEL_RIGHT) {
        this.DEL_RIGHT = DEL_RIGHT;
    }

    public boolean isUP_RIGHT() {
        return UP_RIGHT;
    }

    public void setUP_RIGHT(boolean UP_RIGHT) {
        this.UP_RIGHT = UP_RIGHT;
    }

    public boolean isDOWN_RIGHT() {
        return DOWN_RIGHT;
    }

    public void setDOWN_RIGHT(boolean DOWN_RIGHT) {
        this.DOWN_RIGHT = DOWN_RIGHT;
    }

   

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(int STATUS) {
        this.STATUS = STATUS;
    }

    public int getIS_RIGHT() {
        return IS_RIGHT;
    }

    public void setIS_RIGHT(int IS_RIGHT) {
        this.IS_RIGHT = IS_RIGHT;
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

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getTOTAL_PERMISSION() {
        return TOTAL_PERMISSION;
    }

    public void setTOTAL_PERMISSION(int TOTAL_PERMISSION) {
        this.TOTAL_PERMISSION = TOTAL_PERMISSION;
    }

    public String getMODULE_NAME() {
        return MODULE_NAME;
    }

    public void setMODULE_NAME(String MODULE_NAME) {
        this.MODULE_NAME = MODULE_NAME;
    }

    public String getRESOURCE() {
        return RESOURCE;
    }

    public void setRESOURCE(String RESOURCE) {
        this.RESOURCE = RESOURCE;
    }

    public int getSTATUSMODULE() {
        return STATUSMODULE;
    }

    public void setSTATUSMODULE(int STATUSMODULE) {
        this.STATUSMODULE = STATUSMODULE;
    }
    
}
