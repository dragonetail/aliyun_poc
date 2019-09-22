package com.example.demo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @SentinelResource(value = "getCurrentTime")
    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}