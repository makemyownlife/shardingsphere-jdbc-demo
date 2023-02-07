package com.courage.shardingsphere.jdbc.domain.mapper;

import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrderItem;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    TEntOrder getOrderById(Long id);


    void saveOrder(TEntOrder entOrder);


    void saveOrderItem(TEntOrderItem entOrderItem);

}
