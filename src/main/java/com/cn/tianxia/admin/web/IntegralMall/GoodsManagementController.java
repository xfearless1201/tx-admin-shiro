package com.cn.tianxia.admin.web.IntegralMall;

import com.cn.tianxia.admin.common.Pager;
import com.cn.tianxia.admin.common.ResultResponse;
import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsManagement;
import com.cn.tianxia.admin.service.txdata.IntegralMallService.GoodsManagementService;
import com.cn.tianxia.admin.web.sys.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * * @Author: hulk
 *
 * @Date: 2019/5/7 14:35
 * @Description: 商品管理controller
 */
@Api(tags = "商品管理接口")
@Controller
@RequestMapping("/GoodsManagementController")
public class GoodsManagementController extends BaseController {

    @Autowired
    GoodsManagementService goodsManagementService;

    //商品管理查询
    @ApiOperation(value = "商品管理", notes = "商品管理查询", httpMethod = "POST")
    @PostMapping("/goodsManagementQuery")
    public ResultResponse goodsManagementQuery(@ApiParam(name = "params", value = "查询条件") @RequestBody Map<String, String> params) {
        GoodsManagement goodsManagement = goodsManagementService.goodsManaQueryById(params);//获取path
        if (!isAdmin()) {
            params.put("cagentId", getCid().toString());//查询当前平台
        }
        List<GoodsManagement> updateManage = new ArrayList();
        if (null != goodsManagement && !"".equals(goodsManagement)) {
            String path = goodsManagement.getPath();//获取自己的path 根据path 找到他下面所以层级
            Integer pathLeng = path.length();
            List<GoodsManagement> goodsManagementList = goodsManagementService.goodsManaQueryAll();//查询所以数据进行比对
            for (GoodsManagement goods : goodsManagementList) {
                String goodsPath = goods.getPath();//获取当前map的path
                if (goodsPath.length() >= pathLeng) {//筛选path长度大于获取等于你所选中的path长度
                    String pathBefer = goodsPath.substring(0, pathLeng);//截取长度到你选中的层级长度
                    if (pathBefer.equals(path)) {//判断选中的长度等于当前map长度
                        updateManage.add(goods);//list保存
                    }
                }
            }
        }
        params.put("updateManage", updateManage.toString());
        Pager<GoodsManagement> pager = goodsManagementService.goodsManaShow(params, updateManage);
        return ResultResponse.success("查询成功", pager);
    }

    //商品管理新增
    @ApiOperation(value = "商品管理", notes = "商品管理添加", httpMethod = "POST")
    @PostMapping("/goodsManagementAdd")
    public ResultResponse goodsManagementAdd(@RequestBody Map<String, Object> params) throws Exception {

        if (!"".equals(params.get("pid")) && null != params.get("pid")) {

            Integer descCont = goodsManagementService.decriptCont(params);
            if (descCont == 0) {
                params.put("upuid", getUserId());

                params.put("id", "0");
                goodsManagementService.DescriptAdd(params);

                goodsManagementService.descriptName(params);

                return ResultResponse.success();
            } else {

                return ResultResponse.faild("添加失败！ 该平台已存在该商品");
            }
        } else {
            return ResultResponse.faild("添加失败请选择类别名称！若该平台没有类别名称,请前往商品类别添加该平台类别");
        }
    }

    //编辑
    @ApiOperation(value = "修改商品管理信息", notes = "修改商品管理信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/update")
    public ResultResponse goodsManagementUpdate(@RequestBody Map<String, Object> params) {
        Integer descCont = goodsManagementService.decriptCont(params);
        if (descCont == 0) {
            params.put("upuid", getUserId());
            Map<String, Object> pidMap = goodsManagementService.getpidName(params);
            if (null != pidMap && !"".equals(pidMap)) {
                params.put("pid", pidMap.get("pid"));
            }
            goodsManagementService.DescriptUpdate(params);
            return ResultResponse.success();
        } else {
            if (params.get("newPluname").equals(params.get("pluname"))) {
                params.put("upuid", getUserId());
                Map<String, Object> pidMap = goodsManagementService.getpidName(params);
                if (null != pidMap && !"".equals(pidMap)) {
                    params.put("pid", pidMap.get("pid"));
                }
                goodsManagementService.DescriptUpdate(params);
                return ResultResponse.success();
            }
            return ResultResponse.faild("编辑失败！ 该平台已存在该商品");
        }
    }

    //删除
    @ApiOperation(value = "删除商品管理信息", notes = "删除商品管理信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/delete")
    public ResultResponse goodsManagementDelete(@RequestParam Map<String, Object> params) {
        List<Map<String, Object>> pluMap = goodsManagementService.selectPluInventory(params);
        if (pluMap != null && pluMap.size() > 0) {
            return ResultResponse.faild("该商品正在销售中无法进行删除！");
        }
        goodsManagementService.DescriptDelete(params);
        return ResultResponse.success();
    }

    //图片预览


    //启用
    @ApiOperation(value = "商品管理停用启用", notes = "商品管理停用启用", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/goodsManagementOpen")
    public ResultResponse goodsManagementOpen(@RequestParam Map<String, Object> params) {
        goodsManagementService.openproxy(params);
        return ResultResponse.success();
    }

    //停用
    @ApiOperation(value = "商品管理停用启用", notes = "商品管理停用启用", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/goodsManagementClose")
    public ResultResponse goodsManagementClose(@RequestParam Map<String, Object> params) {
        goodsManagementService.closeproxy(params);
        return ResultResponse.success();
    }
}
