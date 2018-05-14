/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.components;

import com.htc.airtime.model.Account;
import com.htc.airtime.utils.Md5;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class Helper {

    public static final String SALT = "$2y$13";

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static void putTmpSessionOBJ(HttpSession session, Object obj) {
        session.setAttribute("listObj", obj);
    }

    public static Object getTmpSessionOBJ(HttpSession session) {
        Object tmp = session.getAttribute("listObj");
        session.removeAttribute("listObj");
        return tmp;
    }

    public static void putTmpOBJ(HttpSession session, ArrayList obj) {
        session.setAttribute("listObj", obj);
    }

    public static ArrayList getTmpOBJ(HttpSession session) {
        ArrayList tmp = (ArrayList) session.getAttribute("listObj");
        session.removeAttribute("listObj");
        return tmp;
    }

    public static String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }

    public static String uri(String input, int numArray, int numberStr) {
        // numArray la lay vi tri trong mang
        // numberStr la vi tri chuoi can tach
        String[] arrayParam = input.split("/");
        String alias = arrayParam[numArray];
        alias = alias.substring(numberStr);
        return alias;

    }

    public static String getImageIcon(String typeImage, String baseUrl) {
        String image = "";
        image = "<img width='20' src='" + baseUrl + "/resource/images/icon/" + typeImage + ".png' alt=''/>";
        return image;
    }

    public static String getURI(HttpServletRequest request) {
        String currentURL = null;
        if (request.getAttribute("javax.servlet.forward.request_uri") != null) {
            currentURL = (String) request.getAttribute("javax.servlet.forward.request_uri");
        } else {
            currentURL = request.getRequestURI();
        }
        if (currentURL != null && request.getAttribute("javax.servlet.include.query_string") != null) {
            currentURL += "?" + request.getQueryString();
        }
        return currentURL;
    }

    public static String formatNumber(int number) {
        if (number < 1000) {
            return String.valueOf(number);
        }
        try {
            NumberFormat formatter = new DecimalFormat("###,###");
            String resp = formatter.format(number);
            resp = resp.replaceAll(",", ".");
            return resp;
        } catch (Exception e) {
            return "";
        }
    }

    public static String generatePassword(String password) {
        return SALT + (Md5.encryptMD5(SALT + (password.trim())));
    }

    public static void cLogin(HttpServletResponse response, HttpSession session) throws IOException {
        if (Tool.checkNull(session.getAttribute("acc"))) {
            try {
                response.sendRedirect("/login.jsp");
                return;
            } catch (Exception e) {
                System.out.println("CO LOI NHA");
            }
        }
    }

    public static void cPermission(HttpServletResponse response, boolean checkPermission) {
        if (!checkPermission) {
            System.out.println("ko duoc phep");
            try {
                response.sendRedirect("/");
                return;
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
                System.out.println("CO LOI NHA");
            }
        } else {
            System.out.println("DUOC PHEP");
        }
    }
    public static boolean validPhoneViettel84(String phone) {
//        String regex = "^(\\+849\\d{8})|(849\\d{8})|(09\\d{8})|(\\+841\\d{9})|(841\\d{9})|(01\\d{9})|(\\+848\\d{8})|(848\\d{8})|(08\\d{8})$";
        String regex = "^(\\"
                + "(8486\\d{7})|"
                + "(8496\\d{7})|"
                + "(8497\\d{7})|"
                + "(8498\\d{7})|"
                + "(84161\\d{7})|"
                + "(84162\\d{7})|"
                + "(84163\\d{7})|"
                + "(84164\\d{7})|"
                + "(84165\\d{7})|"
                + "(84166\\d{7})|"
                + "(84167\\d{7})|"
                + "(84168\\d{7})|"
                + "(84169\\d{7})"
                //===========
                + "(086\\d{7})|"
                + "(096\\d{7})|"
                + "(097\\d{7})|"
                + "(098\\d{7})|"
                + "(0161\\d{7})|"
                + "(0162\\d{7})|"
                + "(0163\\d{7})|"
                + "(0164\\d{7})|"
                + "(0165\\d{7})|"
                + "(0166\\d{7})|"
                + "(0167\\d{7})|"
                + "(0168\\d{7})|"
                + "(0169\\d{7})"
                + "$";
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);
        // Now create matcher object.
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
     public static String builPhone84(String phone) {
        String firstLetter = "";
        String strPhone = "";
        firstLetter = phone.substring(0, 1);
        firstLetter = phone.substring(0, 1);
        if ("0".equals(firstLetter)) {
            strPhone = "84";
            strPhone += phone.substring(1);
        } else {
            strPhone = phone;
        }
        return strPhone;
    }

}
