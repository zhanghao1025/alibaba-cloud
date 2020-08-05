package com.itheima.service;

import com.itheima.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-product")
public interface ProductFeignService {

    @RequestMapping("/product/{pid}")
    Product findProductById(@PathVariable(value = "pid")Integer pid);
}
