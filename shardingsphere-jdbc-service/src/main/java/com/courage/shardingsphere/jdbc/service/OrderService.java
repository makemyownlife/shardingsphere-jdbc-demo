package com.courage.shardingsphere.jdbc.service;

import com.courage.shardingsphere.jdbc.domain.mapper.OrderMapper;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public TEntOrder getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }


}
