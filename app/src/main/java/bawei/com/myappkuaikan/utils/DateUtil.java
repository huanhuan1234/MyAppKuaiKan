package bawei.com.myappkuaikan.utils;

import android.annotation.SuppressLint;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bawei.com.myappkuaikan.bean.WeekInfoBean;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class DateUtil {

    public static final List<WeekInfoBean> getData() {
        List<WeekInfoBean> list = new ArrayList<>();
        for (int i =7;i>0;i--){
            list.add(new WeekInfoBean(i,getTimesmorning() - 60 * 60 * 24 * i));
        }
        return list;
    }

    //获得当天0点时间
    @SuppressLint("WrongConstant")
    public static int getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }


    //判断当前是周几
    @SuppressLint("WrongConstant")
    public static String getWeek() {
        String week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        String str = format.format(curDate);
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(format.parse(str));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            week += "天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            week += "六";
        }
        return week;
    }
    public static final String[] initWeek() {
        String weekDetil = getWeek();
        String[] week = null;
        switch (weekDetil) {
            case "一":
                week = new String[]{"周二","周三","周四","周五","周六","昨天","今天"};
                break;
            case "二":
                week = new String[]{"周三","周四","周五","周六","周日","昨天","今天"};
                break;
            case "三":
                week = new String[]{"周四","周五","周六","周日","周一","昨天","今天"};
                break;
            case "四":
                week = new String[]{"周五","周六","周日","周一","周二","昨天","今天"};
                break;
            case "五":
                week = new String[]{"周六","周日","周一","周二","周三","昨天","今天"};
                break;
            case "六":
                week = new String[]{"周日","周一","周二","周三","周四","昨天","今天"};
                break;
            case "天":
                week = new String[]{"周一","周二","周三","周四","周五","昨天","今天"};
                break;
        }
        return week;
    }
}
