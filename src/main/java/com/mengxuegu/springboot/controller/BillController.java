package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.ProviderBill;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 梦学谷
 */
@Controller
public class BillController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    BillMapper billMapper;
    @Autowired
    ProviderMapper providerMapper;
    @GetMapping("/bills")
    public String list(Map<String,Object> map, ProviderBill pb) {
        logger.info("账单列表查询"+pb);
        List<Provider> providers= providerMapper.getproviders(null);
        Collection<ProviderBill> BillProviders=billMapper.getBills(pb);
        System.out.printf(pb.toString());
        map.put("providers",providers);
        map.put("billProviders",BillProviders);
        // 前段传过来的值 回显出去
        map.put("billName",pb.getBillName());
        map.put("pid",pb.getPid());
        map.put("pay",pb.getPay());
        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid, @RequestParam(value = "type" ,defaultValue = "view")
            String type, Map<String,Object> map){
        logger.info("查询"+bid+"的账单信息");
        ProviderBill pb=billMapper.getBillByBid(bid);
        map.put("billProvider",pb);
        if ("uqdate".equals(type)){
            map.put("providers",providerMapper.getProvider(null));
        }
        return "bill/"+type;
    }

    @PutMapping("/bill")
    public String update(Bill bill){
        logger.info("更改账单信息.....");
        billMapper.updateBill(bill);
        return "redirect:bills";
    }

    @GetMapping("/bill")
    public String toaddPage(Map<String,Object> map){
        map.put("providers",providerMapper.getProvider(null));
        return "bill/add";
    }

    @PostMapping("/bill")
    public String add(Bill bill){
    logger.info("添加账单："+bill);
        billMapper.addBill(bill);
        return "redirect:bills";
    }

    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid){
        logger.info("删除操作,bid="+bid);
        billMapper.deteleBillByBid(bid);
        return "redirect:bills";
    }
}
