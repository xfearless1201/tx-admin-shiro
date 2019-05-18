package com.cn.tianxia.admin.service.txdata.impl;

import com.cn.tianxia.admin.common.Constant;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.domain.txdata.SysUserMapper;
import com.cn.tianxia.admin.project.txdata.SysUser;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.tianxia.admin.domain.txdata.VoiceMapper;
import com.cn.tianxia.admin.project.txdata.Voice;
import com.cn.tianxia.admin.service.txdata.VoiceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class VoiceServiceImpl implements VoiceService {

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(VoiceServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private VoiceMapper voiceMapper;
    
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return voiceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Voice record) {
        return voiceMapper.insertSelective(record);
    }

    @Override
    public Voice selectByPrimaryKey(Integer id) {
        return voiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Voice record) {
        return voiceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Pager<Voice> getAllVoice(Map<String, String> params) throws Exception {
        logger.info("查询声音管理参数信息：{}",params);
        Pager<Voice> pager = new Pager<>();
        if (!CollectionUtils.isEmpty(params)) {
            if (params.containsKey(Constant.PAGE_FILED)) {
                pager.setPage(Integer.parseInt(params.remove(Constant.PAGE_FILED)));
            }
            if (params.containsKey(Constant.LIMIT_FILED)) {
                pager.setLimit(Integer.parseInt(params.remove(Constant.LIMIT_FILED)));
            }
        }
        pager.setParams(params);
        List<Voice> voices = new ArrayList<>();
        List<Voice> allVoice = voiceMapper.getAllVoice(pager);
        allVoice.stream().forEach(item ->{
            if(StringUtils.isNotBlank(item.getAdduid().toString())){
                //通过添加人id查询添加人姓名
                SysUser user = sysUserMapper.selectByPrimaryKey(Long.parseLong(item.getAdduid().toString()));
                if(user != null){
                    item.setAddUserName(user.getLoginName());
                }
                voices.add(item);
            }
        });
        int totalCount = voiceMapper.getTotalCount(pager);
        Pager<Voice> result = new Pager<>(totalCount,pager.getPage(),pager.getLimit());
        result.setList(voices);
        return result;
    }
}
