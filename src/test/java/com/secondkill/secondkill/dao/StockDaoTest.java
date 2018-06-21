package com.secondkill.secondkill.dao;

import com.secondkill.secondkill.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ${DESCRIPTION}
 *
 * @author Shaojun Liu <liushaojun@maizijf.com>
 * @create 2018/6/19
 */
public class StockDaoTest extends BaseTest {

    @Autowired
    private StockDao stockDao;

    @Test
    public void getById() {
        System.out.println("output:>>>" + stockDao.getById(2l));
    }
}