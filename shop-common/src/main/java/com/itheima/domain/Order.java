package com.itheima.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ZhangHao
 * @Title: Order
 * @Package com.itheima.domain
 * @Description: 订单
 * @date 2020/7/110:21
 */
@Entity(name = "shop_order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private Integer uid;
    private String uname;

    private Integer pid;
    private String pname;
    private Double pprice;

    private Integer number;
}
