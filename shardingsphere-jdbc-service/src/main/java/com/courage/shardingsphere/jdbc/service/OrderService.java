package com.courage.shardingsphere.jdbc.service;

import com.courage.shardingsphere.jdbc.domain.mapper.OrderMapper;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrderItem;
import com.courage.shardingsphere.jdbc.service.sharding.SnowFlakeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public TEntOrder getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    public void save() {
        Long entId = 5L;
        AtomicInteger seq = new AtomicInteger(0);
        TEntOrder tEntOrder = new TEntOrder();
        Long orderId = SnowFlakeIdGenerator.getUniqueId(entId.intValue(), seq.incrementAndGet());
        System.out.println("orderId:" + orderId);
        tEntOrder.setId(orderId);
        tEntOrder.setRegionCode("BJ");
        tEntOrder.setAmount(new BigDecimal(12.0));
        tEntOrder.setMobile("150****9235");
        tEntOrder.setEntId(entId);
        orderMapper.saveOrder(tEntOrder);
        //保存条目
        TEntOrderItem item = new TEntOrderItem();
        Long itemId = SnowFlakeIdGenerator.getUniqueId(entId.intValue(), seq.incrementAndGet());
        item.setId(itemId);
        item.setOrderId(orderId);
        item.setGoodId("xxxaaaabbbbb");
        item.setGoodName("我的商品");
    }

}
