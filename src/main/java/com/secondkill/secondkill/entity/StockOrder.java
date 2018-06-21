package com.secondkill.secondkill.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/12
 */
@Data
@Entity
public class StockOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sid;
    private String name;
    @Column(name = "create_time", insertable = false,updatable = false)
    private Date createTime;
}
