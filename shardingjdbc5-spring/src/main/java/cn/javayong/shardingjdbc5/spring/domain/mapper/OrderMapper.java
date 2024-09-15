package cn.javayong.shardingjdbc5.spring.domain.mapper;

import cn.javayong.shardingjdbc5.spring.domain.po.TEntOrder;
import cn.javayong.shardingjdbc5.spring.domain.po.TEntOrderDetail;
import cn.javayong.shardingjdbc5.spring.domain.po.TEntOrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {

    TEntOrder getOrderById(Long id);

    //保存基本信息
    void saveOrder(TEntOrder entOrder);

    //保存详情
    void saveOrderDetail(TEntOrderDetail orderDetail);

    //订单条目
    void saveOrderItem(TEntOrderItem entOrderItem);

    Map<String,Object> queryOrder(Long orderId);

    List<Map<String,Object>> queryOrderListDemo();

    List<Map<String,Object>> queryOrderList(Integer page);

    Integer queryOrderCount();

    // 查询城市列表
    List<Map<String,Object>> queryCityList();

    Integer updateCity();

}
