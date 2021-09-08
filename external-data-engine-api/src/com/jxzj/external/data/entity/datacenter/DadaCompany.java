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
    private String conpanyId;

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

    public String getConpanyId() {
        return conpanyId;
    }

    public void setConpanyId(String conpanyId) {
        this.conpanyId = conpanyId;
    }

}
