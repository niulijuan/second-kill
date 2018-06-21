package com.secondkill.secondkill.service;

import com.secondkill.secondkill.dao.StockOrderDao;
import com.secondkill.secondkill.entity.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/21
 */
@Service
public class StockOrderService {

    @Autowired
    private StockOrderDao stockOrderDao;

    public StockOrder save(StockOrder stockOrder){
        return stockOrderDao.save(stockOrder);
    }
}
