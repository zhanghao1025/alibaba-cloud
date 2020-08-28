package com.itheima.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhangHao
 * @Title: UserController
 * @Package com.itheima.controller
 * @Description:
 * @date 2020/7/111:07
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/api1/demo1")
    public String demo1(){
        return "message";
    }
    @RequestMapping("/api1/demo2")
    public String demo2(){
        return "message";
    }
    @RequestMapping("/api2/demo1")
    public String demo3(){
        return "message";
    }
    @RequestMapping("/api2/demo2")
    public String demo4(){
        return "message";
    }


    @RequestMapping("/{pid}")
    public Product queryProductById(@PathVariable Integer pid, HttpServletRequest request){
        String zhanghao = request.getHeader("zhanghao");
        log.info("查询{}商品",pid);
        log.info("header值{}",zhanghao);
        Product product=productService.findProductByPid(pid);
        return product;
    }
    @RequestMapping("/message")
    public String message(){
        return "message";
    }
}