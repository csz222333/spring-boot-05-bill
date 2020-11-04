package com.mengxuegu.springboot.dao;


import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BillDao {

    private static Map<Integer, Bill> billMap = null;
    private static Integer initId = 3006;

    @Autowired
    private ProviderDao providerDao;




    public void save(Bill bill){
        if(bill.getBid() == null){
            bill.setBid(initId++);
        }
        //添加供应商
        bill.setProvider( providerDao.getProvider( bill.getProvider().getPid() ));

        billMap.put(bill.getBid(), bill);
    }

    public Collection<Bill> getAll(){
        return billMap.values();
    }

    /**
     * 搜索查询
     * @param bill
     * @return
     */
    public Collection<Bill> getAll(Bill bill){
        Collection<Bill> bills = getAll();

        if (!StringUtils.isEmpty(bill.getBillName())) {
            //
        }
        if (bill.getProvider().getPid() != null) {
            //
        }
        if (bill.getPay() != null) {
            //
        }
        return bills;
    }

    public Bill get(Integer id){
        return billMap.get(id);
    }

    public void delete(Integer id){
        billMap.remove(id);
    }
}
