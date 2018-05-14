/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.htc.airtime.components;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class MyDate {

    public static String createDate(String typeFormat) {
        String timeStamp = new SimpleDateFormat(typeFormat).format(Calendar.getInstance().getTime());

        return timeStamp;
    }

    public static Timestamp createDateTime(String typeFormat) {
        String timeStamp = new SimpleDateFormat(typeFormat).format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();

        long time = calendar.getTime().getTime();

        Timestamp date = DateProc.createTimestamp();

        return date;
    }

    public static String convertDate(String input, String typeFormat) {
        typeFormat = "yyyy-MM-dd";
        java.util.Date date = new Date(input);
        SimpleDateFormat formatter = new SimpleDateFormat(typeFormat);
        String format = formatter.format(date);
        return format;
    }

    public static String getStringDate(String y,String m,String d,String h,String i) {
        System.out.println("DAY LA DOAN COD SINH String ngay theo typeFormat");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date(System.currentTimeMillis()));

        String strTemp = calendar.get(Calendar.YEAR) + "";
        strTemp +=y;
        if (calendar.get(Calendar.MONTH) + 1 < 10) {
            strTemp += "0" + (calendar.get(Calendar.MONTH) + 1);
        } else {
            strTemp += "" + (calendar.get(Calendar.MONTH) + 1);
        }
        strTemp +=m;
        if (calendar.get(Calendar.DAY_OF_MONTH) < 10) {
            strTemp += "0" + (calendar.get(Calendar.DAY_OF_MONTH));
        } else {
            strTemp += calendar.get(Calendar.DAY_OF_MONTH);
        }
        strTemp +=d;
        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
            strTemp += "0" + calendar.get(Calendar.HOUR_OF_DAY);
        } else {
            strTemp += calendar.get(Calendar.HOUR_OF_DAY);
        }
        strTemp +=h;
        if (calendar.get(Calendar.MINUTE) < 10) {
            strTemp += "0" + calendar.get(Calendar.MINUTE);
        } else {
            strTemp += calendar.get(Calendar.MINUTE);
        }
        strTemp +=i;
        if (calendar.get(Calendar.SECOND) < 10) {
            strTemp += "0" + calendar.get(Calendar.SECOND);
        } else {
            strTemp += calendar.get(Calendar.SECOND);
        }
        return strTemp;
    }

    public static void main(String[] args) {

        System.out.println(createDate("yyyy/dd-MM HH:mm:ss"));

    }

}
