package com.courage.shardingsphere.jdbc.domain.mapper;

import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {

    TEntOrder getOrderById(Long id);

}
