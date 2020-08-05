package com.itheima.service.impl;


import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZhangHao
 * @Title: UserServiceImpl
 * @Package com.itheima.service.impl
 * @Description:
 * @date 2020/7/111:05
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public Order createOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }
}