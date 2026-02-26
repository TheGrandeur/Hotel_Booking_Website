package com.example.hcldemo.cnt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testing")
public class testcnt {
    @GetMapping("/hy")
    public String sayHello(){
        return "Hello";
    }
}
