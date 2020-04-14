package com.dgz.springboot15.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    private static SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDateTime(){
        return dateTime.format(new Date());
    }

    public static String getDate(){
        return date.format(new Date());
    }

}
