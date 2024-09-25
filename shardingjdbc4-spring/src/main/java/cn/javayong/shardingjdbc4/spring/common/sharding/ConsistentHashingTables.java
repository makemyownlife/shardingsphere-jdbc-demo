package cn.javayong.shardingjdbc4.spring.common.sharding;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性哈希算法实现类
 * 用于在分布式系统中实现数据或请求的均衡分配
 *
 * @author Durant
 * @date 2024/9/24/周二
 * @since 1.0.0
 */
public class ConsistentHashingTables extends ConsistentHashingDatabase{
    // 存储环上所有节点及其哈希值的映射，使用TreeMap自动排序
    private final SortedMap<Long, String> circle = new TreeMap<>();

    private final HashFunction hashFunction = new SHA256HashFunction();

    /**
     * 构造函数，初始化一致性哈希环, 分表策略, 分表策略中 没有虚拟节点的概念，这里virtualNodeCount=1
     *
     * @param nodes          分布式系统中的实际表列表
     * @param virtualNodeCount 每个实际节点对应的虚拟节点数量，用于提高哈希环的均衡度
     */
    public void init(List<String> nodes, int virtualNodeCount) {
        // 遍历所有节点，将其添加到哈希环中
        for (String node : nodes) {
            for (int i = 0; i < virtualNodeCount; i++) {
                // 生成虚拟节点名称
                String virtualNodeName = node + "VN" + i;
                // 计算虚拟节点的哈希值，并添加到环上
                long hash = hashFunction.hash(virtualNodeName);
                // circle.put(hash, virtualNodeName); 这里本来取虚拟节点其实不对，应该取实际节点
                circle.put(hash, node);
            }
        }
    }

    @Override
    public String getTargetNode(String key) {
        if (this.circle.isEmpty()) {
            return null;
        }
        // 计算键的哈希值
        long hash = hashFunction.hash(key);
        // 找到哈希环上大于等于hash值的节点
        SortedMap<Long, String> tailMap = this.circle.tailMap(hash);
        if (tailMap.isEmpty()) {
            // 如果不存在，循环到环的起始位置
            return this.circle.get(this.circle.firstKey());
        } else {
            // 返回找到的节点
            return tailMap.get(tailMap.firstKey());
        }
    }
}
