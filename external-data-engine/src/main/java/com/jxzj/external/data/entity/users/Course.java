package com.jxzj.external.data.entity.users;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long classId;

    private Long userId;

    private String className;

    private Date time;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
