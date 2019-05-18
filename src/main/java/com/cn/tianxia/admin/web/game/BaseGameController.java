package com.cn.tianxia.admin.web.game;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.base.annotation.DataSource;
import com.cn.tianxia.admin.base.datasource.Database;
import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.enums.GameServiceEnum;
import com.cn.tianxia.admin.project.ftpdata.FormData;
import com.cn.tianxia.admin.service.ftpdata.BaseQueryService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName BaseGameController
 * @Description TODO(查询游戏注单入口类)
 * @author Hardy
 * @Date 2019年4月27日 下午10:08:14
 * @version 1.0.0
 */
@Api(tags="游戏注单查询接口")
@RestController
@RequestMapping("/game")
public class BaseGameController extends BaseController{

    /**
     * 表单查询入口
     * @param contiton
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked" })
    @ApiOperation(value = "游戏注单查询接口", notes = "通用接口接口",httpMethod = "POST"
            ,produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/list")
    @DataSource(Database.FTPDATA_XMLDB_MASTER)
    public ResultResponse queryGameRecord(@RequestBody FormData data){
        try {
            String gameType = data.getGameType();
            //判断是否是管理员,不是则查询自己的代理平台信息
            boolean isAdmin = false; 
//          if(!isAdmin()){
            if(isAdmin){
                data.setCagentName(getUser().getCagent());
            }
            //通过游戏类型获取对应的服务
            BaseQueryService queryService = GameServiceEnum.valueOf(gameType).getQueryService();
            //将查询参数FormData统一转换成Pager
            Pager pager = queryService.transFormDataToPager(data);
            Pager<?> resultPager = queryService.list(pager);
            return ResultResponse.success("successed", resultPager);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            return ResultResponse.error(e.getMessage());
        }
    }
    
//  public static void main(String[] args) {
//      List<TUser> usersList = new ArrayList<>();
//      String userNameTmp =  usersList.parallelStream().map(tUser -> tUser.getAgUsername()).collect(Collectors.toSet()
//                ).parallelStream().collect(Collectors.joining("','", "('", "')"));
//      System.err.println(String.format("找不到代理商信息，请确认代理商%s是否正确", "dfg"));
//    }
}
