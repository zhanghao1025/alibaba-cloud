package com.itheima.service;

import com.itheima.domain.Product;
import com.itheima.service.fallback.FallbackFactory;
import com.itheima.service.fallback.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/*
@FeignClient(value = "service-product",
            fallback = OrderServiceFallback.class,//指定远程调用失败后处理容错逻辑的类
            fallbackFactory = FallbackFactory.class)//指定远程调用失败后处理容错工厂类处理异常后的逻辑
   fallback/fallbackFactory       二选一 不要重复使用

 */
@FeignClient(value = "service-product",
            //fallback = OrderServiceFallback.class,//指定远程调用失败后处理容错逻辑的类
            fallbackFactory = FallbackFactory.class)//指定远程调用失败后处理容错工厂类处理异常后的逻辑
public interface ProductFeignService {

    @RequestMapping("/product/{pid}")
    Product findProductById(@PathVariable(value = "pid")Integer pid);
}
