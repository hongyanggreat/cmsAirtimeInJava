/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.configs;

import com.htc.airtime.components.Tool;
import com.htc.airtime.connect.DBPool;
import com.htc.airtime.connect.PoolMng;
import com.htc.airtime.thread.AccountCacheManager;
import java.io.File;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.jconfig.ConfigurationManager;
import org.jconfig.ConfigurationManagerException;
import org.jconfig.handler.XMLFileHandler;

/**
 *
 * @author TUANPLA
 */
public class MyContext implements ServletContextListener {

    static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(MyContext.class);
    public static String configDir;
    //---
    public static String ROOT_DIR;
    public static boolean running = false;
    public static boolean DE_BUG;
    // ----Constants
    public static String SMTP_MAIL;
    public static String SMTP_PASS;
    public static String MAIL_HOST;
    public static String FROM_NAME;
    public static String MAIL_DEBUG;
    public static final int SEND_MAIL_FALSE = 1;
    public static String URL_RELOAD;
    // General

    //------------
    Monitor m;
    AccountCacheManager acm;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        running = true;
        //--
        System.setProperty("java.awt.headless", "true");    // Fix Error java.lang.NoClassDefFoundError: Could not initialize class sun.awt.X11GraphicsEnvironmen
        ROOT_DIR = sc.getRealPath("/"); // /work/webroot/airtimeService
        Tool.debug("ROOT_DIR:" + ROOT_DIR);
        configDir = sc.getInitParameter("config");
        configDir = ROOT_DIR + configDir;
        //Load Log4J
        LoadLog4j(configDir + "/Log4j.properties");
        // Load Config
        MyConfig.config = getConfig("config.xml");
        //-------
        PoolMng.CreatePool();
       
//
        //-- CONFIG MAIL
        SMTP_MAIL = MyConfig.getString("SMTP_MAIL", "smpp.gmail.com", "EMAIL");
        SMTP_PASS = MyConfig.getString("SMTP_PASS", "smpp.gmail.com", "EMAIL");
        MAIL_HOST = MyConfig.getString("MAIL_HOST", "smpp.gmail.com", "EMAIL");
        FROM_NAME = MyConfig.getString("FROM_NAME", "smpp.gmail.com", "EMAIL");
        MAIL_DEBUG = MyConfig.getString("MAIL_DEBUG", "smpp.gmail.com", "EMAIL");

//        ARTICLES_IMG_THUMB_ALIAS = MyConfig.getString("ARTICLES_IMG_THUMB_ALIAS", "/upload/thumb", "General");
//        ARTICLES_IMG_CACHE_ALIAS = MyConfig.getString("ARTICLES_IMG_CACHE_ALIAS", "/upload/article", "General");
//        String tem = MyConfig.getString("WIDTH_IMAGE_THUMBNAIL", "400,130", "General");
        // General
        m = new Monitor();
//        m.start();
        acm = new AccountCacheManager();
        acm.start();
        // start check money vte
        
//        CreateDataManager cdata = new CreateDataManager();
//        cdata.start();
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void contextDestroyed(ServletContextEvent sce) {
        running = false;
        m.stopThread();
        acm.stopThread();
        //
        MyConfig.config.resetCreated();
        //---
        DBPool.release();
        PoolMng.release();
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                Tool.debug(" Deregis Driver:" + driver.toString());
                logger.log(org.apache.log4j.Level.INFO, String.format("deregistering jdbc driver: %s", driver));
            } catch (SQLException e) {
                logger.log(org.apache.log4j.Level.ERROR, String.format("Error deregistering driver %s", driver), e);
            }
        }
        Tool.debug(" contextDestroyed ............");
    }

    private static org.jconfig.Configuration getConfig(String configFile) {
        org.jconfig.Configuration _config = null;
        String configPath = configDir + "/" + configFile;
        configPath = configPath.replaceAll("\\\\", "/");
        File file = new File(configPath);
        logger.info(file.getName());
        XMLFileHandler handler = new XMLFileHandler();
        handler.setFile(file);
        try {
            logger.debug("trying to load file config");
            ConfigurationManager cm = ConfigurationManager.getInstance();
            cm.load(handler, "engineConfig");
            logger.info("file config successfully processed");
            logger.info("get Config From ConfigurationManager");
            _config = ConfigurationManager.getConfiguration("engineConfig");
        } catch (ConfigurationManagerException e) {
            e.printStackTrace();
        }
        return _config;
    }

    private static void LoadLog4j(String log4jPath) {
        if (log4jPath == null) {
            Tool.debug("==> - log4j-properties-location init param, so initializing log4j with BasicConfigurator");
            BasicConfigurator.configure();
        } else {
            File yoMamaYesThisSaysYoMama = new File(log4jPath);
            if (yoMamaYesThisSaysYoMama.exists()) {
                Tool.debug("====>Initializing Log4j:" + log4jPath);
                PropertyConfigurator.configure(log4jPath);
            } else {
                Tool.debug("=====> " + log4jPath + " file not found, so initializing log4j with BasicConfigurator");
                BasicConfigurator.configure();
            }
        }
    }

}
