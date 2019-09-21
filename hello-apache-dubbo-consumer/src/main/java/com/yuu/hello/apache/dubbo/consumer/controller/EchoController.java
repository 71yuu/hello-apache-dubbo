package com.yuu.hello.apache.dubbo.consumer.controller;

import com.yuu.hello.apache.dubbo.provider.EchoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author by Yuu
 * @Classname EchoController
 * @Date 2019/9/22 1:07
 */
@RefreshScope
@RestController
public class EchoController {

    @Reference(version = "1.0.0")
    private EchoService echoService;

    @Value("${user.name}")
    private String username;

    @GetMapping(value = "/echo/{message}")
    public String echo(@PathVariable String message) {
        return echoService.echo(message) + " " + username;
    }
}
