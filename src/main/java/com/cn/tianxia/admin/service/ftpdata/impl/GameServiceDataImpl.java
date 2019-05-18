package com.cn.tianxia.admin.service.ftpdata.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.domain.ftpdata.GameDataMapper;
import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.service.ftpdata.GameDataService;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;

@Service
public class GameServiceDataImpl implements GameDataService {

    @Autowired
    private GameDataMapper gameDataMapper;
    
    Logger logger = LoggerFactory.getLogger(GameServiceDataImpl.class);

   
    @DataSource(value=Database.FTPDATA_XMLDB_MASTER)
	@Override
	public List<WinDetails> selectWinDetails(WinDetailsVO winDeta) {
		return gameDataMapper.selectWinDetails(winDeta);
	}
}
