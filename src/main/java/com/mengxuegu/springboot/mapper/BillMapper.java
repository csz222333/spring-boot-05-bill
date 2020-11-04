package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.ProviderBill;

import java.util.List;

public interface BillMapper {
    List<ProviderBill> getBills(Bill bill);
    ProviderBill getBillByBid(Integer bid);
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deteleBillByBid(Integer bid);
}
