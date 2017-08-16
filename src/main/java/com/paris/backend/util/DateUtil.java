package com.paris.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat simpleDateFormat =null;
    public static int daysBetween(Date smdate, Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long stime = cal.getTimeInMillis();
        cal.setTime(bdate);
        long btime = cal.getTimeInMillis();
        long between_days=(btime-stime)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static Date stringToDate(String string) throws Exception
    {
        return getSimpleDateFormat().parse(string);
    }

    public static SimpleDateFormat getSimpleDateFormat()
    {
        if (simpleDateFormat==null)
        {
          return   simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        }
        return simpleDateFormat;
    }
}
