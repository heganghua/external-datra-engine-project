package com.jxzj.external.data.entity.users;

import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String addr;

    private String sex;

    private Date updateTime;

    public Users(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", addr=" + addr + ", sex=" + sex + ", updateTime=" + updateTime
            + "]";
    }

}
