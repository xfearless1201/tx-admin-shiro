package com.cn.tianxia.admin.domain.txdata;

import com.cn.tianxia.admin.project.txdata.QrcodeOss;

public interface QrcodeOssMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QrcodeOss record);

    int insertSelective(QrcodeOss record);

    QrcodeOss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QrcodeOss record);

    int updateByPrimaryKey(QrcodeOss record);
}