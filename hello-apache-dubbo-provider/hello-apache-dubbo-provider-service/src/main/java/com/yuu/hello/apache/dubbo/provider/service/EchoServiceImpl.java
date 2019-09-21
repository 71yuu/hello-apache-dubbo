package com.yuu.hello.apache.dubbo.provider.service;

import com.yuu.hello.apache.dubbo.provider.EchoService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author by Yuu
 * @Classname EchoServiceImpl
 * @Date 2019/9/21 22:36
 */
@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {

    @Value("${dubbo.protocol.port}")
    private String port;

    @Override
    public String echo(String message) {
        return "Echo Hello Dubbo " + message + ",i am from " + port;
    }
}
