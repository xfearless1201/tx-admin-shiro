package com.cn.tianxia.admin.service.txdata;

import com.cn.tianxia.admin.project.txdata.QrcodeOss;

public interface QrcodeOssService {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(QrcodeOss record);

    QrcodeOss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrcodeOss record);
}
