package com.cn.tianxia.admin.common;

import com.cn.tianxia.admin.project.txdata.IntegralMall.GoodsManagement;
import org.springframework.util.CollectionUtils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ApiModel
public class Pager<T> implements Serializable {

    private static final long serialVersionUID = 2997259129193989856L;
    
    @ApiModelProperty(name="list",notes="list",value="对象记录列表")
    private List<T> list; // 对象记录结果集
    @ApiModelProperty(name="totalCount",notes="totalCount",value="总条数")
    private Integer totalCount = 0; // 总条数数
    @ApiModelProperty(name="limit",notes="limit",value="每页显示条数")
    private Integer limit = 20; // 每页显示条数
    @ApiModelProperty(name="totalPage",notes="totalPage",value="总页数")
    private Integer totalPage = 1; // 总页数
    @ApiModelProperty(name="page",notes="page",value="当前页码")
    private Integer page = 1; // 当前页
    @ApiModelProperty(name="params",notes="params",value="查询条件")
    private Map<String, String> params;
    @ApiModelProperty(name="list",notes="list",value="查询商品管理条件")
    private List<GoodsManagement>  goodsManagement;


    public Pager() {

    }

    public Pager(Map<String,String> params) {
        if(!CollectionUtils.isEmpty(params)){
            if(params.containsKey("page")){
                this.setPage(Integer.parseInt(params.remove("page")));
            }
            if(params.containsKey("limit")){
                this.setLimit(Integer.parseInt(params.remove("limit")));
            }
        }
        this.setParams(params);
    }

    public Pager(int totalCount, int currPage) {
        init(totalCount, currPage, limit);
    }

    public Pager(int totalCount, int currPage, int pageSize) {
        init(totalCount, currPage, pageSize);
    }

    private void init(int totalCount, int currPage, int pageSize) {
        // 设置基本参数
        this.totalCount = totalCount;
        this.limit = pageSize;
        this.totalPage = (this.totalCount - 1) / this.limit + 1; // 总页数
        // 根据输入可能错误的当前号码进行自动纠正
        if (currPage < 1) {
            this.page = 1;
        } else if (currPage > this.totalPage) {
            this.page = this.totalPage;
        } else {
            this.page = currPage;
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Pager [list=" + list + ", totalCount=" + totalCount + ", limit=" + limit + ", totalPage=" + totalPage
                + ", page=" + page + ", params=" + params + "]";
    }

}
