package cn.javayong.shardingjdbc5.spring.controller;


import cn.javayong.shardingjdbc5.spring.common.result.ResponseEntity;
import cn.javayong.shardingjdbc5.spring.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

    @GetMapping("/queryOrderList")
    @ApiOperation("queryOrderList")
    public ResponseEntity queryOrderList(Integer page) {
        List<Map<String, Object>> orderMap = orderService.queryOrderList(page);
        Integer count = orderService.queryOrderCount();
        return ResponseEntity.successResult(orderMap);
    }

    @GetMapping("/save")
    @ApiOperation("save")
    public ResponseEntity save() {
        Long orderId = orderService.save();
        return ResponseEntity.successResult(orderId);
    }

    @GetMapping("/batchsave")
    @ApiOperation("batchsave")
    public ResponseEntity batchsave() {
        orderService.batchsave();
        return ResponseEntity.successResult(null);
    }

    @GetMapping("/queryOrderListDemo")
    @ApiOperation("queryOrderListDemo")
    public ResponseEntity queryOrderListDemo() {
        List list = orderService.queryOrderListDemo();
        return ResponseEntity.successResult(list);
    }

    @GetMapping("/queryBroadCastTable")
    @ApiOperation("queryBroadCastTable")
    public ResponseEntity queryBroadCastTable() {
        // step 1： 先查询
        List list = orderService.queryCityList();
        // step 2: 后修改
        orderService.updateCity();
        return ResponseEntity.successResult(list);
    }

}
