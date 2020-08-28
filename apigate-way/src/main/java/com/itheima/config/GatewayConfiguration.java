//package com.itheima.config;
//
//import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
//import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
//import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
//import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
//import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
//import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
//import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
//import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.reactive.result.view.ViewResolver;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import javax.annotation.PostConstruct;
//import java.util.*;
//
///**
// * @author ZhangHao
// * @Title: GatewayConfiguration
// * @Package com.itheima.config
// * @Description: gateway和sentinel结合进行网关限流
// * @date 2020/8/2814:07
// */
////@Configuration
//public class GatewayConfiguration {
//
//    private final List<ViewResolver> viewResolvers;
//    private final ServerCodecConfigurer serverCodecConfigurer;
//
//    public GatewayConfiguration(ObjectProvider<List<ViewResolver>> viewResolvers,
//                                ServerCodecConfigurer serverCodecConfigurer) {
//        this.viewResolvers = viewResolvers.getIfAvailable(Collections::emptyList);
//        this.serverCodecConfigurer = serverCodecConfigurer;
//    }
//
//    //初始化一个限流过滤器
//    @Bean
//    @Order
//    public GlobalFilter sentinelGlobalFilter() {
//        return new SentinelGatewayFilter();
//    }
//
//    //初始化限流参数
//    @PostConstruct
//    public void initGatewayRules() {
//        HashSet<GatewayFlowRule> rules = new HashSet<>();
//        rules.add(new GatewayFlowRule("product_route")//资源名称，对应路由配置的名称
//                .setCount(1)//限流阀值
//                .setIntervalSec(1L));//统计时间窗口，单位秒
//        GatewayRuleManager.loadRules(rules);
//    }
//
//    //捕获异常页面
//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SentinelGatewayBlockExceptionHandler initeExceptionHandle() {
//        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
//    }
//
//    //定义限流异常页面
//    @PostConstruct
//    public void initBlockHandlers() {
//        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
//            @Override
//            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
//                Map map = new HashMap<>();
//                map.put("code", 0);
//                map.put("message", "接口限流。。");
//                return ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON_UTF8).body(BodyInserters.fromObject(map));
//            }
//        };
//        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
//    }
//    //自定义api限流
//    private void initCustomizedApis(){
//        Set<ApiDefinition> map = new HashSet<>();
//        ApiDefinition api1 = new ApiDefinition("product-api1").setPredicateItems(
//                new HashSet<ApiPredicateItem>() {{
//                    add(new ApiPathPredicateItem().setPattern("product-serv/product/api1/**")//匹配的路径
//                    .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_PREFIX));//开头匹配
//                }}
//        );
//        ApiDefinition api2 = new ApiDefinition("product-api1").setPredicateItems(
//                new HashSet<ApiPredicateItem>() {{
//                    add(new ApiPathPredicateItem().setPattern("product-serv/product/api/demo"));//全匹配
//                }}
//        );
//        map.add(api1);
//        map.add(api2);
//        GatewayApiDefinitionManager.loadApiDefinitions(map);
//    }
//}