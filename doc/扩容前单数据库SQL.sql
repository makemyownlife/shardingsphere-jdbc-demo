SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Create database order_base
-- ----------------------------
DROP DATABASE IF EXISTS `order_base`;
CREATE DATABASE `order_base` CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE `order_base`;

-- ----------------------------
-- Table structure for t_ent_order
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order`;
CREATE TABLE `t_ent_order` (
                               `id` bigint(20) NOT NULL,
                               `ent_id` bigint(20) NOT NULL,
                               `region_code` varchar(40) COLLATE utf8_bin DEFAULT NULL,
                               `amount` decimal(12,2) NOT NULL,
                               `mobile` varchar(20) COLLATE utf8_bin NOT NULL,
                               `create_time` datetime NOT NULL,
                               `update_time` datetime NOT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_ent_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_detail`;
CREATE TABLE `t_ent_order_detail` (
                                      `id` bigint(20) NOT NULL,
                                      `order_id` bigint(20) NOT NULL COMMENT 't_ent_order 表 主键',
                                      `address` varchar(45) COLLATE utf8_bin NOT NULL,
                                      `status` tinyint(4) NOT NULL,
                                      `region_code` varchar(45) COLLATE utf8_bin NOT NULL,
                                      `ent_id` bigint(20) NOT NULL,
                                      `create_time` datetime NOT NULL,
                                      `update_time` datetime NOT NULL,
                                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for t_ent_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item`;
CREATE TABLE `t_ent_order_item` (
                                    `id` bigint(20) NOT NULL,
                                    `ent_id` bigint(20) NOT NULL,
                                    `region_code` varchar(45) COLLATE utf8_bin NOT NULL,
                                    `good_id` varchar(45) COLLATE utf8_bin NOT NULL,
                                    `good_name` varchar(45) COLLATE utf8_bin NOT NULL,
                                    `order_id` bigint(20) NOT NULL,
                                    `create_time` datetime NOT NULL,
                                    `update_time` datetime NOT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- 数据染色(同步使用) start
-- ----------------------------
CREATE TABLE tb_transaction (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                tablename VARCHAR(255) NOT NULL,
                                status INT DEFAULT 0,
                                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO `tb_transaction` (`id`, `tablename`, `status`, `create_time`, `update_time`) VALUES (1, 'order', 0, '2024-08-27 11:24:23', '2024-08-27 11:24:23');
-- ----------------------------
-- 数据染色(同步使用) end
-- ----------------------------