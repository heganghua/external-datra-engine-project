package com.jxzj.external.data.dto;

import java.io.Serializable;

public class SecKillInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    public String prodid;

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

}
