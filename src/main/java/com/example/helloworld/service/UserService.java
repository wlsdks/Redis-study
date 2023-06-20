package com.example.helloworld.service;

import com.example.helloworld.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ExternalApiService externalApiService;
    private final StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {

        String username = null;

        // 캐시데이터를 확인하는 과정이다.
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);
        if (cachedName != null) { // 데이터가 있으면 바로 가져다 쓰고
            username = cachedName;
        } else { // 데이터가 없으면 DB에 접근해서 가지고오는 과정이다.
            username = externalApiService.getUsername(userId);
            // 5초의 시간을 준다.
            ops.set("nameKey:" + userId, username, 5, TimeUnit.SECONDS);
        }

        int userAge = externalApiService.getUserAge(userId);

        return new UserProfile(username, userAge);
    }

}
