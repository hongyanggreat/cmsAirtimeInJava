/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.model;

import net.sf.json.JSONObject;

/**
 *
 * @author Admin
 */
public class AirTimeRequest {

//    {\"cpCode\":\"PGYST\",\"cpGame\":\"vline\",\"user\":\"hoatpt\",\"cpRequestId\":\
//    "$requestid\",\"msisdn\":\"$msisdn\",\"price\":\"$moneyCharg\",\"otp\":\"$optCode\""
//    + ",\"accesskey\":\"xxx\",\"signature\":\"xxx\",\"otherInfo\":\"xxx\"}
    String cpCode;
    String cpGame;
    String user;
    String cpRequestId;
    String msisdn;
    String price;
    String otp;
    String accesskey;
    String signature;
    String otherInfo;
    
    String result;

    public AirTimeRequest() {
    }

    public AirTimeRequest(String cpCode, String cpGame, String user, String cpRequestId, String msisdn, String price, String otp, String accesskey, String signature, String otherInfo, String result) {
        this.cpCode = cpCode;
        this.cpGame = cpGame;
        this.user = user;
        this.cpRequestId = cpRequestId;
        this.msisdn = msisdn;
        this.price = price;
        this.otp = otp;
        this.accesskey = accesskey;
        this.signature = signature;
        this.otherInfo = otherInfo;
        this.result = result;
    }

   
     public String toJson() {
//        return "chuoi json tra ve";
        JSONObject obj = JSONObject.fromObject(this);
        return obj.toString();
    }
    public String getCpCode() {
        return cpCode;
    }

    public void setCpCode(String cpCode) {
        this.cpCode = cpCode;
    }

    public String getCpGame() {
        return cpGame;
    }

    public void setCpGame(String cpGame) {
        this.cpGame = cpGame;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpRequestId() {
        return cpRequestId;
    }

    public void setCpRequestId(String cpRequestId) {
        this.cpRequestId = cpRequestId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
