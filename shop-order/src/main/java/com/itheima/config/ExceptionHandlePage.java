package com.itheima.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhangHao
 * @Title: ExceptionHandlePage
 * @Package com.itheima.config
 * @Description: 异常返回页面
 * @date 2020/8/2014:00
 */
@Component
public class ExceptionHandlePage implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        ResponsData responsData=null;
        if (e instanceof FlowException){
            responsData= new ResponsData(1,"流控-限流");
        }else if(e instanceof AuthorityException){
            responsData= new ResponsData(1,"授权");

        }else if (e instanceof DegradeException){
            responsData= new ResponsData(1,"降级");

        }else  if (e instanceof ParamFlowException){
            responsData=new ResponsData(1,"参数限流");

        }else if (e instanceof SystemBlockException){
            responsData=new ResponsData(1,"系统限流");

        }
        response.getWriter().write(JSON.toJSONString(responsData));
    }
}
@Data
@AllArgsConstructor
@NoArgsConstructor
class ResponsData{
    private Integer Code;
    private String msg;
}