/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : ds_0

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 05/02/2023 22:43:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
-- Table structure for t_ent_order_item_0
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_0`;
CREATE TABLE `t_ent_order_item_0` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_1
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_1`;
CREATE TABLE `t_ent_order_item_1` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_2
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_2`;
CREATE TABLE `t_ent_order_item_2` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_3
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_3`;
CREATE TABLE `t_ent_order_item_3` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_4
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_4`;
CREATE TABLE `t_ent_order_item_4` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_5
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_5`;
CREATE TABLE `t_ent_order_item_5` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_6
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_6`;
CREATE TABLE `t_ent_order_item_6` (
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

-- ----------------------------
-- Table structure for t_ent_order_item_7
-- ----------------------------
DROP TABLE IF EXISTS `t_ent_order_item_7`;
CREATE TABLE `t_ent_order_item_7` (
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
-- 数据染色(同步使用)
-- ----------------------------
CREATE TABLE tb_transaction (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                tablename VARCHAR(255) NOT NULL,
                                status INT DEFAULT 0,
                                create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS `t_city`;

CREATE TABLE `t_city` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `city_name` varchar(100) NOT NULL COMMENT '城市名称',
    `region_code` varchar(45) NOT NULL COMMENT '区域编码',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `remark` varchar(200) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='城市表';


INSERT INTO `t_city` (`id`, `city_name`, `region_code`, `create_time`, `update_time`)
VALUES (1, '北京', '0000001', NOW(), NOW());

