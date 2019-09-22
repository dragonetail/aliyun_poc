package com.example.demo;

import com.alibaba.csp.sentinel.slots.block.SentinelRpcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Zhao
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String apiSayHello(@RequestParam String name) {
        try {
            return demoService.sayHello(name);
        } catch (SentinelRpcException e) {
            e.getCause().printStackTrace();
            return "oops, blocked by Sentinel...";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "oops...";
        }
    }

    @GetMapping("/time")
    public long apiCurrentTime() {
        try {
            return demoService.getCurrentTime();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}