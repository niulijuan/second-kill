package com.secondkill.secondkill.service;

import com.secondkill.secondkill.dao.StockDao;
import com.secondkill.secondkill.entity.Stock;
import com.secondkill.secondkill.entity.StockOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/21
 */
@Service
public class StockService {

    @Autowired
    private StockDao stockDao;
    @Autowired
    private StockOrderService stockOrderService;

    public boolean Buy(Long id){
        //检查订单
        Stock stock = stockDao.getById(id);
        if(stock.getCount()> stock.getSale()){
            //扣库存
            stock.setSale(stock.getSale()+1);
            stockDao.save(stock);
            //生成订单
            StockOrder stockOrder = new StockOrder();
            stockOrder.setName(stock.getName());
            stockOrder.setSid(stock.getId());
            stockOrderService.save(stockOrder);
            return true;
        }else{
            return false;
        }
    }



}
