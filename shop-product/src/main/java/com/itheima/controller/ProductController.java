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