package com.secondkill.secondkill.dao;

import com.secondkill.secondkill.BaseTest;
import com.secondkill.secondkill.entity.StockOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author Shaojun Liu <liushaojun@maizijf.com>
 * @create 2018/8/9
 */
public class StockOrderDaoTest extends BaseTest {

    @Autowired
    private StockOrderDao stockOrderDao;

    @Test
    public void save(){
        StockOrder s = new StockOrder();
        s.setSid(2l);
        s.setName("123");
        stockOrderDao.save(s);
    }

}