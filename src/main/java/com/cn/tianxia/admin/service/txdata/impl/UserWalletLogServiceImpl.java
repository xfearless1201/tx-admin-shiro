package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.tianxia.admin.domain.txdata.UserWalletLogMapper;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;
import com.cn.tianxia.admin.service.txdata.UserWalletLogService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserWalletLogServiceImpl implements UserWalletLogService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(UserWalletLogServiceImpl.class);

    @Autowired
    private UserWalletLogMapper userWalletLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userWalletLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserWalletLog record) {
        return userWalletLogMapper.insertSelective(record);
    }

    @Override
    public UserWalletLog selectByPrimaryKey(Integer id) {
        return userWalletLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserWalletLog record) {
        return userWalletLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<UserWalletLog> selectDataGrid(Map<String, String> params) {
        Pager<UserWalletLog> pager = new Pager<>(params);
        List<UserWalletLog> resultList = userWalletLogMapper.selectList(pager);
        Map<String, Object> resultMap = userWalletLogMapper.countList(pager);
        pager.setList(resultList);
        pager.setTotalCount(Integer.parseInt(resultMap.get("total") + ""));
        //添加小计
        double totalAmount = 0;
        for (UserWalletLog userWalletLog : resultList) {
            totalAmount += userWalletLog.getAmount();
        }
        UserWalletLog total = new UserWalletLog();
        total.setAmount(totalAmount);
        total.setUsername("小计:");
        pager.getList().add(total);

        //添加总计
        UserWalletLog sumTotal = new UserWalletLog();
        sumTotal.setAmount(resultMap.containsKey("amount") ? Double.parseDouble(resultMap.get("amount") + "") : 0);
        sumTotal.setUsername("合计:");
        pager.getList().add(sumTotal);

        return pager;
    }

}
