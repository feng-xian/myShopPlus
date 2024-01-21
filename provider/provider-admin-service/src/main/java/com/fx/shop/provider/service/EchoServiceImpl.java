package com.fx.shop.provider.service;

import com.fx.shop.provider.api.EchoService;
import org.slf4j.LoggerFactory;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;

@DubboService(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    private static final Logger logger = LoggerFactory.getLogger(EchoServiceImpl.class);

    @Override
    public String echo(String str) {
        logger.info("hello echo");
        return "hello " + str;
    }

}
