package com.secondkill.secondkill.dao;

import com.secondkill.secondkill.entity.StockOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/21
 */
public interface StockOrderDao extends JpaRepository<StockOrder,Long> {

}
