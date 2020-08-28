package com.itheima.filters;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhangHao
 * @Title: LogGatewayFilterFactory
 * @Package com.itheima.filters
 * @Description: 自定义过滤器
 * @date 2020/8/2810:32
 */
@Component
public class LogGatewayFilterFactory extends AbstractGatewayFilterFactory<LogGatewayFilterFactory.Config> {

    public LogGatewayFilterFactory() {
        super(LogGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("consoleLog","dubugLog");
    }

    @Override
    public GatewayFilter apply(LogGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            if (config.getConsoleLog()){
                System.out.println("控制台日志开启");
            }else if (config.getDubugLog()){
                System.out.println("debug日志开启");
            }
            return chain.filter(exchange);
        };
    }

    @Data
    @NoArgsConstructor
    public static class Config {
        private Boolean consoleLog;
        private Boolean dubugLog;
    }
}