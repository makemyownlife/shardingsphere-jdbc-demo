package com.courage.shardingsphere.jdbc.service;

import com.courage.shardingsphere.jdbc.domain.mapper.OrderMapper;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisIdGeneratorService redisIdGeneratorService;

    public TEntOrder getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    @Transactional
    public void save() {
        Long entId = 5L;
        TEntOrder tEntOrder = new TEntOrder();
        Long orderId = redisIdGeneratorService.createUniqueId(String.valueOf(entId));
        System.out.println("orderId:" + orderId);
        tEntOrder.setId(orderId);
        tEntOrder.setRegionCode("BJ");
        tEntOrder.setAmount(new BigDecimal(12.0));
        tEntOrder.setMobile("150****9235");
        tEntOrder.setEntId(entId);
        orderMapper.saveOrder(tEntOrder);
        //保存条目 1
        TEntOrderItem item1 = new TEntOrderItem();
        Long itemId = redisIdGeneratorService.createUniqueId(String.valueOf(entId));
        item1.setId(itemId);
        item1.setEntId(entId);
        item1.setOrderId(orderId);
        item1.setRegionCode("BG");
        item1.setGoodId("aaaaaaaaaaaa");
        item1.setGoodName("我的商品");
        orderMapper.saveOrderItem(item1);
        //保存条目 2
        TEntOrderItem item2 = new TEntOrderItem();
        Long itemId2 = redisIdGeneratorService.createUniqueId(String.valueOf(entId));
        item2.setId(itemId2);
        item2.setEntId(entId);
        item2.setRegionCode("BJ");
        item2.setOrderId(orderId);
        item2.setGoodId("bbbbbbbbbbbb");
        item2.setGoodName("我的商品");
        orderMapper.saveOrderItem(item2);
    }

}
