package com.cn.tianxia.admin.service.txdata.IntegralMallService.IntegralMallServiceImpl;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.GoodsInventoryMapper;
import com.cn.tianxia.admin.domain.txdata.IntegralMallMapper.OrderManageMapper;
import com.cn.tianxia.admin.domain.txdata.UserWalletLogMapper;
import com.cn.tianxia.admin.domain.txdata.UserWalletMapper;
import com.cn.tianxia.admin.project.txdata.IntegralMall.OrderManage;
import com.cn.tianxia.admin.project.txdata.UserWallet;
import com.cn.tianxia.admin.project.txdata.UserWalletLog;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.OrderManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/14 18:25
 * @Description: 订单管理serviceImpl
 */
@Service
public class OrderManageServiceImpl implements OrderManageService {

    @Autowired
    OrderManageMapper orderManageMapper;

    @Autowired
    UserWalletMapper userWalletMapper;

    @Autowired
    GoodsInventoryMapper goodsInventoryMapper;

    @Autowired
    UserWalletLogMapper userWalletLogMapper;

    @Override
    public Pager<OrderManage> queryOrderManageInfo(Map<String, String> params) {
        Pager<OrderManage> pager = new Pager<>(params);
        List<OrderManage> list = orderManageMapper.selectPluOrder(pager);
        int count = orderManageMapper.selectPluOrderCount(pager);
        pager.setList(list);
        pager.setTotalCount(count);
        return pager;
    }

    @Override
    public int updateByPrimaryKeySelective(OrderManage orderManage) {
        return orderManageMapper.updateByPrimaryKeySelective(orderManage);
    }

    @Override
    public OrderManage selectByPrimaryKey(Integer id) {
        return orderManageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert_auditOrder(OrderManage orderManage) {
        //审核通过
        if (orderManage.getOrderState() == 1) {
            //从冻结积分中扣除相应积分
            //获取要被扣除的积分
            double price = orderManage.getPrice() * orderManage.getPluNumber();

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("uid", orderManage.getUid());
            param.put("type", "1");
            List<UserWallet> walletList = userWalletMapper.selectByMap(param);
            if (null != walletList && walletList.size() > 0) {
                UserWallet wallet = walletList.get(0);
                //如果冻结积分小于price
                if (wallet.getFrozenBalance() < price) {
                    return -1;
                }
                wallet.setFrozenBalance(wallet.getFrozenBalance() - price);
                //更新冻结积分
                userWalletMapper.updateByPrimaryKeySelective(wallet);

                //更新库存数量和冻结数量
                Map<String, Object> queryMap = new HashMap<String, Object>();
                queryMap.put("pluId", orderManage.getPluId());
                queryMap.put("freezeNum", -orderManage.getPluNumber());
                goodsInventoryMapper.updateStore(queryMap);
            }

        } else {
            //审核不通过

            //从冻结积分中解冻相应积分
            double price = orderManage.getPrice() * orderManage.getPluNumber();

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("uid", orderManage.getUid());
            param.put("type", "1");
            List<UserWallet> walletList = userWalletMapper.selectByMap(param);
            if (null != walletList && walletList.size() > 0) {
                UserWallet wallet = walletList.get(0);
                UserWalletLog userWalletLog = new UserWalletLog();
                if (wallet.getFrozenBalance() < price) {
                    return -1;
                }
                userWalletLog.setOldMoney(wallet.getBalance());
                wallet.setFrozenBalance(wallet.getFrozenBalance() - price);
                wallet.setBalance(wallet.getBalance() + price);
                //更新冻结积分
                userWalletMapper.updateByPrimaryKeySelective(wallet);

                //记录流水
                userWalletLog.setUid(orderManage.getUid());
                userWalletLog.setType("IN");
                userWalletLog.setWtype("1");
                userWalletLog.setAmount(price);
                userWalletLog.setNewMoney(wallet.getBalance());
                userWalletLog.setUptime(orderManage.getAuditTime());
                userWalletLog.setUpuid(orderManage.getAuditId());
                userWalletLog.setRmk("解冻订单号：" + orderManage.getId() + " 的积分！");
                userWalletLogMapper.insertSelective(userWalletLog);

                //更新冻结库存
                Map<String, Object> queryMap = new HashMap<String, Object>();
                queryMap.put("pluId", orderManage.getPluId());
                queryMap.put("num", orderManage.getPluNumber());
                queryMap.put("freezeNum", -orderManage.getPluNumber());
                goodsInventoryMapper.updateStore(queryMap);

                //生成库存日志
                queryMap.clear();
                queryMap.put("cid", orderManage.getCid());
                queryMap.put("pluid", orderManage.getPluId());
                queryMap.put("orderno", orderManage.getId());
                queryMap.put("num", orderManage.getPluNumber());
                queryMap.put("type", "IN");
                queryMap.put("tType", "6");
                queryMap.put("uptime", new Date());
                queryMap.put("upuid", orderManage.getAuditId());
                goodsInventoryMapper.updatePluInvLog(queryMap);
            }
        }
        goodsInventoryMapper.updateByPrimaryKeySelective(orderManage);
        return 0;
    }
}
