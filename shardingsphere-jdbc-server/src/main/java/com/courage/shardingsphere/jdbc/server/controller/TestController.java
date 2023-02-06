package com.courage.shardingsphere.jdbc.server.controller;

import com.courage.shardingsphere.jdbc.common.result.ResponseEntity;
import com.courage.shardingsphere.jdbc.domain.po.TEntOrder;
import com.courage.shardingsphere.jdbc.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/hello")
@Slf4j
public class TestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/test")
    @ApiOperation("test")
    public ResponseEntity test() {
        return ResponseEntity.successResult("mylife");
    }

    @GetMapping("/getOrderById")
    @ApiOperation("getOrderById")
    public ResponseEntity getOrderById(String orderId) {
        TEntOrder tEntOrder = orderService.getOrderById(Long.valueOf(orderId));
        return ResponseEntity.successResult(tEntOrder);
    }

}
