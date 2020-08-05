package com.itheima.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ZhangHao
 * @Title: Product
 * @Package com.itheima.domain
 * @Description:
 * @date 2020/7/110:09
 */
@Entity(name = "shop_product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;
    private String pname;//名字
    private Double pprice;//单价
    private Integer stock;//库存
}