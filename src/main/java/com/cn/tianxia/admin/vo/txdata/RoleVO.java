package com.cn.tianxia.admin.vo.txdata;

import java.io.Serializable;
import java.util.List;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.Size;

/**
 * @ClassName RoleVO
 * @Description 角色VO类
 * @author Hardy
 * @Date 2019年4月27日 下午3:11:33
 * @version 1.0.0
 */
public class RoleVO implements Serializable {

    private static final long serialVersionUID = 7387600998544557617L;

    private Long id;// 角色ID

    @NotEmpty(message="角色名称不能为空")
    private String name;// 角色名称

    @NotEmpty(message="平台ID不能为空")
    private String cid;// 平台ID

    @Size(min=1,message="资源集合ID不能为空")
    private List<Long> resouseIds;// 资源ID集合

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public List<Long> getResouseIds() {
        return resouseIds;
    }

    public void setResouseIds(List<Long> resouseIds) {
        this.resouseIds = resouseIds;
    }

}
