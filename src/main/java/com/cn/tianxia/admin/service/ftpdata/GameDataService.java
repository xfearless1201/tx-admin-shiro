package com.cn.tianxia.admin.service.ftpdata;

import java.util.List;

import com.cn.tianxia.admin.project.txdata.WinDetails;
import com.cn.tianxia.admin.vo.ftpdata.WinDetailsVO;

public interface GameDataService  {

	List<WinDetails> selectWinDetails(WinDetailsVO winDeta);

}
