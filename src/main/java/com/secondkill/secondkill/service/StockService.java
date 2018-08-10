package com.secondkill.secondkill.service;
import com.secondkill.secondkill.dao.StockDao;
import com.secondkill.secondkill.entity.Stock;
import com.secondkill.secondkill.entity.StockOrder;
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


    public boolean buyByCacheSet(Long userId,Long id){//cache  基于排队处理   用户先排队，快速响应失败，异步处理下单
        //Integer count = Optional.ofNullable(stockDao.getById(id).getCounts()).orElse(0);
//       Integer count = (Integer) redisTemplate.opsForValue().get("shop:"+id);
//        boolean limit = redisLimit.limit();//有注解可使用  @ControllerLimit
//        if(limit){
//            if (redisTemplate.opsForSet().size("user") <= count) {//
//                System.out.println("----------------count:" + redisTemplate.opsForSet().size("user"));
//               redisTemplate.opsForSet().add("user", userId.toString());
//                Buy(id);
//                return true;
//            } else {
//                System.out.println("output:>>>error");
//                return false;
//            }
//        }else{
//            System.out.println("output:>>>限流啦" );
//            return false;
//        }
        return false;
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
