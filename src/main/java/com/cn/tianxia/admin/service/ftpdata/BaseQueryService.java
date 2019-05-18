package com.cn.tianxia.admin.service.ftpdata;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.alibaba.fastjson.JSONObject;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.FormData;

/**
 * @ClassName BaseQueryService
 * @Description TODO(通用查询接口，比如查询汇总)
 * @author Hardy
 * @Date 2019年4月28日 上午10:04:25
 * @version 1.0.0
 */
public interface BaseQueryService<T> {

    /**
     * @param <T>
     * @param data
     * @Description (将表单数据类型转换成统一的查询参数Pager)
     * @return
     */
    public Pager<T> transFormDataToPager(FormData data);

    /**
     * 
     * @param <U>
     * @Description (产生实例对象)
     * @return
     */
   @SuppressWarnings("unchecked")
   default <U> U newInstance(Class<U> class1,Object obj) throws Exception{
       if(null == class1){
           throw new IllegalArgumentException("clazz is null");
       }
       //obj为空则返回类型U
       U t = (U) Class.forName(class1.getName()).newInstance();
       if(null == obj){
           return t;
       } 
       //class类型不为空，且object不为空，则表示对象互转
       //如果是pager类型,obj是FormData
       if(class1.isAssignableFrom(Pager.class) && obj.getClass().isAssignableFrom(FormData.class)){
           Pager<T> pager = (Pager<T>) Class.forName(class1.getName()).newInstance();
           pager.setLimit(((FormData)obj).getRows());
           pager.setPage(((FormData)obj).getPage());
           HashMap<String, String> params = new HashMap<>(8);
           Field[] fields = obj.getClass().getDeclaredFields();
           Stream.of(fields).forEach(filed -> {
               if(!filed.getName().equals("serialVersionUID")){
                   try {
                       String fieldsName = filed.getName();
                       char[] cs = fieldsName.toCharArray();
                       cs[0]-=32;
                       fieldsName = "get"+String.valueOf(cs);
                       Method method = obj.getClass().getMethod(fieldsName,new Class[]{});
                       Object objValue = method.invoke(obj,new Object[]{});
                       params.put(filed.getName(), (null == objValue ? null : String.valueOf(objValue)));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
               }
           });
           pager.setParams(params);
           return (U) pager;
       }else{ //其他类型
           t = JSONObject.parseObject(JSONObject.toJSONString(obj), class1);
       }
       return t;
    };

    /**
     * @param <T>
     * @Description (查询注单记录)
     * @param pager
     * @return
     */
    public Pager<T> list(Pager<T> pager) throws Exception;
    
    /**
     * 
     * @Description (按照真实姓名查询)
     * @param pager
     * @return
     */
    public Pager<T> listRecordByRealName(Pager<T> pager);
    
    /**
     * 
     * @Description (按照代理商查询)
     * @param pager
     * @return
     */
    public Pager<T> listRecordBytopUidName(Pager<T> pager);

    /**
     * 
     * @Description (按照会员分层查询)
     * @param pager
     * @return
     */
    public Pager<T> listRecordByUserTypeName(Pager<T> pager);
    
    /**
     * 
     * @Description (按照会员账号查询)
     * @param pager
     * @return
     */
    public Pager<T> listRecordByAgUserName(Pager<T> pager);
    
    /**
     * 
     * @Description (处理查询出来的结果)
     * @param agBrList
     * @param pager
     * @return
     */
    public Pager<T> handleRecordList(List<T> agBrList,Pager<T> pager);
    
    /**
     * 
     * @Description (汇总)
     * @param countResult
     * @param agBrList
     * @param pager
     * @return
     */
    public Pager<T> doCountSum(List<Map<String, Object>> countResult,List<T> agBrList,Pager<T> pager);
}
