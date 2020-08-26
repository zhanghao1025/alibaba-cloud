package com.itheima.service.impl;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.itheima.config.ExceptionHandleClass.OrderServiceImplBlockedHandle;
import com.itheima.config.ExceptionHandleClass.OrderServiceImplFallbackHandle;
import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    int i = 0;

    @Override
    public Order createOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }

    @Override
    public String getMessage() {
        return "message";
    }

    @Override
    @SentinelResource(value = "getMessage4"
            , blockHandlerClass = {OrderServiceImplBlockedHandle.class}//类名
            , blockHandler = "blockHandler"
            , fallbackClass = {OrderServiceImplFallbackHandle.class}
            , fallback = "fallbackHandle")
    public String getMessage4(String name) {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message4";
    }


}