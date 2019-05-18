package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsType;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsTypeService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: hulk
 * @Date: 2019/5/9 16:21
 * @Description: 商品类别controller
 */
@Api(tags = "商品类别接口")
@RestController
@RequestMapping("/goodsTypeController")
public class GoodsTypeController extends BaseController {

    @Autowired
    GoodsTypeService goodsTypeService;

    //查询平台表得到所有平台信息显示到查询条件的下拉列表中
    //该功能已存在于/cagent/select
    /*@ApiOperation(value = "获取平台信息", notes = "查询平台表得到所有平台信息显示到查询条件的下拉列表中", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/platformInfo")
    public ResultResponse platformInfo() {
        List<Map<String, Object>> platformList = goodsTypeService.queryPlatformInfo();
        return ResultResponse.success("查询成功", platformList);
    }*/

    //根据平台信息查商品类别表
    @ApiOperation(value = "获取商品类别信息", notes = "根据平台信息查商品类别表", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/goodsTypeInfo")
    public ResultResponse goodsTypeInfo(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        if (!isAdmin()) {
            params.put("cagentId", getCid().toString());
        } else {
            params.put("cagentId", params.get("cagentId"));
        }
        Pager<GoodsType> pager = goodsTypeService.queryGoodsTypeInfo(params);
        return ResultResponse.success("查询成功", pager);
    }

    //新增
    @ApiOperation(value = "添加商品类别", notes = "添加商品类别信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/add")
    public ResultResponse goodsTypeAdd(@RequestBody Map<String, Object> params) {
        //从商品类别表查出最大ID
        Integer tpluUser = goodsTypeService.commodityUserId();

        if (!isAdmin()) {
            params.put("cid", getCid());
        } else {
            params.put("cid", params.get("cagentId"));
        }
        String path;
        params.put("upuid", getUserId());

        if (null == tpluUser || "".equals(tpluUser)) {
            tpluUser = 1;
            params.put("pid", 0);
            path = tpluUser + ".";
        } else {
            //判断根据参数获取的数据数量，为0代表没有符合条件的数据
            Integer cateCount = goodsTypeService.queryCateName(params);
            if (cateCount == 0) {
                if (null == params.get("pid") || "".equals(params.get("pid"))) {
                    tpluUser = tpluUser + 1;
                    params.put("pid", 0);
                    path = tpluUser + ".";
                } else {
                    //根据ID去商品类别表查上级ID
                    Integer comPid = goodsTypeService.commodityPid(params);//上级ID
                    if (comPid == 0) {
                        tpluUser = tpluUser + 1;
                        //根据参数去商品类别表查path字段
                        String tpPath = goodsTypeService.commodityPath(params);
                        path = tpPath + tpluUser + ".";
                    } else {
                        return ResultResponse.faild("添加失败,只允许存在一层子目录");
                    }
                }
            } else {
                return ResultResponse.faild("添加失败,该平台已存在该类别");
            }
        }
        params.put("tpluUser", tpluUser);
        params.put("path", path);
        //执行数据的添加
        goodsTypeService.commodityAdd(params);
        return ResultResponse.success();
    }

    //编辑
    @ApiOperation(value = "修改商品类别信息", notes = "修改商品类别信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    public ResultResponse goodsTypeUpdate(@RequestBody Map<String, Object> params) {
        params.put("cid", params.get("cid"));
        params.put("cagentId", params.get("cid"));
        params.put("upuid", getUserId());
        params.put("path", params.get("managepath"));

        //判断根据参数获取的数据数量，为0代表没有符合条件的数据
        Integer cateCount = goodsTypeService.queryCateName(params);

        if (cateCount == 0) {
            goodsTypeService.commodityUpdate(params);
            return ResultResponse.success();
        } else {
            if (params.get("newCatename").equals(params.get("catename"))) {
                goodsTypeService.commodityUpdate(params);
                return ResultResponse.success();
            } else {
                return ResultResponse.faild("添加失败,该平台已存在该类别");
            }
        }
    }

    //删除
    @ApiOperation(value = "删除商品类别信息", notes = "删除商品类别信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete")
    public ResultResponse managerdelete(@RequestParam Map<String, Object> params) throws Exception {
        //根据ID删除选中的信息
        goodsTypeService.commodityDelete(params);

        return ResultResponse.success();
    }


}
