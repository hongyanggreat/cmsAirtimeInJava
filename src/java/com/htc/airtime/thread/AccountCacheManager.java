/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.thread;

import com.htc.airtime.components.DateProc;
import com.htc.airtime.dao.AccountDAO;
import com.htc.airtime.model.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
public class AccountCacheManager extends Thread {

    static final Logger logger = Logger.getLogger(AccountCacheManager.class);
    private static final HashMap<String, ArrayList<Account>> CACHE_ACCOUNT = new HashMap<>();
    protected static Object monitor;

    @SuppressWarnings("LeakingThisInConstructor")
    public AccountCacheManager() {
        this.setName("AccoutCacheManager:" + DateProc.createTimestamp());
        monitor = this;
    }

    private HashMap<String, ArrayList<Account>> cloneHash() {
        synchronized (monitor) {
            HashMap<String, ArrayList<Account>> result = (HashMap<String, ArrayList<Account>>) CACHE_ACCOUNT.clone();
            return result;
        }
    }

    public static ArrayList<Account> get(String key) {
        synchronized (monitor) {
            return CACHE_ACCOUNT.get(key);
        }
    }

    public static void put(String key, ArrayList<Account> mt) {
//        System.out.println("HAM ADD CACHE");
        synchronized (monitor) {
            CACHE_ACCOUNT.put(key, mt);
            monitor.notifyAll();
        }
    }

    public static void remove(String key) {
        synchronized (monitor) {
//            logger.debug("ConcatLongMT.removeLongMT:" + key);
            CACHE_ACCOUNT.remove(key);
        }
    }

    @Override
    public void run() {
        System.out.println("TAO CACHE ACCOUNT KHI TOMCAT CHAY LAN DAU");
        System.out.println("AccoutCacheManager Started:" + DateProc.createTimestamp());
        String keycache = "airTime_cacheAcc";
        System.out.println("KEY CACHE:" + keycache);
        AccountDAO account = new AccountDAO();
        ArrayList<Account> acc = null;
        try {
            acc = account.getList();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccountCacheManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        CACHE_ACCOUNT.put(keycache, acc);
    }

    public void stopThread() {
        this.interrupt();
    }
}
