package com.jcohy.scis.http;

import com.jcohy.scis.model.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HttpClientUtil {
    @Autowired
    private HttpClient httpClient;


    public HttpResult doGet(String url) throws Exception {
        HttpResult httpResult = this.httpClient.doGet(url);

        System.out.println(httpResult.getCode());
        System.out.println(httpResult.getBody());
        return httpResult;
    }

    // 新增
    public HttpResult doPost(String url, String json) throws Exception {
        HttpResult httpResult = this.httpClient.doPost(url, json);
        return httpResult;
    }



}

