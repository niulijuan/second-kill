package com.secondkill.secondkill.web;

import com.secondkill.secondkill.entity.Stock;
import com.secondkill.secondkill.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author niulijuan <niulijuan@maizijf.com>
 * @create 2018/6/21
 */
@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    @ResponseBody
    public Stock buy(){
        stockService.Buy(2l);
        return null;
    }
}
