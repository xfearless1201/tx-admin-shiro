package com.cn.tianxia.admin.service.ftpdata.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.common.GameRecordQuery;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.ftpdata.BbinRecordMapper;
import com.cn.tianxia.admin.domain.ftpdata.GameRecordCommonMapper;
import com.cn.tianxia.admin.project.ftpdata.BbinRecord;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.project.ftpdata.TUser;
import com.cn.tianxia.admin.project.txdata.SysUser;
import com.cn.tianxia.admin.service.ftpdata.BBINService;
import com.cn.tianxia.admin.service.txdata.SysUserService;

/**
 * 
 * @ClassName BBINServiceImpl
 * @Description TODO(BBIN视讯服务)
 * @author Hardy
 * @Date 2019年5月12日 下午4:23:35
 * @version 1.0.0
 */
@Service
public class BBINServiceImpl implements BBINService{

    private Logger logger = LoggerFactory.getLogger(BBINServiceImpl.class);
    
    @Autowired
    private BbinRecordMapper bbinRecordMapper;
    @Autowired
    private GameRecordCommonMapper<BbinRecord> commonMapper;
    @Autowired
    private SysUserService sysUserService;

    @SuppressWarnings("unchecked")
    @Override
    public Pager<BbinRecord> transFormDataToPager(FormData data) {
        try {
            return newInstance(Pager.class, data);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Pager<BbinRecord> list(Pager<BbinRecord> pager) throws Exception {
        
        int queryType = Integer.parseInt(pager.getParams().get("queryType"));
        Pager<BbinRecord> resultPager = null;
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

    /**
     * 
     * @Description (按照真实姓名查询)
     * @param pager
     * @return
     */
    @Override
    public Pager<BbinRecord> listRecordByRealName(Pager<BbinRecord> pager){
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
        List<BbinRecord> agBrList = bbinRecordMapper.listGameRecord(pager);
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
    
    /**
     * 
     * @Description (按照代理商查询)
     * @param topUidName
     * @param userTypeName
     * @return
     */
    @Override
    public Pager<BbinRecord> listRecordBytopUidName(Pager<BbinRecord> pager){
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
        List<BbinRecord> agBrList = bbinRecordMapper.listGameRecord(pager);
        // 没有查询到则返回
        if(agBrList.size() ==0){
            return doCountSum(null, agBrList, pager);
        }
        userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
        
        return handleRecordList(agBrList,pager) ;
    }
    
    /**
     * 
     * @Description (按照会员分层查询)
     * @param pager
     * @return
     */
    @Override
    public Pager<BbinRecord> listRecordByUserTypeName(Pager<BbinRecord> pager){
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
      List<BbinRecord> agBrList = bbinRecordMapper.listGameRecord(pager);
      // 没有查询到则返回
      if(agBrList.size() ==0){
          return doCountSum(null, agBrList, pager);
      }
      userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
              ).parallelStream().collect(Collectors.joining("','", "('", "')"));
      pager.getParams().put("userName", userName);
    
      return handleRecordList(agBrList, pager);
    }
    
    /**
     * 
     * @Description (按照会员账号查询)
     * @return
     */
    @Override
    public Pager<BbinRecord> listRecordByAgUserName(Pager<BbinRecord> pager){
        // 查询注单结果
        List<BbinRecord> agBrList = bbinRecordMapper.listGameRecord(pager);
        if(agBrList.size() == 0){
            return doCountSum(null, agBrList, pager);
        }
        // 根据注单结果中的会员账号查询会员信息
        String userName = agBrList.parallelStream().map(agbr -> agbr.getUsername()).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("userName", userName);
        
        return handleRecordList(agBrList,pager);
    }

    /**
     * 
     * @Description (处理数据结果)
     * @return
     */
    @Override
    public Pager<BbinRecord> handleRecordList(List<BbinRecord> agBrList,Pager<BbinRecord> pager){
        
        //如果是分组查询
        String userGrouping = pager.getParams().get("userGrouping");
        if(!"0".equals(userGrouping)){
            //统计总数 总条数，总投注额，有效输赢额
            GameRecordQuery.setContitions(pager);
            List<Map<String, Object>> countResult = bbinRecordMapper.countTotal(pager);
            //开始汇总
            return doCountSum(countResult,agBrList,pager);
        }
        
        // 查询用户信息
        List<TUser> usersList = commonMapper.listTuser(pager);
        
        // 根据注单结果中的游戏类型查询ag视讯的游戏类型
        String gameTypeTmp = agBrList.parallelStream().map(agbr -> agbr.getGametype()
                ).collect(Collectors.toSet()).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("gameTypeTmp", gameTypeTmp);
        List<Map<String, String>> gameTypeList = commonMapper.listGameType(pager);
        // 根据游戏类型结果 查询数据字典表
        String dataTypeTmp = gameTypeList.parallelStream().map(gameTypeMap -> gameTypeMap.get("gameType")).collect(Collectors.toSet()
                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("dataTypeTmp", dataTypeTmp);
        String playTypeTmp = agBrList.parallelStream().map(agbr -> {
                         // 从getWagerdetail 字段中解析出下注记录
                        String s = Arrays.stream(agbr.getWagerdetail().split("\\*")).map(detail -> detail.split(",")[0]
                                ).collect(Collectors.joining(","));
                        //保存好解析出来的投注记录，拼装投注结果会使用到
                        agbr.setWagervalue(s);
                        return s;
                    }
                ).collect(Collectors.joining(","));
        playTypeTmp = Arrays.stream(playTypeTmp.split(",")).collect(Collectors.toSet()).parallelStream()
                .collect(Collectors.joining("','", "('", "')"));
        pager.getParams().put("playTypeTmp", playTypeTmp);
        List<Map<String, String>> dicDataList = commonMapper.listDicData(pager);
        
        //组装游戏结果
        agBrList = agBrList.parallelStream().flatMap(agbr -> usersList.parallelStream()
                .filter(tUser -> agbr.getUsername().equals(tUser.getAgUsername())).map(tUser -> {
                    agbr.setRealName(tUser.getRealname());
                    return agbr;
                })
            ).flatMap(agbr -> gameTypeList.parallelStream()
                    .filter(gameTypeMap -> agbr.getGametype().equals(gameTypeMap.get("gameType"))).map(gameTypeMap -> {
                        agbr.setGameTypeName(gameTypeMap.get("gameTypeName"));
                        // BBIN 特殊处理 gameType = 3017 在 platform_dic_data不存在， 3017以 3001处理
                        if("3017".equals(agbr.getGametype())){
                            agbr.setGametype("3001");
                        }
                        return agbr;
                    })
            ).flatMap(agbr -> Stream.of(Arrays.stream(agbr.getWagervalue().split(","))
                                    .map(wagerValue -> dicDataList.parallelStream()
                                        .filter(dicData -> wagerValue.equals(dicData.get("dataKey"))
                                                        && agbr.getGametype().equals(dicData.get("dataType"))
                                        ).map(dicData -> dicData.get("dataValue")).collect(Collectors.joining(","))
                                    ).collect(Collectors.joining(","))
                                ).map(dataValue -> {
                                    agbr.setDataValue(dataValue);
                                    return agbr;
                                })
            ).collect(Collectors.toList());
        //统计总数 总条数，总投注额，有效输赢额
        GameRecordQuery.setContitions(pager);
        List<Map<String, Object>> countResult = bbinRecordMapper.countTotal(pager);
        //开始汇总
        Pager<BbinRecord> resultPager = doCountSum(countResult,agBrList,pager);
        return resultPager;
    }
    
    /**
     * 
     * @Description (计算汇总)
     * @param countResult 总计
     * @param agBrList 小计
     */
    @Override
    public Pager<BbinRecord> doCountSum(List<Map<String, Object>> countResult,List<BbinRecord> agBrList,Pager<BbinRecord> pager){
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
            
            Pager<BbinRecord> resultPager = new Pager<>(0, pager.getPage(), pager.getLimit());
            resultPager.setList(agBrList);
            resultPager.setParams(map1);
            return resultPager;
        }
        
        //注单总数
        Integer totalNum = countResult.parallelStream().mapToInt(map -> Integer.parseInt(map.get("noteNum").toString())).sum();
        map1.put("totalNum", totalNum.toString());
        
        Integer validTotalNum = countResult.parallelStream().mapToInt(map -> Integer.parseInt(map.get("validNoteNum").toString())).sum();
        map1.put("validTotalNum", validTotalNum.toString());
        
        BigDecimal betAmount = new BigDecimal(countResult.parallelStream().mapToDouble(map -> Double.parseDouble(map.get("betAmount").toString())).sum());
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
        BigDecimal pageValidBetAmount = new BigDecimal(agBrList.parallelStream().mapToDouble(map -> Double.parseDouble(map.getCommissionable().toString())).sum());
        // 如果不是按照用户分组
        if("0".equals(userGrouping)){
            pageTotalNum = agBrList.size();
            pageValidTotalNum = agBrList.parallelStream().mapToInt(map -> map.getCommissionable() > 0 ? 1 : 0 ).sum();
        }else{
            pageTotalNum = agBrList.parallelStream().mapToInt(map -> map.getId()).sum();
            pageValidTotalNum = agBrList.parallelStream().mapToInt(map -> Integer.parseInt(map.getRoundno())).sum();
        }
        map1.put("pageTotalCount", pageTotalNum.toString());
        map1.put("pageValidTotalCount", pageValidTotalNum.toString());
        map1.put("pageBetAmount", pageBetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        map1.put("pageNetAmount", pageNetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        map1.put("pageValidBetAmount", pageValidBetAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString());
        
        Pager<BbinRecord> resultPager = new Pager<>(totalNum, pager.getPage(), pager.getLimit());
        resultPager.setList(agBrList);
        resultPager.setParams(map1);
        
        return resultPager;
    }
}
