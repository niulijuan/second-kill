package com.secondkill.secondkill.service;

import com.secondkill.secondkill.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * ${DESCRIPTION}
 *
 * @author Shaojun Liu <liushaojun@maizijf.com>
 * @create 2018/8/9
 */
public class StockServiceTest extends BaseTest {

    @Autowired
    private StockService stockService;

    public static  Long ID = 2l;
    public static  int USER_NUMBER = 100;
    public static CountDownLatch latch = new CountDownLatch(USER_NUMBER);


    @Test
    public void buy() throws InterruptedException {
        for(int i = 0 ;i<=USER_NUMBER;i++){
            new Thread(new UserBuy(ID)).start();
            latch.countDown();
        }
        Thread.currentThread().sleep(10000);
    }

    class UserBuy implements Runnable{
        private Long id ;
        public UserBuy(Long id){
            super();
            this.id = id;
        }
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // stockService.Buy(id);//数据库乐观锁
            stockService.buyByCacheSet(System.currentTimeMillis(), id);
        }
    }

}