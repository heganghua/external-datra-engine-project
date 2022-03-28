package com.jxzj.external.data.designmode.buildmode;

public class User implements Cloneable {

    private String name;

    private String sex;

    private Home home;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Home getHome() {
        return home;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", sex=" + sex + ", home=" + home + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }
}
