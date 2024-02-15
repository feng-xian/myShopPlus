package com.fx.shop.business.com.fx.shop.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public String welcome() {
        return "<h1>index!</h1>";
    }


}
