package com.itheima.config.ExceptionHandleClass;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZhangHao
 * @Title: OrderServiceImplBlockedHandle
 * @Package com.itheima.config.ExceptionHandleClass
 * @Description: 处理BlockedException
 * @date 2020/8/2114:11
 */
@Slf4j
public class OrderServiceImplBlockedHandle {

    public static String blockHandler(String name, BlockException exception) {

        log.info("BlockExcetion");
        return "BlockExcetion";

    }
}