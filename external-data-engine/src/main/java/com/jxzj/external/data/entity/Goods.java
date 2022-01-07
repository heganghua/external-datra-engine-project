package com.jxzj.external.data.entity;

public class Goods {

    private Long id;
    private String name;

    public Goods(Long id, String name) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
