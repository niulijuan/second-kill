package com.secondkill.secondkill.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 商品表
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/12
 */
@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer counts;
    private Integer sale;
    private Long version;
}
