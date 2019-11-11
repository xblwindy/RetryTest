package com.jcohy.scis.model;

import lombok.Data;

@Data
public class Test {

    private String url;
    private String times;
    private Object args;

    @Override
    public String toString() {
        return "Test{" +
                "uerName='" + url + '\'' +
                ", sex='" + times + '\'' +
                ", age='" + args + '\'' +
                '}';
    }

    public Test() {
        this.url = "http://localhost:8081/demo/callback";
        this.times = "3";
        this.args = new Object();
    }
}
