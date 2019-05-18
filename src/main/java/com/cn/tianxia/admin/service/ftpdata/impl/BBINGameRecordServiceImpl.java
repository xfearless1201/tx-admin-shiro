package com.cn.tianxia.admin.service.ftpdata.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.GameRecordQuery;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.BbinGameRecordMapper;
import com.cn.tianxia.admin.domain.ftpdata.GameRecordCommonMapper;
import com.cn.tianxia.admin.project.ftpdata.BbinGameRecord;
import com.cn.tianxia.admin.project.ftpdata.BbinJpPrizeRecord;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.project.ftpdata.TUser;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.ftpdata.BBINGameRecordService;
import com.cn.tianxia.admin.service.txdata.SysUserService;

/**
 * 
 * @ClassName BbinGameQueryServiceImpl
 * @Description TODO(BBIN电子注单查询服务)
 * @author Hardy
 * @Date 2019年5月16日 上午10:36:53
 * @version 1.0.0
 */
@Service
public class BBINGameRecordServiceImpl implements BBINGameRecordService {

    private Logger logger = LoggerFactory.getLogger(BBINGameRecordServiceImpl.class);
    
    @Autowired
    private BbinGameRecordMapper bbinGameRecordMapper;
    @Autowired
    private GameRecordCommonMapper<BbinGameRecord> commonMapper;
    @Autowired
    private SysUserService sysUserService;
    
