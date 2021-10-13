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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addr == null) ? 0 : addr.hashCode());
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((sex == null) ? 0 : sex.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User)obj;
        if (addr == null) {
            if (other.addr != null)
                return false;
        } else if (!addr.equals(other.addr))
            return false;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (sex == null) {
            if (other.sex != null)
                return false;
        } else if (!sex.equals(other.sex))
            return false;
        return true;
    }

}
