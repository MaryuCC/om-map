/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3307
 Source Schema         : omMap

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 11/11/2024 14:20:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for o_article
-- ----------------------------
DROP TABLE IF EXISTS `o_article`;
CREATE TABLE `o_article`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `article_type` tinyint NOT NULL DEFAULT 1 COMMENT '1-event 2-post 3-group',
  `title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '文章标题',
  `short_title` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '短标题',
  `picture` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '文章封面图',
  `summary` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '文章简介',
  `topping_stat` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-非置顶 1-置顶',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '0-未发布 1-已发布',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '1-逻辑删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_title`(`title` ASC) USING BTREE,
  INDEX `idx_short_title`(`short_title` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_article_detail
-- ----------------------------
DROP TABLE IF EXISTS `o_article_detail`;
CREATE TABLE `o_article_detail`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `version` int NOT NULL DEFAULT 0,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容',
  `deleted` tinyint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_article_version`(`article_id` ASC, `version` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `o_article_tag`;
CREATE TABLE `o_article_tag`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章id',
  `tag_id` bigint NOT NULL DEFAULT 0 COMMENT '标签id',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_tag_id`(`tag_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_comment
-- ----------------------------
DROP TABLE IF EXISTS `o_comment`;
CREATE TABLE `o_comment`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '评论内容',
  `top_comment_id` bigint NOT NULL DEFAULT 0 COMMENT '顶层评论id',
  `parent_comment_id` bigint NOT NULL DEFAULT 0 COMMENT '父评论id',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_article_id`(`article_id` ASC) USING BTREE,
  INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_gift
-- ----------------------------
DROP TABLE IF EXISTS `o_gift`;
CREATE TABLE `o_gift`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `gift_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '类目名称',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `stock` int NOT NULL COMMENT '库存',
  `price` int NOT NULL DEFAULT 0,
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '0-未发布 1-已发布',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `valid_date` date NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_gift_detail
-- ----------------------------
DROP TABLE IF EXISTS `o_gift_detail`;
CREATE TABLE `o_gift_detail`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `gift_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT 'giftid',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '礼物详情',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_gift_id`(`gift_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_notify_msg
-- ----------------------------
DROP TABLE IF EXISTS `o_notify_msg`;
CREATE TABLE `o_notify_msg`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `related_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '关联的用户id',
  `notify_user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `operate_user_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '触发的用户id0',
  `msg` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '消息内容',
  `type` tinyint NOT NULL DEFAULT 0 COMMENT '0-默认 1-评论 2-回复 3-点赞 4-收藏 5-关注 6-系统',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '0-未读 1-已读',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key_notify_user_id_type_state`(`notify_user_id` ASC, `type` ASC, `state` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_order
-- ----------------------------
DROP TABLE IF EXISTS `o_order`;
CREATE TABLE `o_order`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_no` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0',
  `project_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT 'project id',
  `customer_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT 'customer_id',
  `customer_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'customer name',
  `original_price` decimal(10, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT 'original price',
  `total_price` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT 'price',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '0-pending 1-confirmed 2-completed 3-canceled',
  `cancel_time` timestamp NULL DEFAULT NULL,
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_relation`(`order_no` ASC, `project_id` ASC) USING BTREE,
  INDEX `idx_customer_id`(`customer_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_project
-- ----------------------------
DROP TABLE IF EXISTS `o_project`;
CREATE TABLE `o_project`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `host_id` bigint NOT NULL COMMENT 'orgnizer id',
  `project_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'project name',
  `project_address` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'address',
  `project_price` decimal(10, 2) NOT NULL COMMENT 'price',
  `deleted` tinyint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'project' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_project_detail
-- ----------------------------
DROP TABLE IF EXISTS `o_project_detail`;
CREATE TABLE `o_project_detail`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `project_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `deleted` tinyint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_read_count
-- ----------------------------
DROP TABLE IF EXISTS `o_read_count`;
CREATE TABLE `o_read_count`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `document_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论/文章',
  `document_type` tinyint NOT NULL DEFAULT 1 COMMENT '1-文章 2-评论',
  `cnt` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '计数',
  `deleted` tinyint NOT NULL COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_document_id_type`(`document_id` ASC, `document_type` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_request_count
-- ----------------------------
DROP TABLE IF EXISTS `o_request_count`;
CREATE TABLE `o_request_count`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `host` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '机器IP',
  `cnt` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '计数',
  `date` date NOT NULL COMMENT '当前时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_unique_id_date`(`date` ASC, `host` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_shop
-- ----------------------------
DROP TABLE IF EXISTS `o_shop`;
CREATE TABLE `o_shop`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `type` int NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `phone_number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `short_description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `place_id` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL DEFAULT '',
  `deleted` tinyint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for o_tag
-- ----------------------------
DROP TABLE IF EXISTS `o_tag`;
CREATE TABLE `o_tag`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '标签名称',
  `tag_type` tinyint NOT NULL DEFAULT 1 COMMENT '1-系统标签 2-自定义标签',
  `status` tinyint NOT NULL DEFAULT 0 COMMENT '0-未发布 1-已发布',
  `deleted` tinyint NOT NULL DEFAULT 0,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_user
-- ----------------------------
DROP TABLE IF EXISTS `o_user`;
CREATE TABLE `o_user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key_user_name`(`email` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_user_foot
-- ----------------------------
DROP TABLE IF EXISTS `o_user_foot`;
CREATE TABLE `o_user_foot`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `document_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT 'article id(article/comment)',
  `document_type` tinyint NOT NULL DEFAULT 1 COMMENT '1-article 2-comment',
  `document_user_id` bigint UNSIGNED NOT NULL DEFAULT 0 COMMENT '作者id',
  `collection_stat` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未收藏 1-收藏中 2-取消收藏',
  `read_stat` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未读 1-已读',
  `comment_stat` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未评论 1-已评论 2-删除评论',
  `upvote_stat` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未点赞 1-已点赞 2-取消点赞',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_user_document`(`user_id` ASC, `document_id` ASC, `document_type` ASC) USING BTREE,
  INDEX `idx_document_id`(`document_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_user_info
-- ----------------------------
DROP TABLE IF EXISTS `o_user_info`;
CREATE TABLE `o_user_info`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `gender` tinyint(3) UNSIGNED ZEROFILL NOT NULL DEFAULT 000 COMMENT '性别',
  `pronoun` tinyint NOT NULL DEFAULT 0 COMMENT '称呼',
  `om_value` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '身价',
  `credit` int NOT NULL DEFAULT 0 COMMENT '积分',
  `photo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头像',
  `my_position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '职位',
  `university` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '学校',
  `profile` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '个人简介',
  `user_role` int NOT NULL DEFAULT 0 COMMENT '0-user 1-admin',
  `birthday` date NULL DEFAULT NULL,
  `qrcode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'qrcode content',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `key_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for o_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `o_user_relation`;
CREATE TABLE `o_user_relation`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` bigint UNSIGNED NOT NULL DEFAULT 0,
  `follow_user_id` bigint NOT NULL,
  `follow_state` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '0-未关注 1-关注中 2-未关注',
  `deleted` tinyint NOT NULL DEFAULT 0 COMMENT '是否删除',
  `creat_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_user_follow`(`user_id` ASC, `follow_user_id` ASC) USING BTREE,
  INDEX `key_follow_user_id`(`follow_user_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
