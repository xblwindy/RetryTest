package com.jcohy.scis.model;

import lombok.Data;

@Data
public class Test {
    private String id;
    private String name;
    private String vol;


    public Test(){
        this.id="1";
        this.name="test";
        this.vol="10";
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", vol='" + vol + '\'' +
                '}';
    }
}
