package com.data.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description: 时间转换工具
 * @Auther  hx
 * @Date 2022-05-12 10:32
 */
public class DateFormatUtils {

    public static final DateTimeFormatter DTF_YYYYMMDD_HHMMSS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static LocalDateTime strToLocalDateTime(String dateStr){
        LocalDateTime localDateTime = null;
        if(StringUtils.isNotBlank(dateStr) && dateStr.contains("+08:")){
            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
            localDateTime = LocalDateTime.of(date, LocalTime.parse("00:00:00"));
        }else if(StringUtils.isNotBlank(dateStr) && dateStr.contains("CST")){
            String date1 =new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dateStr));
            localDateTime=strToDateTimeDefine(date1,DTF_YYYYMMDD_HHMMSS);
        }else if(StringUtils.isNotBlank(dateStr) && dateStr.contains("T")){
            localDateTime = LocalDateTime.parse(dateStr,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }else if(StringUtils.isNotBlank(dateStr) && dateStr.length() == 8){
            LocalDate date = LocalDate.parse("20190127",DateTimeFormatter.BASIC_ISO_DATE);
            localDateTime = LocalDateTime.of(date, LocalTime.parse("00:00:00"));
        }else{
            localDateTime=strToDateTimeDefine(dateStr,DTF_YYYYMMDD_HHMMSS);
        }
        return localDateTime;
    }


    public static LocalDateTime strToDateTimeDefine(String dateStr,DateTimeFormatter formatter){
        LocalDateTime localDateTime = null;
        if(StringUtils.isNotBlank(dateStr) ){
            localDateTime = LocalDateTime.parse(dateStr,formatter);
        }
        return localDateTime;
    }

    public static void main(String[] args) {
        String dateStr = "1900-07-08+08:05";
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        LocalDateTime localDateTime = LocalDateTime.of(date, LocalTime.parse("00:00:00"));
        System.out.println(localDateTime);
    }

}
