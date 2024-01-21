package com.fx.shop.provider.controller;

import com.fx.shop.provider.api.EchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @DubboReference(version = "1.0.0")
    public EchoService echoService;

    @GetMapping(value = "{string}")
    public Object echo(@PathVariable String string){
        return echoService.echo(string);
    }

}
