package com.secondkill.secondkill.dao;

import com.secondkill.secondkill.entity.Stock;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/12
 */
@Mapper
public interface StockDao {
    Stock getById(Long id);
    int updateSale(Long id);
}