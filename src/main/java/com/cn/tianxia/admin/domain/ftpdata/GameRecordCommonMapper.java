package com.cn.tianxia.admin.domain.ftpdata;

import java.util.List;
import java.util.Map;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.TUser;
import com.cn.tianxia.admin.project.txdata.SysUser;

/**
 * 
 * @ClassName CommonMapper
 * @Description TODO(注单通用查询方法)
 * @author Hardy
 * @Date 2019年5月7日 下午2:39:41
 * @version 1.0.0
 */
public interface GameRecordCommonMapper<T> {
       
    /**
     * 
     * @Description (查询用户信息)
     * @param pager
     * @return
     */
    List<TUser> listTuser(Pager<T> pager);

    /**
     * 
     * @Description (根据会员分层查询出分层id信息)
     * @param pager
     * @return
     */
    List<Integer> findIdsByUserTypeName(Pager<T> pager);
    
    /**
     * 
     * @Description (根据平台商名称查询此平台商信息)
     * @param pager
     * @return
     */
    SysUser findTopUidByTopUidName(Pager<T> pager);

    /**
     * 
     * @Description (查询数据字典)
     * @return
     */
    List<Map<String, String>> listDicData(Pager<T> pager);
    
    /**
     * 
     * @Description (查询游戏记录)
     * @param pager
     * @return
     */
    List<T> listGameRecord(Pager<T> pager);
    
    /**
     * 
     * @Description (查询游戏类型)
     * @param pager
     * @return
     */
    List<Map<String, String>> listGameType(Pager<T> pager);
    
    
    /**
     * 
     * @Description (统计游戏注单量，输赢额，有效投注额，投注额)
     * @param pager
     * @return
     */
    List<Map<String, Object>> countTotal(Pager<T> pager);
}
