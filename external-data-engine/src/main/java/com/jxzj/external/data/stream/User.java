package com.jxzj.external.data.stream;

public class User {

    private String name;

    private int age;

    private String sex;

    private String addr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", sex=" + sex + ", addr=" + addr + "]";
    }

    public User(String name, int age, String sex, String addr) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.addr = addr;
    }

}
