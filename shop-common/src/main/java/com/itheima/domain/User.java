package com.itheima.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ZhangHao
 * @Title: User
 * @Package com.itheima.domain
 * @Description: 用户实体
 * @date 2020/7/19:58
 */
@Entity(name = "shop_user")//jpa 提供注解 实体类和数据表对应
@Data
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增长
    private Integer uid;
    private String userName;
    private String password;
    private String telephoen;


}