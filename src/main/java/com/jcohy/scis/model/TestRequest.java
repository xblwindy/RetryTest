package com.jcohy.scis.model;

import lombok.Data;

@Data
public class TestRequest {

    private String sex;
    private String  name;
    private String age;

    public TestRequest() {
        this.sex = "nan";
        this.name = "test";
        this.age="20";
    }
}
