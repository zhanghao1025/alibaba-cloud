package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author ZhangHao
 * @Title: UserServiceImpl
 * @Package com.itheima.service.impl
 * @Description:
 * @date 2020/7/111:05
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product findProductByPid(Integer pid) {
        Optional<Product> byId = productDao.findById(pid);
        Product product = byId.get();
        return product;
    }
}