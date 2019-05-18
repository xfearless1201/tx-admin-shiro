package com.cn.tianxia.admin.web.plat;

import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.CagentBankCard;
import com.cn.tianxia.admin.service.txdata.CagentBankCardService;
import com.cn.tianxia.admin.web.sys.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * 
 * @ClassName CagentBankCardController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Bing
 * @Date 2019年5月7日 下午12:08:07
 * @version 1.0.0
 */
@Api(tags="银行账户列表接口")
@RestController
@RequestMapping("/plat/bank")
public class CagentBankCardController extends BaseController{

    @Autowired
    private CagentBankCardService cagentBankCardService;
    
    /**
     * 
     * @Description 查看银行账户列表信息
     * @return
     */
    @ApiOperation(value = "查看银行账户列表信息", notes = "查看银行账户列表信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/list")
    @RequiresPermissions("plat:bank:list")
    public ResultResponse list(@ApiParam(name="params",value="查询条件") @RequestParam Map<String,String> params) {
        if(!isAdmin()) {
            params.put("cid", getCid().toString());
        }
        Pager<CagentBankCard> pager = cagentBankCardService.list(params);
        return ResultResponse.success("查询成功", pager);
    }
    /**
     * 
     * @Description 查看单条银行账户信息
     * @return
     */
    @ApiOperation(value = "查看单条银行账户信息", notes = "查看单条银行账户信息",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/info/{id}")
    @RequiresPermissions("plat:bank:info")
    public ResultResponse info(@PathVariable("id") Integer id) {
        CagentBankCard cagentBankCard = cagentBankCardService.info(id);
        return ResultResponse.success("查询成功", cagentBankCard);
    }
    /**
     * 
     * @Description 修改单条银行账户信息
     * @return
     */
    @ApiOperation(value = "修改单条银行账户信息", notes = "修改单条银行账户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    @RequiresPermissions("plat:bank:update")
    public ResultResponse update(@RequestBody CagentBankCard cagentBankCard) {
        cagentBankCard.setUpdatetime(new Date());
        cagentBankCard.setUid(getUserId());
        int result = cagentBankCardService.update(cagentBankCard);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
    /**
     * 
     * @Description 添加单条银行账户信息
     * @return
     */
    @ApiOperation(value = "添加单条银行账户信息", notes = "添加单条银行账户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    @RequiresPermissions("plat:bank:add")
    public ResultResponse add(@RequestBody CagentBankCard cagentBankCard) {
        cagentBankCard.setUpdatetime(new Date());
        cagentBankCard.setUid(getUserId());
        int result = cagentBankCardService.add(cagentBankCard);
        if(result>0) {
            return ResultResponse.success("修改成功", result);
        }
        return ResultResponse.faild("修改失败");
    }
}
