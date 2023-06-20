package com.example.helloworld.controller;

//Hello => "hello world!"

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

    // setFruit?name=banana

    // getFruit

    public String setFruit(@RequestParam String name) {

    }





}
