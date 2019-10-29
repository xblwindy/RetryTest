package com.jcohy.scis.controller;

import com.jcohy.scis.http.HttpClientUtil;
import com.jcohy.scis.model.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    HttpClientUtil httpClientUtil;

    @PostMapping("/doSomething")
    @ResponseBody
    public String doSomething(HttpServletRequest request) throws Exception {
        try {
            doThings();
        } catch (Exception e) {
            addRetryTask();
        }
        return "ok";
    }

    private void addRetryTask() throws Exception {
        String url = "http://localhost:8082/admin/retry/callback";
        HttpResult httpResult =  httpClientUtil.doPost(url,new HashMap<>());
        System.out.println(httpResult.getBody());
    }

    private void doThings() throws Exception {
        throw new Exception("error");
    }


}
