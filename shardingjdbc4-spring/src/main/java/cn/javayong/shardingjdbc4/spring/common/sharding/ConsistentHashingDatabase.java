package cn.javayong.shardingjdbc4.spring.common.sharding;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Arrays;
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
@Slf4j
public class ConsistentHashingDatabase {
    // 存储环上所有节点及其哈希值的映射，使用TreeMap自动排序
    private final SortedMap<Long, String> circle = new TreeMap<>();
    // 哈希函数接口实例，具体哈希算法通过构造函数指定
    private final HashFunction hashFunction = new SHA256HashFunction();

    /**
     * 构造函数，初始化一致性哈希环
     *
     * @param nodes          分布式系统中的实际节点列表
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

    /**
     * 根据给定的键（如数据键或请求键）找到对应的节点
     *
     * @param key 用于定位的键，可以是数据的标识符或请求的某个特征值
     * @return 对应的节点名称，如果环为空则返回null
     */
    public String getTargetNode(String key) {
        String res = null;
        if (circle.isEmpty()) {
            return res;
        }
        // 计算键的哈希值
        long hash = hashFunction.hash(key);
        // 找到哈希环上大于等于hash值的节点
        SortedMap<Long, String> tailMap = circle.tailMap(hash);
        if (tailMap.isEmpty()) {
            // 如果不存在，循环到环的起始位置
            res = circle.get(circle.firstKey());
        } else {
            // 返回找到的节点
            res = tailMap.get(tailMap.firstKey());
        }
        log.info("key, {}, hash:{}, res:{}", key, hash, res);
        return res;
    }

    /**
     * 哈希函数接口定义
     */
    interface HashFunction {
        long hash(String value);
    }

    /**
     * 使用SHA-256算法实现的哈希函数
     */
    static class SHA256HashFunction implements HashFunction {
        @Override
        public long hash(String value) {
            try {
                // 获取SHA-256消息摘要对象
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                // 计算哈希值
                byte[] hash = digest.digest(value.getBytes());
                // 将字节数组转换为长整型哈希值,注意这里的哈希有负数，可能有坑？？注意注意
                return ((long) (hash[3] & 0xFF) << 56)
                        | ((long) (hash[2] & 0xFF) << 48)
                        | ((long) (hash[1] & 0xFF) << 40)
                        | ((long) (hash[0] & 0xFF) << 32)
                        | ((long) (hash[7] & 0xFF) << 24)
                        | ((hash[6] & 0xFF) << 16)
                        | ((hash[5] & 0xFF) << 8)
                        | (hash[4] & 0xFF);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) {
        ConsistentHashingDatabase consistentHashingDatabase = new ConsistentHashingDatabase();
        consistentHashingDatabase.init(Arrays.asList("ds0", "ds1", "ds2", "ds3"), 8);

        for (int i = 600; i < 650; i++) {
            System.out.println(consistentHashingDatabase.getTargetNode(String.valueOf(i)));
        }


    }
}
