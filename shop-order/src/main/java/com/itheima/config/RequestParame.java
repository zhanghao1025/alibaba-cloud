package com.itheima.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhangHao
 * @Title: RequestParame
 * @Package com.itheima.config
 * @Description: 获取服务名 测试授权策略
 * @date 2020/8/2013:42
 */
@Component
public class RequestParame implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
//        String serviceName = httpServletRequest.getParameter("serviceName");
//        if (StringUtils.isEmpty(serviceName)){
//            throw new RuntimeException("来源名为空");
//        }
        String serviceName="pc";
        return serviceName;
    }
}