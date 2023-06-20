package com.example.helloworld.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

    public String getUsername(String userId) {
        //외부 서비스나 DB 호출
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Getting username from other service..");

        if (userId.equals("A")) {
            return "Adam";
        }
        if (userId.equals("B")) {
            return "Bob";
        }

        return "";
    }

    // cacheNames는 임의로 지정하면 된다. key값도 어떤것을 사용할지 파라미터에서 지정할 수 있다.
    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        //외부 서비스나 DB 호출
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Getting user age from other service..");

        if (userId.equals("A")) {
            return 28;
        }
        if (userId.equals("B")) {
            return 32;
        }

        return 0;
    }

}
