package com.cn.tianxia.admin.domain.ftpdata;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.ftpdata.BbinGameRecord;
import com.cn.tianxia.admin.project.ftpdata.BbinJpPrizeRecord;

public interface BbinGameRecordMapper extends GameRecordCommonMapper<BbinGameRecord>{
    int deleteByPrimaryKey(Integer id);

    int insert(BbinGameRecord record);

    int insertSelective(BbinGameRecord record);

    BbinGameRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BbinGameRecord record);

    int updateByPrimaryKey(BbinGameRecord record);
    
    /**
     * 查询bbin电子奖金
     */
//    List<BbinJpPrizeRecord> listBbinPrizeByWagersId(String wagersIds);
    
    /**
     * 查询BBIN电子奖金
     */
    @MapKey("wagersid")
    Map<String, BbinJpPrizeRecord> listBbinPrizeByWagersId(Pager<BbinGameRecord> pager);
}