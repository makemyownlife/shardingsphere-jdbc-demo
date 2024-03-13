package cn.javayong.shardingjdbc4.spring.controller;


import cn.javayong.shardingjdbc4.spring.common.result.ResponseEntity;
import cn.javayong.shardingjdbc4.spring.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/hello")
@Slf4j
public class TestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    @ApiOperation("test")
    public ResponseEntity test() {
        redisTemplate.opsForValue().set("hello", "myulife");
        return ResponseEntity.successResult("mylife");
    }

    @GetMapping("/queryOrder")
    @ApiOperation("queryOrder")
    public ResponseEntity queryOrder(String orderId) {
        Map<String, Object> orderMap = orderService.queryOrder(Long.valueOf(orderId));
        return ResponseEntity.successResult(orderMap);
    }

    @GetMapping("/save")
    @ApiOperation("save")
    public ResponseEntity save() {
        Long orderId = orderService.save();
        return ResponseEntity.successResult(orderId);
    }

}
