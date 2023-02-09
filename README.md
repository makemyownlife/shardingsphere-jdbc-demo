## 1 创建数据库

![](https://oscimg.oschina.net/oscnet/up-c9971a2fa253252d45c65a54b4fd07eb1f6.png)

- 首先在navicat中，创建4个库，分别是：ds_0，ds_1，ds_2，ds_3 ;
- 在 doc 文档中 ，分别在 4个库里执行 init.sql 语句 ，执行后效果见上图 。

我们还是以订单表举例 ，当用户创建一条记录 ， 会生成如下记录：

1. 订单基础表 ： t_ent_order 表 , 1条记录 ；
2. 订单详情表：  t_ent_order_detail ，1条记录；
3. 订单明细表：  t_ent_order_item , 多条记录 。

那我们使用怎样的分库分表策略呢 ？

1. 订单基础表 t_ent_order 按照 ent_id (企业编号) 分库 ，订单详情表保持一致；
2. 订单明细表 t_ent_order_item 按照 ent_id (企业编号) 分库 ， 同时也要分表 。

## 2 使用shardingsphere jdbc 

首先配置依赖：

```xml
<!-- shardingsphere jdbc start -->
<dependency>
    <groupId>org.apache.shardingsphere</groupId>
    <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
    <version>4.1.1</version>
</dependency>
<!-- shardingsphere jdbc end -->
```

重点强调， 原来分库分表之前， 很多 springboot 工程依赖 druid ，必须要删除如下的依赖：

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
</dependency>
```

在配置文件中配置如下：

```xml
shardingsphere:
  datasource:
    enabled: true
    names: ds0,ds1,ds2,ds3
    ds0:
      type: com.alibaba.druid.pool.DruidDataSource
      driverClassName: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/ds_0?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true
      username: root
      password: ilxw
    ds1:
      type: com.alibaba.druid.pool.DruidDataSource
      driverClassName: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/ds_1?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true
      username: root
      password: ilxw
    ds2:
      type: com.alibaba.druid.pool.DruidDataSource
      driverClassName: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/ds_2?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true
      username: root
      password: ilxw
    ds3:
      type: com.alibaba.druid.pool.DruidDataSource
      driverClassName: com.mysql.cj.jdbc.Driver
      url: jdbc:mysql://127.0.0.1:3306/ds_3?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true
      username: root
      password: ilxw
  props:
    # 日志显示 SQL
    sql.show: true
  sharding:
    tables:
      # 订单表基础表
      t_ent_order:
        # 真实表
        actualDataNodes: ds$->{0..3}.t_ent_order
        # 分库策略
        databaseStrategy:
          complex:
            sharding-columns: id,ent_id
            algorithm-class-name: com.courage.shardingsphere.jdbc.service.sharding.HashSlotAlgorithm
        # 分表策略
        tableStrategy:
          none:
      # 订单条目表
      t_ent_order_item:
        # 真实表
        actualDataNodes: ds$->{0..3}.t_ent_order_item_$->{0..7}
        # 分库策略
        databaseStrategy:
          complex:
            sharding-columns: id,ent_id
            algorithm-class-name: com.courage.shardingsphere.jdbc.service.sharding.HashSlotAlgorithm
        # 分表策略
        tableStrategy:
          complex:
            sharding-columns: id,ent_id
            algorithm-class-name: com.courage.shardingsphere.jdbc.service.sharding.HashSlotAlgorithm
      # 订单详情表
      t_ent_order_detail:
        # 真实表
        actualDataNodes: ds$->{0..3}.t_ent_order_detail
        # 分库策略
        databaseStrategy:
           complex:
              sharding-columns: id,ent_id
              algorithm-class-name: com.courage.shardingsphere.jdbc.service.sharding.HashSlotAlgorithm
        # 分表策略
        tableStrategy:
            complex:
              sharding-columns: id,ent_id
              algorithm-class-name: com.courage.shardingsphere.jdbc.service.sharding.HashSlotAlgorithm
    bindingTables:
      - t_ent_order,t_ent_order_detail
```

配置很简单，需要配置如下几点：

1. 配置数据源，上面配置数据源是： ds0, ds1 , ds2 , ds3 ；

2. 配置打印日志，也就是：sql.show ，在测试环境建议打开 ，便于调试；

3. 配置哪些表需要分库分表 ，在shardingsphere.datasource.sharding.tables 节点下面配置。

   ![](https://oscimg.oschina.net/oscnet/up-4212b6ecc449d47123b5168313aad087ac4.png)

   标红的是分库算法 ，下面的分表算法也是一样的。 

   ## 3 复合分片算法

   假设现在需要将订单表平均拆分到4个分库 shard0 ，shard1 ，shard2 ，shard3 。首先将 [0-1023] 平均分为4个区段：[0-255]，[256-511]，[512-767]，[768-1023]，然后对字符串（或子串，由用户自定义）做 hash， hash 结果对1024取模，最终得出的结果<strong style="font-size: 18px;line-height: inherit;color: rgb(255, 104, 39);"> slot </strong>落入哪个区段，便路由到哪个分库。

   ![](https://oscimg.oschina.net/oscnet/up-95a591ba73b27acd967f4d4907722369a37.png)

   路由算法 ，可以和<strong style="font-size: inherit;line-height: inherit;color: rgb(255, 104, 39);"> 雪花算法 </strong>天然融合在一起， 订单 <strong style="font-size: inherit;line-height: inherit;color: rgb(255, 104, 39);">order_id </strong>使用雪花算法，我们可以将 <strong style="font-size: inherit;line-height: inherit;color: rgb(255, 104, 39);"> slot </strong>的值保存在<strong style="font-size: inherit;line-height: inherit;color: rgb(255, 104, 39);"> 10位工作机器ID </strong>里。

   ![](https://oscimg.oschina.net/oscnet/up-10106ff9ac00e5520ea047be17cb82077ce.png)

   通过订单 <strong style="font-size: inherit;line-height: inherit;color: rgb(255, 104, 39);">order_id </strong> 可以反查出<strong style="font-size: 17px;line-height: inherit;color: rgb(255, 104, 39);"> slot </strong>, 就可以定位该用户的订单数据存储在哪个分区里。

   ```java
   Integer getWorkerId(Long orderId) {
    Long workerId = (orderId >> 12) & 0x03ff;
    return workerId.intValue();
   }
   ```

   接下来，我们看下分库分表算法的 JAVA 实现 ，因为我们需要按照主键 ID ，还有用户ID 来查询订单信息，那么我们必须实现复合分片 , 也就是实现 **ComplexKeysShardingAlgorithm** 类。  

   ![](https://oscimg.oschina.net/oscnet/up-831524520a49c17c07710b876f5f489ac64.png)

## 3 ID 生成器

![](https://oscimg.oschina.net/oscnet/up-a8ebd81abcd817a760b11c26cc3f5ce6ea6.png)

![](https://oscimg.oschina.net/oscnet/up-4d3e1e34ce64f1b0c51add537582c3c108f.png)

1. 查询本地内存，判定是否可以从本地队列中获取 currentTime , seq 两个参数 ，若存在，直接组装；
2. 若不存在，调用 redis 的 INCRBY 命令 ，这里需要传递一个步长值，便于放一篇数据到本地内存里；
3. 将数据回写到本地内存 ；
4. 重新查询本地内存，本地队列中获取 currentTime , seq 两个参数 ，组装最后的结果，返回给生成器 。

