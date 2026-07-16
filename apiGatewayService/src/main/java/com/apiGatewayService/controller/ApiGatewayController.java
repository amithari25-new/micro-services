package com.apiGatewayService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Logger;

@RestController
public class ApiGatewayController {
    private static final Logger LOGGER = Logger.getLogger(ApiGatewayController.class.getName());

    @Value("${server.port}")
    private String port;

    @GetMapping("/gateway-info")
    public String info() {
        LOGGER.info("Fetching gateway info: " + System.getenv("HOSTNAME"));
        return System.getenv("HOSTNAME");
    }

    @GetMapping("/test")
    public String test() throws UnknownHostException {
        LOGGER.info("Testing gateway functionality: " + InetAddress.getLocalHost().getHostName());
        return "Served by : " + InetAddress.getLocalHost().getHostName()
                + " Port : " + port;
    }
}
