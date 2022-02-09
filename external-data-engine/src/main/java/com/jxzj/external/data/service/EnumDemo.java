package com.jxzj.external.data.service;

public enum EnumDemo {
    SPRING(1, "spring"), SUMMER(2, "summer"), AUTUMN(3, "autumn"), WINTER(4, "WINTER");

    final int value;
    final String desc;

    private EnumDemo(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
