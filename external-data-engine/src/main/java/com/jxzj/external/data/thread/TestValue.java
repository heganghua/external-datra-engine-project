package com.jxzj.external.data.thread;

import java.util.ArrayList;
import java.util.List;

import com.jxzj.external.data.entity.users.Course;

public class TestValue {

    public static void main(String[] args) {
        List<Course> cs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Course course = new Course();
            cs.add(course);
            tem tem = new tem(course);
            tem.setC(Long.valueOf(i));
        }
        cs.stream().forEach((item) -> System.out.println(item.toString()));
    }

    static class tem {
        private Course cs;

        public tem(Course cs) {
            this.cs = cs;
        }

        public void setC(Long arg) {
            cs.setClassId(arg);
        }

    }

}
