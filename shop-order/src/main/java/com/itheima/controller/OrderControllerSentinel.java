package com.itheima.controller;

import com.itheima.domain.Order;
import com.itheima.domain.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangHao
 * @Title: UserController
 * @Package com.itheima.controller
 * @Description:
 * @date 2020/7/111:07
 */
@RestController
@Slf4j
public class OrderControllerSentinel {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductFeignService productFeignService;

    @RequestMapping("order/prod/{pid}")
    public Order getOrder(@PathVariable("pid") Integer pid){
        log.info("查询商品id{}",pid);

        Product product = productFeignService.findProductById(pid);
        log.info("商品:{}",product.toString());
        Order order = new Order();
        order.setUid(1);
        order.setUname("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Order result = orderService.createOrder(order);
//        log.info("订单:{}",result.toString());
        return order;
    }

    @RequestMapping("order/message")
    public String getMessage(){
       return "测试熔断";
    }
}