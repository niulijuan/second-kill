package com.secondkill.secondkill.dao;

import com.secondkill.secondkill.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/12
 */
public interface StockDao extends JpaRepository<Stock,Long> {
    Stock getById(Long id);
}