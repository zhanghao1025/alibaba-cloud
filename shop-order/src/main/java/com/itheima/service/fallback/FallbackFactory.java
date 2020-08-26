package com.itheima.service.fallback;

import com.itheima.domain.Product;
import com.itheima.service.ProductFeignService;
import org.springframework.stereotype.Component;

/**
 * @author ZhangHao
 * @Title: OrderServiceFallback
 * @Package com.itheima.service.fallback
 * @Description: feign整合sentinel，处理容错类
 * @date 2020/8/2115:20
 */
@Component
public class FallbackFactory implements feign.hystrix.FallbackFactory<ProductFeignService> {


    @Override
    public ProductFeignService create(Throwable throwable) {
        return new ProductFeignService() {
            @Override
            public Product findProductById(Integer pid) {
                //容错逻辑
                Product product = new Product();
                product.setPid(404);
                return product;
            }
        };
    }
}