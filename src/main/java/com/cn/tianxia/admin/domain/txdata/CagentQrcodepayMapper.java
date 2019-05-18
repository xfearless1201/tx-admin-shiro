package com.cn.tianxia.admin.domain.txdata;

import java.util.List;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.project.txdata.CagentQrcodepay;

public interface CagentQrcodepayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CagentQrcodepay record);

    int insertSelective(CagentQrcodepay record);

    CagentQrcodepay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CagentQrcodepay record);

    int updateByPrimaryKey(CagentQrcodepay record);

    List<CagentQrcodepay> findAllByPage(Pager<CagentQrcodepay> pager);

    int getCagentQrcodeTotalCounts(Pager<CagentQrcodepay> pager);
}