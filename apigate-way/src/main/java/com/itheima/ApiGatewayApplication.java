package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZhangHao
 * @Title: ApiGatewayApplication
 * @Package com.itheima
 * @Description:
 * @date 2020/8/2610:26
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {
        public static void main(String[] args) {
            SpringApplication.run(ApiGatewayApplication.class, args);

        }
}