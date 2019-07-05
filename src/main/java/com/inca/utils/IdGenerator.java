package com.inca.utils;
/**
 *
 * @author Zsheng
 * @create 2017-10-18 14:01
 **/
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class IdGenerator {
	public static String PrimaryKey(){
		//自动生成uuid replace是去除字符串中的 - "" 
        return UUID.randomUUID().toString().replace("-", "");
    }
    //生成与当前时间有关系的ID号（用于订单号的生成）
    //System.nanoTime() 1970.1.1号0:00开始 纳秒
    public static String genOrdersNum(){
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String str = df.format(now)+System.currentTimeMillis();//得到当前时间的毫秒值
        return str;
    }
}
