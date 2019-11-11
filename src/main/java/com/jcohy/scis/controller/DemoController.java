package com.jcohy.scis.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcohy.scis.http.HttpClientUtil;
import com.jcohy.scis.model.HttpResult;

import com.jcohy.scis.model.Test;
import com.jcohy.scis.model.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {

    @Autowired
    HttpClientUtil httpClientUtil;

    @PostMapping("/doSomething")
    @ResponseBody
    public String doSomething(HttpServletRequest request) throws Exception {
        Test test = new Test();
        TestRequest testRequest = new TestRequest();
        test.setArgs(testRequest);
        try {
            doThings(test);
        } catch (Exception e) {
            addRetryTask(test);
        }
        return "ok";
    }

    private void addRetryTask(Test test) throws Exception {
        String url = "http://localhost:8082/admin/retry/add";
        Map<String, Object> task = new HashMap<>();
        String args = JSON.toJSONString(test);
        task.put("args", args);
        String putJson = new JSONObject(task).toString();
        HttpResult httpResult = httpClientUtil.doPost(url, putJson);
        System.out.println(httpResult.getBody());
    }

    private void doThings(Test test) throws Exception {
        System.out.println(test);
        throw new Exception("error");
    }


    @PostMapping("/callback")
    @ResponseBody
    public void callback(HttpServletRequest request) throws Exception {
        System.out.println("callback ok ++++++++++++++++++");
    }
}
