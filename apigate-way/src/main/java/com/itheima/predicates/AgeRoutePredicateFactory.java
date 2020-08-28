package com.itheima;

import com.alibaba.nacos.client.utils.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author ZhangHao
 * @Title: AgeRoutePredicateFactory
 * @Package com.itheima
 * @Description: gateway自定义断言工厂
 * 注意 1.类名 必须是配置文件中的关键字+RoutePredicateFactory
 * @date 2020/8/2615:30
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    //默认值
    public static final int DEFAULT_AGE = 18;

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }
//    给Config中的属性赋值
//    注意：Arrays.asList("minAge","maxAge")参数位置要和 Age: 0,20 中的顺序相同
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("minAge","maxAge");
    }
    //处理逻辑
    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {

        return (exchange) -> {
            String ageStr = exchange.getRequest().getQueryParams().getFirst("age");
            int age=DEFAULT_AGE;
            if (StringUtils.isNotEmpty(ageStr)){
                age = Integer.parseInt(ageStr);
                if (age<config.getMaxAge()&&age>config.getMinAge()){
                    return true;
                }else {
                    return false;
                }
            }
            return true;
        };
    }

    @NoArgsConstructor
    @Data
    public static class Config {
       private int minAge;
       private int maxAge;
    }
}