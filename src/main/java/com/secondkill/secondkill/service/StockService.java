package com.secondkill.secondkill.service;
import com.csyy.mzlc.cache.SimpleCacheService;
import com.nonobank.architecture.lock.redis.LockFactory;
import com.secondkill.secondkill.dao.StockDao;
import com.secondkill.secondkill.entity.Stock;
import com.secondkill.secondkill.entity.StockOrder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/21
 */
@Service
public class StockService {

    @Resource
    private StockDao stockDao;
    @Autowired
    private StockOrderService stockOrderService;
    @Autowired
    private SimpleCacheService simpleCacheService;
    @Autowired
    LockFactory lockFactory;


    public boolean buyByCacheSet(Long userId,Long id){//

        String shop = simpleCacheService.spop("shop");
        if(StringUtils.isNotBlank(shop)){
            System.out.println("用户"+userId+"抢到了，哈哈哈哈哈哈哈哈");
            return true;
        }else{
            System.out.println("用户" + userId + "没抢到");
            return false;
        }

//        simpleCacheService.sadd("user",userId.toString());
//        System.out.println("output:>>>排队中"+userId);
//        return true;
        //Integer count = Optional.ofNullable(stockDao.getById(id).getCounts()).orElse(0);
//       Integer count = Integer.valueOf(simpleCacheService.get("shop:"+id));
//       DistributeLock distributeLock = null;
//       if(count>0){
//           try {
//               distributeLock = lockFactory.getDistributeLock("count");
//               if (distributeLock.trylock()) {
//                    simpleCacheService.set("shop:"+id,(--count));
//                   System.out.println("output:>>>下单成功啦");
//                    //异步处理下单 数据库减库存
//                   return true;
//               }
//           } finally {
//               distributeLock.unlock();
//           }
//           System.out.println("output:>>>没有抢到");
//           return false;
//       }else {
//           System.out.println("output:>>>库存为0");
//           return false;
//       }
    }


    public boolean Buy(Long id){//db

        if(isBuy(id)){//是否可以购买
            //生成订单
            Stock stock = stockDao.getById(id);
            StockOrder stockOrder = new StockOrder();
            stockOrder.setName(stock.getName());
            stockOrder.setSid(stock.getId());
            stockOrderService.save(stockOrder);
            System.out.println("output:>>>success");
            return true;
        }else{
            System.out.println("output:>>>error");
            return  false;
        }
    }



    public boolean isBuy(Long id){
        return stockDao.updateSale(id) >= 1 ? true : false;
    }

}
