package com.itheima.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ZhangHao
 * @Title: AuthGlobalFilter
 * @Package com.itheima.filters
 * @Description: 全局认证gateway过滤器
 * @date 2020/8/2811:13
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (!"admin".equals(token)){
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            log.info("认证失败");
            return exchange.getResponse().setComplete();
        }
        //加入到过滤器链中
        return chain.filter(exchange);
    }
    //优先级：数值越小 ，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}