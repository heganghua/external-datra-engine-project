package com.jxzj.external.data.entity.datacenter;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "dada_company")
public class DadaCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司ID
     */
    private String companyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "DadaCompany [id=" + id + ", companyName=" + companyName + ", companyId=" + companyId + "]";
    }
}
