package com.jxzj.external.data.dto;

import java.util.List;

import com.jxzj.external.data.entity.users.Course;
import com.jxzj.external.data.entity.users.Users;

public class StudentCourse extends Users {

    public StudentCourse(String name, String addr) {
        super(name, addr);
    }

    private static final long serialVersionUID = 1L;

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}
