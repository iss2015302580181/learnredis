package com.h3c.learnredis;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    RedisUtils redisUtils;

    @RequestMapping("/method")
    public void test(){
        redisUtils.set("key1",123);
        System.out.println("success");
    }
}
