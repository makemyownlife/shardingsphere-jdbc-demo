![](https://javayong.cn/pics/shipinhao/gongzhonghaonew.png)

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
            algorithm-class-name: cn.javayongshardingsphere.jdbc.service.sharding.HashSlotAlgorithm
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
            algorithm-class-name: cn.javayongshardingsphere.jdbc.service.sharding.HashSlotAlgorithm
        # 分表策略
        tableStrategy:
          complex:
            sharding-columns: id,ent_id
            algorithm-class-name: cn.javayongshardingsphere.jdbc.service.sharding.HashSlotAlgorithm
      # 订单详情表
      t_ent_order_detail:
        # 真实表
        actualDataNodes: ds$->{0..3}.t_ent_order_detail
        # 分库策略
        databaseStrategy:
           complex:
              sharding-columns: id,ent_id
              algorithm-class-name: cn.javayongshardingsphere.jdbc.service.sharding.HashSlotAlgorithm
        # 分表策略
        tableStrategy:
            complex:
              sharding-columns: id,ent_id
              algorithm-class-name: cn.javayongshardingsphere.jdbc.service.sharding.HashSlotAlgorithm
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

## 4 分库分表扩容

### 4.1 当前分库分表情况

通过运维管理平台分析数据库实例使用情况（一般和运维一起），分析核心属性：表空间大小，表空间占比 ，数据容量，数据碎片率，表行数，平均行长。

数据库的瓶颈主要体现在：磁盘、CPU、内存、网络、连接数，而连接数主要是受 CPU 和 内存影响。

1. CPU 和内存可以通过升级配置来提升 ， 磁盘可以使用 SSD 提升写入速度 ，可以运维同学解决；

2. 磁盘 IO 在大量写入的情况下，写入性能会急剧下降 ，考虑分库；
3. 考虑到 MySQL InnoDB  存储引擎 B+ tree 的特性 ，单表存储一般超过 1000万 ，IO 速度会下降，分表可以提升读取和写入速度；

**归根到底，分库分表需要业务增长以及成本(服务器，人力投入)。** 

### 4.2  分库分表扩容

见下图，假设原来订单数据有 4 个实例 ，每个实例一个数据库，每个数据库上包含 16 张表，现在需要把 4 个实例迁移到8个实例上，每个实例上一个数据库，每个数据库包含 64 张表 。

![](https://oscimg.oschina.net/oscnet/up-93a52112e8fedceaa745487cbb0fccf62f5.png)

整个数据迁移工作包括 ：

1. 前期准备

2. 数据同步环节（ 历史数据全量同步、增量数据实时同步、rehash ）

3. 数据校验环节（ 全量校验、实时校验、校验规则配置 ）

4. 数据修复工具

**▍1、前期准备**

在数据同步之前，需要梳理迁移范围。

- 业务唯一主键 

  在进行数据同步前，需要先梳理所有表的唯一业务 ID，只有确定了唯一业务 ID 才能实现数据的同步操作。

  需要注意的是：

  业务中是否有使用数据库自增 ID 做为业务 ID 使用的，如果有需要业务先进行改造 。另外确保每个表是否都有唯一索引，

  一旦表中没有唯一索引，就会在数据同步过程中造成数据重复的风险，所以我们先将没有唯一索引的表根据业务场景增加唯一索引（有可能是联合唯一索引）。

- 迁移哪些表，迁移后的分库分表规则

  分表规则不同决定着 rehash 和数据校验的不同。需逐个表梳理是用户ID纬度分表还是非用户ID纬度分表、是否只分库不分表、是否不分库不分表等等。

**▍2、数据同步**

数据同步整体方案见下图，数据同步基于 binlog ，独立的中间服务做同步，对业务代码无侵入。

![](https://oscimg.oschina.net/oscnet/up-2f372c25c5a4c61829c98fc921638bedf8d.png)

首先需要做**历史数据全量同步**：也就是将旧库（ 4个实例，每个实例 16 张表）迁移到新库（ 8 个实例，每个实例 64 张表）。

通常的做法是：单独一个服务，使用游标的方式从旧库分片 select 语句，经过 rehash 后批量插入 （batch insert）到新库，需要配置jdbc 连接串参数 rewriteBatchedStatements=true 才能使批处理操作生效。

另外特别需要注意的是，历史数据也会存在不断的更新，如果先开启历史数据全量同步，则刚同步完成的数据有可能不是最新的。

所以这里的做法是，先开启增量数据单向同步（从旧库到新库），此时只是开启积压 kafka 消息并不会真正消费；然后在开始历史数据全量同步，当历史全量数据同步完成后，在开启消费 kafka 消息进行增量数据同步（提高全量同步效率减少积压也是关键的一环），这样来保证迁移数据过程中的数据一致。

增量数据同步考虑到灰度切流稳定性、容灾 和 可回滚能力 ，采用实时双向同步方案，切流过程中一旦新库出现稳定性问题或者新库出现数据一致问题，可快速回滚切回旧库，保证数据库的稳定和数据可靠。

![](https://oscimg.oschina.net/oscnet/up-3de1ad6f4801271f1836cd59a9b2f056bfb.png)

增量数据实时同步的大体思路 ：

1. 过滤循环消息：需要过滤掉循环同步的 binlog 消息 ;
2. 数据合并：同一条记录的多条操作只保留最后一条。为了提高性能，数据同步组件接到 kafka 消息后不会立刻进行数据流转，而是先存到本地阻塞队列，然后由本地定时任务每X秒将本地队列中的N条数据进行数据流转操作。此时N条数据有可能是对同一张表同一条记录的操作，所以此处只需要保留最后一条（类似于 redis aof 重写）;
3. update 转 insert ：数据合并时，如果数据中有 insert + update 只保留最后一条 update ，会执行失败，所以此处需要将update转为 insert 语句 ;
4. 按新表合并 ：将最终要提交的 N 条数据，按照新表进行拆分合并，这样可以直接按照新表纬度进行数据库批量操作，提高插入效率；

整个过程中有几个问题需要注意：

问题 1 ：怎么防止因异步消息无顺序而导致的数据一致问题 ？

首先 kafka 异步消息是存在顺序问题的，但是要知道的是 binlog 是顺序的，所以数据传输服务在对 kafka 消息投递时也是顺序的，此处要做的就是一个库保证只有一个消费者就能保障数据的顺序问题、不会出现数据状态覆盖，从而解决数据一致问题。

问题 2 ：是否会有丢消息问题，比如消费者服务重启等情况下 ？

这里没有采用自动提交 offset ，而是每次消费数据最终入库完成后，将 offset 异步存到一个 mysql 表中，如果消费者服务重启宕机等，重启后从 mysql 拿到最新的offset开始消费。这样唯一的一个问题可能会出现瞬间部分消息重复消费,但是因为上面介绍的binlog是顺序的, 所以能保证数据的最终一致。

问题3：update 转 insert 会不会丢字段 ？

binlog 是全字段发送,不会存在丢字段情况。

**双向同步时的 binlog 循环消费问题**

想象一下，业务写一条数据到旧实例的一张表，于是产生了一条 binlog ； 数据同步中间件接到 binlog 后，将该记录写入到新实例，于是在新实例也产生了一条 binlog ；此时 数据同步中间件又接到了该 binlog ......不断循环，消息越来越多，数据顺序也被打乱。

怎么解决该问题呢？ 我们采用数据染色方案，只要能够标识写入到数据库中的数据使数据同步中间件写入而非业务写入，当下次接收到该 binlog 数据的时候就不需要进行再次消息流转。

所以 数据同步中间件要求，每个数据库实例创建一个事务表，该事务表 tb_transaction 只有 id、tablename、status、create_time、update_time 几个字段，status 默认为 0。

再回到上面的问题，业务写一条数据到旧实例的一张表，于是产生了一条 binlog ； 数据同步中间件接到 binlog 后，如下操作：

``` SQL
# 开启事务，用事务保证一下sql的原子性和一致性
start transaction;
set autocommit = 0;
# 更新事务表status=1，标识后面的业务数据开始染色
update tb_transaction set status = 1 where tablename = ${tableName};
# 以下是业务产生binlog
insert xxx;
update xxx;
update xxx;
# 更新事务表status=0，标识后面的业务数据失去染色
update tb_transaction set status = 0 where tablename = ${tableName};
commit;
```

此时数据同步中间件将上面这些语句打包一起提交到新实例，新实例更新数据后也会生产对应上面语句的 binlog ；当数据同步中间件再次接收到 binlog 时，只要判断遇到 tb_transaction 表 status=1 的数据开始，后面的数据都直接丢弃不要，直到遇到status=0时，再继续接收数据，以此来保证数据同步中间件只会流转业务产生的消息。





![](https://oscimg.oschina.net/oscnet/up-55c4813079e817b17708d7e0d248fa73f9e.png)



**▍3、数据校验环节**

数据校验模块由数据校验服务data-check模块来实现，主要是基于数据库层面的数据对比，逐条核对每一个数据字段是否一致，不一致的话会经过配置的校验规则来进行重试或者报警。

**全量校验**

以旧库为基准，查询每一条数据在新库是否存在，以及个字段是否一致。

以新库为基准，查询每一条数据在旧库是否存在，以及个字段是否一致。

**实时校验**

定时任务每5分钟校验，查询最近5+1分钟旧库和新库更新的数据，做diff。

差异数据进行二次、三次校验（由于并发和数据延迟存在），三次校验都不同则报警。

![](https://oscimg.oschina.net/oscnet/up-c1c75bd018103ff8753e8e2cb80889765b7.png)

**▍4、数据修复工具**

经过数据校验，一旦发现数据不一致，则需要对数据进行修复操作。

数据修复有两种方案，一种是适用于大范围的数据不一致，采用重置kafka offset的方式，重新消费数据消息，将有问题的数据进行覆盖。

![img](https://p2.itc.cn/q_70/images03/20210316/4257659cd39a4fcbb9377b292c7bbce4.png)

第二种是适用于小范围的数据不一致，数据修复模块自动拉取数据校验data-check模块记录的sls日志，进行日志解析，生成同步语句，更新到目标库。

![img](https://p0.itc.cn/q_70/images03/20210316/d38386cc893e4f639ae56e962643ba45.png)

**灰度切换数据源**

**整体灰度切流方案**

整体灰度方案：SP+用户纬度来实现，SP纬度：依靠灰度环境切量来做，用户纬度：依赖用户ID后四位百分比切流。

灰度切量的过程一定要配合停写（秒级），为什么要停写，因为数据同步存在一定延迟（正常毫秒级），而所有业务操作一定要保障都在一个实例上，否则在旧库中业务刚刚修改了一条数据，此时切换到新库如果数据还没有同步过来就是旧数据会有数据一致问题。所以步骤应该是：

1. 先停写
2. 观察数据全部同步完
3. 在切换数据源
4. 最后关闭停写，开始正常业务写入

**切流前准备——ABC验证**

虽然在切流之前，在测试环境进过了大量的测试，但是测试环境毕竟和生产环境不一样，生产环境数据库一旦出问题就可能是灭顶之灾，虽然上面介绍了数据校验和数据修复流程，但是把问题拦截在发生之前是做服务稳定性最重要的工作。

因此我们提出了ABC验证的概念，灰度环境ABC验证准备：

1. 新购买两套数据库实例，当前订单库为A，新买的两套为分别为B、C
2. 配置DTS从A单项同步到B（dts支持同构不需要rehash的数据同步），B做为旧库的验证库，C库做为新库
3. 用B和C作为生产演练验证
4. 当B和C演练完成之后，在将A和C配置为正式的双向同步

![img](https://p4.itc.cn/q_70/images03/20210316/f48411309ee648e08240c7814b93a01d.png)

**灰度切流步骤**

具体灰度方案和数据源切换流程：

1. 代码提前配置好两套数据库分库分表规则。
2. 通过ACM配置灰度比例。
3. 代码拦截mybatis请求，根据用户id后四位取模，和ACM设置中设置的灰度比例比较，将新库标识通过ThreadLocal传递到分库分表组件。
4. 判断当前是否有灰度白名单，如命中将新库标识通过ThreadLocal传递到分库分表组件。
5. 分库分表组件根据ACM配置拿到新分库的分表规则，进行数据库读写操作。
6. 切量时会配合ACM配置灰度比例命中的用户进行停写。

