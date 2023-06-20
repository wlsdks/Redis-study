package com.example.helloworld.service;

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
