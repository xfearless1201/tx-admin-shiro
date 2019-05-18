package com.cn.tianxia.admin.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @ClassName GameRecordQuery
 * @Description TODO(游戏注单查询条件常量 和 通用方法)
 * @author Hardy
 * @Date 2019年5月12日 下午3:08:08
 * @version 1.0.0
 */
public class GameRecordQuery {

    /**
     * 按照会员账号查询
     */
    public static final int QUERY_BY_USERNAME = 0;
    /**
     * 按照真实姓名查询
     */
    public static final int QUERY_BY_REALNAME = 1;
    /**
     * 按照代理商查询
     */
    public static final int QUERY_BY_TOPUIDNAME = 2;
    /**
     * 按照会员分层查询
     */
    public static final int QUERY_BY_USERTYPENAME = 3;
    
    /**
     * 设置查询条件
     */
    public static void setContitions(Pager<?> pager){

        String startTime = pager.getParams().get("startTime");
        String endTime = pager.getParams().get("endTime");        
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        //开始时间与结束时间转换
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, dateTimeFormatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, dateTimeFormatter);
        
        //开始时间的日期与时间
        LocalDate startLocalDate = startDateTime.toLocalDate();
        LocalTime startLocalTime = startDateTime.toLocalTime();
        
        //结束时间的日期与时间
        LocalDate endLocalDate = endDateTime.toLocalDate();
        LocalTime endLocalTime = endDateTime.toLocalTime();
        //比较日期
        Period period = Period.between(startLocalDate, endLocalDate);
        
        //如果开始时间与结束时间日期间隔大于1天，则不满足一天的时间段需要查询明细表，满足一天的查询汇总表
        if(period.getMonths()>0 || period.getYears()>0 || period.getDays()>1){
            //如果开始时间不是00:00:00结束，即不是完整的一天
            if(!"00:00".equals(startLocalTime.toString())){
                String startTime1 = startLocalDate.toString()+" 23:59:59";
                pager.getParams().put("startTime1", startTime1);
                //汇总从下一天开始
                pager.getParams().put("nextStartDay", startLocalDate.plusDays(1).toString()+" 00:00:00");
            }else{
                pager.getParams().put("nextStartDay", startTime);
            }
            //如果结束时间不是23:59:59结束，即不是完整的一天
            if(!"23:59:59".equals(endLocalTime.toString())){
                String endTime1 = endLocalDate.toString()+" 00:00:00";
                pager.getParams().put("endTime1", endTime1);
                //汇总从上一天结束
                pager.getParams().put("lastEndDay", endLocalDate.minusDays(1).toString()+" 23:59:59");
            }else{
                pager.getParams().put("lastEndDay", endTime);
            }
        }
    }
}
