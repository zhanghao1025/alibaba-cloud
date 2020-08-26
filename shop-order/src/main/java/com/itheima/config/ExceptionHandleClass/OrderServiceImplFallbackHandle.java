package com.itheima.config.ExceptionHandleClass;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ZhangHao
 * @Title: OrderServiceImplFallbackHandle
 * @Package com.itheima.config.ExceptionHandleClass
 * @Description: 处理Blocked以外的异常
 * @date 2020/8/2114:09
 */
@Slf4j
public class OrderServiceImplFallbackHandle {
    public static String fallbackHandle(String name,Throwable cause) {
        log.info("Throwable");
        return "Throwable";
    }
}