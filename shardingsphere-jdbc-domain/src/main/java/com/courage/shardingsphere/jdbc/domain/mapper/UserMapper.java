package com.courage.shardingsphere.jdbc.domain.mapper;

import com.courage.shardingsphere.jdbc.domain.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(Long id);

}
