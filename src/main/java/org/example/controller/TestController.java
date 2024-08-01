package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //加了这个注解之后，@value注解才可以实时的获取配置中心的数据
@RequestMapping("/aaa")
public class TestController {
    @Value("${key:dd}")
    private String config;

    @RequestMapping("/getconfig")
    public String getMyconfig() {
        return config;
    }

    @GetMapping("/name")
    public String cs() {
        System.out.println("被路由的 : 1");
        return "client01";
    }
}