    @SuppressWarnings("unchecked")
    @Override
    public Pager<BbinGameRecord> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class, data);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
      return null;
  }

    @Override
    public Pager<BbinGameRecord> list(Pager<BbinGameRecord> pager) throws Exception {
        
        int queryType = Integer.parseInt(pager.getParams().get("queryType"));
        Pager<BbinGameRecord> resultPager = null;
        // 如果查询条件是 按照用户真实姓名查询
        if(queryType == GameRecordQuery.QUERY_BY_REALNAME){
            resultPager = listRecordByRealName(pager);
        }else if(queryType == GameRecordQuery.QUERY_BY_TOPUIDNAME){ // 如果查询条件是 按照代理商查询
            resultPager = listRecordBytopUidName(pager);
        }else if(queryType == GameRecordQuery.QUERY_BY_USERTYPENAME){ // 如果查询条件是 按照会员分层查询
            resultPager = listRecordByUserTypeName(pager);
        }else if(queryType == GameRecordQuery.QUERY_BY_USERNAME){ // 如果查询条件是 按照会员账号查询
            resultPager = listRecordByAgUserName(pager);
        }
        return resultPager;
    }

    @Override
    public Pager<BbinGameRecord> listRecordByRealName(Pager<BbinGameRecord> pager) {
        // 先通过realName 查询出用户信息
        List<TUser> usersList = commonMapper.listTuser(pager);
        
        String realName = pager.getParams().get("name");
        // 集合为空则返回
        if(usersList.size() == 0){
            if(null != realName && realName.length() != 0){
                logger.error("用户姓名{}不存在", realName);
                throw new RuntimeException(String.format("用户姓名%s不存在", realName));
            }
        }
        
        // 拿出查询到的会员账号
        String userName;
        if(null != realName && realName.length() != 0){
            userName =  usersList.parallelStream().map(tUser -> tUser.getAgUsername()).collect(Collectors.toSet()
                    ).parallelStream().collect(Collectors.joining("','", "('", "')"));
            pager.getParams().put("userName", userName);
            pager.getParams().put("userNames", userName);
        }
        
        //根据查询到的会员账号反查出游戏记录
        List<BbinGameRecord> agBrList = bbinGameRecordMapper.listGameRecord(pager);
        // 没有查询到则返回
        if(agBrList.size() ==0){
            return doCountSum(null, agBrList, pager);
        }
        
        //从查询结果中拿出查到的会员账号
        userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
        
        return handleRecordList(agBrList,pager);
    }

    @Override
    public Pager<BbinGameRecord> listRecordBytopUidName(Pager<BbinGameRecord> pager) {
        // 如果传过来的是'平台会员'，则代理商id=0
        String topUidName = pager.getParams().get("name");
        if("平台会员".equals(topUidName)){
            pager.getParams().put("topUidName", "0");
        }else if(null != topUidName && topUidName.length() != 0){ 
            SysUser sysUser = sysUserService.selectByLoginName(topUidName);
            if(null == sysUser){
                logger.error("找不到代理商信息,请确认代理商{}是否正确", topUidName);
                throw new RuntimeException(String.format("找不到代理商信息，请确认代理商%s是否正确", topUidName));
            }
            pager.getParams().put("topUidName", sysUser.getCid().toString());
        }
        
        // 查询用户信息
        List<TUser> usersList = commonMapper.listTuser(pager);
        
        // 集合为空则返回
        if(usersList.size() == 0){
            logger.error("代理商{}下没有会员", topUidName);
            throw new RuntimeException(String.format("代理商%s下没有会员", topUidName));
        }
        
        // 拿出查询到的会员账号
        String userName ;
        if(null != topUidName && topUidName.length() != 0){
            userName =  usersList.parallelStream().map(tUser -> tUser.getAgUsername()).collect(Collectors.toSet()
                    ).parallelStream().collect(Collectors.joining("','", "('", "')"));
            pager.getParams().put("userName", userName);
            pager.getParams().put("userNames", userName);
        }
        List<BbinGameRecord> agBrList = bbinGameRecordMapper.listGameRecord(pager);
        // 没有查询到则返回
        if(agBrList.size() ==0){
            return doCountSum(null, agBrList, pager);
        }
        userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
        
        return handleRecordList(agBrList,pager) ;
    }

    @Override
    public Pager<BbinGameRecord> listRecordByUserTypeName(Pager<BbinGameRecord> pager) {
        String userTypeName = pager.getParams().get("name");
        if(null != userTypeName && userTypeName.length() != 0){
            List<Integer> userTypeIdList = commonMapper.findIdsByUserTypeName(pager);
            if(userTypeIdList.size() == 0){
                logger.error("找不到会员分层信息,请确认会员分层账号{}是否正确", userTypeName);
                throw new RuntimeException(String.format("找不到会员分层信息,请确认会员分层账号%s是否正确", userTypeName));
            }
            userTypeName = userTypeIdList.parallelStream().map(userTypeId -> userTypeId.toString()).collect(Collectors.toSet()
                    ).parallelStream().collect(Collectors.joining(",","(",")"));
            pager.getParams().put("userTypeName", userTypeName);
        }
        
        // 查询用户信息
        List<TUser> usersList = commonMapper.listTuser(pager);
        
        if(usersList.size() == 0){
            logger.error("分层账号{}下没有会员", userTypeName);
            throw new RuntimeException(String.format("分层账号%s下没有会员", userTypeName));
        }
        
        // 拿出查询到的会员账号
        String userName;
        if(null != userTypeName && userTypeName.length() != 0){
             userName =  usersList.parallelStream().map(tUser -> tUser.getAgUsername()).collect(Collectors.toSet()
                    ).parallelStream().collect(Collectors.joining("','", "('", "')"));
            pager.getParams().put("userName", userName);
            pager.getParams().put("userNames", userName);
        }
        List<BbinGameRecord> agBrList = bbinGameRecordMapper.listGameRecord(pager);
        // 没有查询到则返回
        if(agBrList.size() ==0){
            return doCountSum(null, agBrList, pager);
        }
        userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
      
        return handleRecordList(agBrList, pager);
      }

    @Override
    public Pager<BbinGameRecord> listRecordByAgUserName(Pager<BbinGameRecord> pager) {
        // 查询注单结果
        List<BbinGameRecord> agBrList = bbinGameRecordMapper.listGameRecord(pager);
        if(agBrList.size() == 0){
            return doCountSum(null, agBrList, pager);
        }
        // 根据注单结果中的会员账号查询会员信息
        String userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
        
        return handleRecordList(agBrList,pager);
    }

    @Override
    public Pager<BbinGameRecord> handleRecordList(List<BbinGameRecord> agBrList, Pager<BbinGameRecord> pager) {
        
        //如果是分组查询
        String userGrouping = pager.getParams().get("userGrouping");
        if(!"0".equals(userGrouping)){
            //统计总数 总条数，总投注额，有效输赢额
            GameRecordQuery.setContitions(pager);
            List<Map<String, Object>> countResult = bbinGameRecordMapper.countTotal(pager);
            //开始汇总
            return doCountSum(countResult,agBrList,pager);
        }
        
        // 查询用户信息
        List<TUser> usersList = commonMapper.listTuser(pager);
        
        // 根据注单查询查询bbin奖金
        String wagersIds = agBrList.parallelStream().map(agbr -> agbr.getWagersid())
                .collect(Collectors.joining("','","('","')"));
        pager.getParams().put("wagersIDs", wagersIds);
        Map<String,BbinJpPrizeRecord> prizeMap = bbinGameRecordMapper.listBbinPrizeByWagersId(pager);
        
        //组装游戏结果
        agBrList = agBrList.parallelStream().flatMap(agbr -> usersList.parallelStream()
                .filter(tUser -> agbr.getUsername().equals(tUser.getAgUsername())).map(tUser -> {
                    agbr.setRealName(tUser.getRealname());
                    return agbr;
                })
            ).collect(Collectors.toList());
        
        if(prizeMap.size() != 0){
                agBrList.parallelStream().forEach(agbr -> {
                    if(prizeMap.containsKey(agbr.getWagersid())){
                        agbr.setPrize(prizeMap.get(agbr.getWagersid()).getJpamount());
                    }
            });
        }
        
        //统计总数 总条数，总投注额，有效输赢额
        GameRecordQuery.setContitions(pager);
        List<Map<String, Object>> countResult = bbinGameRecordMapper.countTotal(pager);
        //开始汇总
        Pager<BbinGameRecord> resultPager = doCountSum(countResult,agBrList,pager);
        return resultPager;
    }

    @Override
    public Pager<BbinGameRecord> doCountSum(List<Map<String, Object>> countResult, List<BbinGameRecord> agBrList,
            Pager<BbinGameRecord> pager) {
        Map<String, String> map1 = new HashMap<>();
        
        if(agBrList.size() == 0){
            map1.put("totalCount", "0");
            map1.put("validTotalCount", "0");
            map1.put("betAmount", "0");
            map1.put("netAmount", "0");
            map1.put("validBetAmount", "0");
            
            map1.put("pageTotalCount", "0");
            map1.put("pageValidTotalCount", "0");
            map1.put("pageBetAmount", "0");
            map1.put("pageNetAmount", "0");
            map1.put("pageValidBetAmount", "0");
            
            Pager<BbinGameRecord> resultPager = new Pager<>(0, pager.getPage(), pager.getLimit());
            resultPager.setList(agBrList);
            resultPager.setParams(map1);
            return resultPager;
        }
        
        //注单总数
        Integer totalNum = countResult.parallelStream().mapToInt(map -> Integer.parseInt(map.get("noteNum").toString())).sum();
        map1.put("totalNum", totalNum.toString());
        
        Integer validTotalNum = countResult.parallelStream().mapToInt(map -> Integer.parseInt(map.get("validNoteNum").toString())).sum();
        map1.put("validTotalNum", validTotalNum.toString());
        
        BigDecimal betAmount = new BigDecimal(countResult.parallelStream().mapToDouble(map -> Double.parseDouble(
                map.get("betAmount").toString())).sum());
        map1.put("betAmount", betAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        
        BigDecimal netAmount = new BigDecimal(countResult.parallelStream().mapToDouble(map -> Double.parseDouble(map.get("netAmount").toString())).sum());
        map1.put("netAmount", netAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        
      
        BigDecimal validBetAmount = new BigDecimal(countResult.parallelStream().mapToDouble(map -> Double.parseDouble(map.get("validBetAmount").toString())).sum());
        map1.put("validBetAmount", validBetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        
        //当前页小计
        Integer pageTotalNum ;
        String userGrouping = pager.getParams().get("userGrouping");
        Integer pageValidTotalNum ;
        BigDecimal pageBetAmount = new BigDecimal(agBrList.parallelStream().mapToDouble(map -> Double.parseDouble(
                String.valueOf(Math.abs(map.getBetamount())))).sum());
        BigDecimal pageNetAmount = new BigDecimal(agBrList.parallelStream().mapToDouble(map -> Double.parseDouble(map.getPayoff().toString())).sum());
        BigDecimal pageValidBetAmount = new BigDecimal(agBrList.parallelStream().mapToDouble(map -> Double.parseDouble(
                String.valueOf(Math.abs(map.getCommissionable())))).sum());
        // 如果不是按照用户分组
        if("0".equals(userGrouping)){
            pageTotalNum = agBrList.size();
            pageValidTotalNum = agBrList.size();
        }else{
            pageTotalNum = agBrList.parallelStream().mapToInt(map -> map.getId()).sum();
            pageValidTotalNum = agBrList.parallelStream().mapToInt(map -> map.getId()).sum();
        }
        map1.put("pageTotalCount", pageTotalNum.toString());
        map1.put("pageValidTotalCount", pageValidTotalNum.toString());
        map1.put("pageBetAmount", pageBetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        map1.put("pageNetAmount", pageNetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        map1.put("pageValidBetAmount", pageValidBetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        
        Pager<BbinGameRecord> resultPager = new Pager<>(totalNum, pager.getPage(), pager.getLimit());
        resultPager.setList(agBrList);
        resultPager.setParams(map1);
        
        return resultPager;
    }

}
