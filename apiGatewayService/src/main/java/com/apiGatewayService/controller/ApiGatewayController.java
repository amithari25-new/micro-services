package com.apiGatewayService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class ApiGatewayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/gateway-info")
    public String info() {
        return System.getenv("HOSTNAME");
    }

    @GetMapping("/test")
    public String test() throws Exception {
        return "Served by : " + InetAddress.getLocalHost().getHostName()
                + " Port : " + port;
    }
}
